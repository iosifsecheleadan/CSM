import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Review} from "../model/review";
import {Message} from "../model/message";

@Injectable()
export class ReviewService {
  private reviewsUrl = 'https://localhost:8080/reviews';

  constructor(private httpClient: HttpClient) {}

  addReview(review: Review) {
    return this.httpClient.post<Message>(this.reviewsUrl, review);
  }
}
