import {User} from "./user";

export class ProgramCommitteeMember {
  user: User;
  name: string;
  affiliation: string;
  email: string;
  webPage: string;
  isCoChair: boolean;
  hasRegistered: boolean;
}
