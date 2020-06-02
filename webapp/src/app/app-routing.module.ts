import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {AllConferenceComponent} from "./all-conference/all-conference.component";
import {CreateConferenceComponent} from "./create-conference/create-conference.component";
import {ConferenceOverviewComponent} from "./conference-overview/conference-overview.component";
import {PcmemberRegistrationConferenceComponent} from "./pcmember-registration-conference/pcmember-registration-conference.component";
import {SubmitPaperComponent} from "./submit-paper/submit-paper.component";
import {UploadAbstractComponent} from "./upload-abstract/upload-abstract.component";
import {UploadFullComponent} from "./upload-full/upload-full.component";
import {UploadPresentationComponent} from "./upload-presentation/upload-presentation.component";
<<<<<<< HEAD
import {ReviewPaperComponent} from "./review-paper/review-paper.component";

=======
import {ParticipateComponent} from "./participate/participate.component";
>>>>>>> 87422708d77c4c166e0455af9e8f8038e4246bd0

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'all-conferences', component: AllConferenceComponent},
  {path: 'create-conference', component: CreateConferenceComponent},
  {path: 'conference-overview/:id', component: ConferenceOverviewComponent},
  {path: 'submit-paper/:id', component: SubmitPaperComponent},
  {path: 'pcmember-registration-conference/:id', component: PcmemberRegistrationConferenceComponent},
  {path: 'upload-abstract/:id', component: UploadAbstractComponent},
  {path: 'upload-full/:id', component: UploadFullComponent},
  {path: 'upload-presentation/:id', component: UploadPresentationComponent},
<<<<<<< HEAD
  {path: 'review-paper/:id', component: ReviewPaperComponent}
=======
  {path: 'participate/:id', component: ParticipateComponent}
>>>>>>> 87422708d77c4c166e0455af9e8f8038e4246bd0
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
