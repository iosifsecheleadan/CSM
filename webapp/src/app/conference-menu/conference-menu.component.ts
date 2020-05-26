import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../service/user-service";
import {Router} from "@angular/router";
import {User} from "../model/user";
import {Conference} from "../model/conference";

@Component({
  selector: 'app-conference-menu',
  templateUrl: './conference-menu.component.html',
  styleUrls: ['./conference-menu.component.css']
})
export class ConferenceMenuComponent implements OnInit {

  user: User;
  @Input()
  conference: Conference;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = this.userService.getCurrentUser();
  }

}
