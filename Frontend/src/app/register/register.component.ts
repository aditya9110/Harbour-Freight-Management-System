import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide:boolean= true;
  userForm!:FormGroup;


  constructor(private formBuilder:FormBuilder, private loginService: LoginService, private router: Router){}

  ngOnInit(): void {
    this.userForm=this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.maxLength(20)]],
      lastName: ['', [Validators.required, Validators.maxLength(20)]],
      emailId: ['', [Validators.required, Validators.email]],
      mobileNumber: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      password: ['', Validators.required],
      nationality: ['', [Validators.required, Validators.maxLength(20)]],
      passportNumber: ['', [Validators.required, Validators.minLength(7),Validators.maxLength(12)]],
      permanentAddress: ['', [Validators.required, Validators.maxLength(200)]],
      officeAddress: ['', [Validators.required, Validators.maxLength(200)]],
      personalIdentificationNumber: ['', [Validators.required, Validators.pattern("^[0-9]{12}$")]]
  
    });
  }
 

  get f(){
    return this.userForm.controls;
  }

  registerUser(){
    this.loginService.registerUser(this.userForm.value).subscribe(
      data => {this.router.navigate(['/login']);})
    // console.log('Form data is ', this.userForm.value);
  }
}
