import { Component } from '@angular/core';
import { FormBuilder, FormControl, Validators, } from '@angular/forms';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent {
  title="ftr";
  hide=true;
  constructor(private formBuilder:FormBuilder){}

  userForm=this.formBuilder.group({
    firstName:new FormControl('shubham', [Validators.required, Validators.maxLength(20)]),
    lastName:new FormControl('', [Validators.required, Validators.maxLength(20)]),
    email:new FormControl('', [Validators.required, Validators.email]),
    mobno:new FormControl ('', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]),
    password:new FormControl('', [Validators.required, Validators.minLength(7),Validators.maxLength(15)]),
    nationality:new FormControl('', [Validators.required, Validators.maxLength(20)]),
    passportno:new FormControl('', [Validators.required, Validators.minLength(7),Validators.maxLength(12)]),
    permanentAddress:new FormControl('', [Validators.required, Validators.maxLength(200)]),
    officeAddress:new FormControl('', [Validators.required, Validators.maxLength(200)]),
    pidno:new FormControl ('', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{12}$")])

  });
  get f(){
    return this.userForm.controls;
  }

  saveForm(){
    console.log('Form data is ', this.userForm.value);
  }

}