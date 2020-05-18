import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../user/user";


@Injectable()
export class UserService {
  private usersUrl = 'http://localhost:8080/users';
  private user = null;

  constructor(private httpClient: HttpClient) {
  }

  registerUser(user: User): Observable<User> {
    return this.httpClient.post<User>(this.usersUrl, user);
  }

  loginUser(user: User): Observable<boolean> {
    return this.httpClient.post<boolean>(this.usersUrl + "/exists", user);
  }

  rememberUser(user: User) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }

}
