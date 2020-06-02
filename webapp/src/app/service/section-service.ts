import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Message} from "../model/message";
import {Section} from "../model/section";

@Injectable()
export class SectionService {
  private sectionsUrl = 'http://localhost:8080/sections';

  constructor(private httpClient: HttpClient) {
  }

  addSection(section: Section): Observable<Message> {
    return this.httpClient.post<Message>(this.sectionsUrl, section);
  }
}
