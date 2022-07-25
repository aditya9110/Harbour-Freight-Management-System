import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide:boolean= true;
  userForm!:FormGroup;


  constructor(private formBuilder:FormBuilder){}

  ngOnInit(): void {
    this.userForm=this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.maxLength(20)]],
      lastName: ['', [Validators.required, Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email]],
      mobno: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      password: ['', [Validators.required,Validators.pattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{7, 15}$")]],
      nationality: ['', [Validators.required, Validators.maxLength(20)]],
      passportno: ['', [Validators.required, Validators.minLength(7),Validators.maxLength(12)]],
      permanentAddress: ['', [Validators.required, Validators.maxLength(200)]],
      officeAddress: ['', [Validators.required, Validators.maxLength(200)]],
      pidno: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{12}$")]]
  
    });
  }
 

  // ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 15}$

  get f(){
    return this.userForm.controls;
  }

  registerUser(){
    console.log('Form data is ', this.userForm.value);
  }
}
