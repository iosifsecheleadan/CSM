import {Conference} from "./conference";
import {ProgramCommitteeMember} from "./program-committee-member";

export class Section {
  id: number;
  conference: Conference;
  mainChair: ProgramCommitteeMember;
  room: string;
  noSeats: number;
  listenerFee: number;
}
