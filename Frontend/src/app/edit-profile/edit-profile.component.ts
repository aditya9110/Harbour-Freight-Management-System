import { Component } from '@angular/core';
import { FormBuilder, FormControl, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent {
  title="ftr";
  hide=true;
  constructor(private formBuilder:FormBuilder, private loginService: LoginService, private router: Router){}

  userForm=this.formBuilder.group({
    mobileNumber:new FormControl ('', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]),
    permanentAddress:new FormControl('', [Validators.required, Validators.maxLength(200)]),
    officeAddress:new FormControl('', [Validators.required, Validators.maxLength(200)]),
  });
  get f(){
    return this.userForm.controls;
  }

  successMsg = ''
  saveForm(){
    this.loginService.updateUser(localStorage.getItem('userId'), this.userForm.value).subscribe(
      data => {console.log(data)}, error => this.successMsg = error.error.text)
    console.log('Form data is ', this.userForm.value);
  }

}