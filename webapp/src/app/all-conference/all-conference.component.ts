import {Component, Input, OnInit} from '@angular/core';
import {User} from "../model/user";
import {UserService} from "../service/user-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-conference',
  templateUrl: './all-conference.component.html',
  styleUrls: ['./all-conference.component.css']
})

export class AllConferenceComponent implements OnInit {

  user: User;

  constructor(private userService: UserService, private router: Router) {
    this.user = this.userService.getCurrentUser();
  }

  ngOnInit(): void {
  }

}
