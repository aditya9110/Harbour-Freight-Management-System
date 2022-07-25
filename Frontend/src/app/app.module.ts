import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { VehicleFilterPipe } from './vehicle-filter.pipe';
import { TerminalsComponent } from './terminals/terminals.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import {MatRadioModule} from '@angular/material/radio';
import {MatIconModule} from '@angular/material/icon';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatDialogModule} from '@angular/material/dialog';
import { AddTerminalFormComponent } from './add-terminal-form/add-terminal-form.component';
import { UpdateTerminalFormComponent } from './update-terminal-form/update-terminal-form.component';
import { AddVehicleFormComponent } from './add-vehicle-form/add-vehicle-form.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatMenuModule } from '@angular/material/menu';
import { LayoutModule } from '@angular/cdk/layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import { UserComponent } from './user/user.component';
import { WorkitemsComponent } from './workitems/workitems.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import { AddWorkitemComponent } from './add-workitem/add-workitem.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { LoginNewComponent } from './login-new/login-new.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    VehicleFilterPipe,
    TerminalsComponent,
    AddTerminalFormComponent,
    UpdateTerminalFormComponent,
    AddVehicleFormComponent,
    VehiclesComponent,
    HomeComponent,
    LoginComponent,
    WorkitemsComponent,
    AddWorkitemComponent,
    EditProfileComponent,
    UserComponent,
    LoginNewComponent,
    RegisterComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatSortModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatRadioModule,
    MatIconModule,
    MatTooltipModule,
    MatDialogModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatGridListModule,
    MatMenuModule,
    LayoutModule,
    BrowserAnimationsModule, 
    ReactiveFormsModule,
    MatSortModule, 
    MatPaginatorModule,
    MatFormFieldModule,
    MatTableModule,
    MatInputModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatSelectModule,
    MatRadioModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
