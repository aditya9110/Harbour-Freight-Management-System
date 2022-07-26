import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTerminalFormComponent } from './add-terminal-form/add-terminal-form.component';
import { AddVehicleFormComponent } from './add-vehicle-form/add-vehicle-form.component';
import { AddWorkitemComponent } from './add-workitem/add-workitem.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AppComponent } from './app.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { HomeComponent } from './home/home.component';
import { LoginNewComponent } from './login-new/login-new.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { TerminalsComponent } from './terminals/terminals.component';
import { UserComponent } from './user/user.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { WorkitemsComponent } from './workitems/workitems.component';

const routes: Routes = [
  // logged out
  { path: 'home', component: HomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'login', component: LoginNewComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'navbar', component: NavbarComponent},
  
  // user
  { path: 'profile', component: UserComponent},
  { path: 'edit-profile', component: EditProfileComponent},
  { path: 'workitem', component: WorkitemsComponent},
  { path: 'add-workitem', component: AddWorkitemComponent},

  // admin
  { path: 'admin-workitem', component: AdminDashboardComponent},
  { path: 'terminals', component: TerminalsComponent},
  { path: 'add-terminal', component: AddTerminalFormComponent},
  { path: 'vehicles', component: VehiclesComponent},
  { path: 'add-vehicle', component: AddVehicleFormComponent},

  { path: '**', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
