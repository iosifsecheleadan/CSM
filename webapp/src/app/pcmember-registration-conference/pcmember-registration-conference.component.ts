import {Component, Input, OnInit} from '@angular/core';
import {ProgramCommitteeMember} from "../model/program-committee-member";
import {ActivatedRoute, Router} from "@angular/router";
import {ConferenceService} from "../service/conference-service";
import {Conference} from "../model/conference";
import {FormBuilder, FormGroup} from "@angular/forms";
import {UserService} from "../service/user-service";

@Component({
  selector: 'app-pcmember-registration-conference',
  templateUrl: './pcmember-registration-conference.component.html',
  styleUrls: ['./pcmember-registration-conference.component.css']
})
export class PcmemberRegistrationConferenceComponent implements OnInit {

  formRegister: FormGroup;
  errorMessage: string;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private conferenceService: ConferenceService, private formBuilder: FormBuilder) {
    this.formRegister = this.formBuilder.group({
      name: [],
      affiliation: [],
      email: [],
      webPage: [],
    });
    this.errorMessage = "";
  }

  ngOnInit(): void {
  }

  onSubmit() {
    const name = this.formRegister.value["name"];
    const affiliation = this.formRegister.value["affiliation"];
    const email = this.formRegister.value["email"];
    const webPage = this.formRegister.value["webPage"];
    const user = this.userService.getCurrentUser();
    const pcMember = {user: user, name: name, affiliation: affiliation, email: email, webPage: webPage, isCoChair: false, hasRegistered: true};
    console.log(pcMember);

    this.conferenceService.registerPCMember(pcMember).subscribe(
      (message) => {
        console.log("message " + message.message)
        if (message.message !== "okay") {
          this.errorMessage = message.message;
        } else {
          this.router.navigateByUrl("/all-conferences")
        }
      }, (error) => {
        console.log("error " + error)
      }
    );
  }

  goBack() {
    this.router.navigateByUrl("/all-conferences");
  }
}
