import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {AllConferenceComponent} from "./all-conference/all-conference.component";
import {CreateConferenceComponent} from "./create-conference/create-conference.component";
import {ConferenceOverviewComponent} from "./conference-overview/conference-overview.component";
import {PcmemberRegistrationConferenceComponent} from "./pcmember-registration-conference/pcmember-registration-conference.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'all-conferences', component: AllConferenceComponent},
  {path: 'create-conference', component: CreateConferenceComponent},
  {path: 'conference-overview/:id', component: ConferenceOverviewComponent},
  {path: 'pcmember-registration-conference/:id', component: PcmemberRegistrationConferenceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
