import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddWorkitemComponent } from './add-workitem/add-workitem.component';
import { AppComponent } from './app.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { LoginNewComponent } from './login-new/login-new.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { WorkitemsComponent } from './workitems/workitems.component';

const routes: Routes = [
  { path: '', component: WorkitemsComponent},
  { path: 'login', component: LoginNewComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'dashboard', component: UserComponent},
  { path: 'dashboard/edit-profile', component: EditProfileComponent  },
  { path: 'add-workitem', component: AddWorkitemComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
