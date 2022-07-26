import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login-new',
  templateUrl: './login-new.component.html',
  styleUrls: ['./login-new.component.css']
})
export class LoginNewComponent implements OnInit {
  loginForm!: FormGroup;
  hide:boolean= true;
  isAdmin = false;

  constructor(private fb: FormBuilder, private loginService: LoginService, private router: Router,) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['',[Validators.required,Validators.email]],
      password: ['',Validators.required]
    })
  }

  get f(){
    return this.loginForm.controls;
  }

  errorMsg = ''
  login(){
    this.loginService.getUserData(this.loginForm.value).subscribe((data) => {
      this.isAdmin = data.userType
      localStorage.setItem('userId', data.userId)
      localStorage.setItem('isAdmin', data.userType)
      if(this.isAdmin) this.router.navigate(['/admin-workitem']);
      else this.router.navigate(['/workitem']);
    }, error => this.errorMsg = error.error.message)
    console.log(this.loginForm);
    
  }

}
