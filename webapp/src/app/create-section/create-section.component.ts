import {Component, OnInit} from "@angular/core";
import {Conference} from "../model/conference";
import {Section} from "../model/section";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ProgramCommitteeMember} from "../model/program-committee-member";
import {ConferenceService} from "../service/conference-service";
import {SectionService} from "../service/section-service";

@Component({
  selector: 'app-create-section',
  templateUrl: './create-section.component.html',
  styleUrls: ['./create-section.component.css']
})
export class CreateSectionComponent implements OnInit {
  conference: Conference;
  conferences: Observable<Array<Conference>>;
  formSection: FormGroup;
  errorMessage: string;

  constructor(private sectionService: SectionService,
              private conferenceService: ConferenceService,
              private router: Router,
              private formBuilder: FormBuilder) {
    this.conferences = this.conferenceService.getConferences()
    this.formCreate = this.formBuilder.group({
      mainChair: [],
      room: [],
      noSeats: [],
      fee: []
    });
    this.errorMessage = "";
  }

  ngOnInit(): void {
  }

  makeSection(conference, mainChair, room, noSeats, fee) : Section {
    return {
      id: 0,
      conference: conference,
      mainChair: mainChair,
      room: room,
      noSeats: noSeats,
      listenerFee: fee
    };
  }

  onSubmit(): void {
    this.errorMessage = "";
    if (this.formSection.value["mainChair"] === null) {
      this.errorMessage += "You must choose the main chair.\n";
    } if (this.formSection.value["room"] === null) {
      this.errorMessage += "You must mention the room.\n";
    } if (this.formSection.value["noSeats"] === null) {
      this.errorMessage += "You must mention the number of seats.\n";
    } if (this.formSection.value["fee"] === null) {
      this.errorMessage += "You must select a fee.\n";
    }
    const mainChairID = this.formSection.value["mainChair"];
    const mainChair = this.conference.programCommittee.find(pc => {
      if (pc.id == mainChairID) { return pc; }
    });
    const room = this.formSection.value["room"];
    const noSeats = this.formSection.value["noSeats"]
    const fee = this.formSection.value["fee"]

    const section = this.makeSection(this.conference, mainChair, room, noSeats, fee)
    this.sectionService.addSection(section).subscribe(
      (message) => {
        console.log("message: " + message.message);
        if (message.message !== "okay") {
          this.errorMessage += message.message;
        }
        else {
          this.router.navigate(["/conference-overview", this.conference.id]);
        }
      }, (error) => {
        console.log("error " + error);
      }
    );
  }
}
