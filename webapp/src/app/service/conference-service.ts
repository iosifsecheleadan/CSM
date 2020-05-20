import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Conference} from "../model/conference";
import {Message} from "../model/message";

@Injectable()
export class ConferenceService {
  private conferencesUrl = 'http://localhost:8080/conferences';

  constructor(private httpClient: HttpClient) {
  }

  addConference(conference: Conference): Observable<Message> {
    return this.httpClient.post<Message>(this.conferencesUrl, conference);
  }

  getConferences(): Observable<Array<Conference>> {
    console.log("getting conf");
    return this.httpClient.get<Array<Conference>>(this.conferencesUrl);
  }

}
