import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  profileData : any
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.loginService.getProfile(localStorage.getItem('userId')).subscribe(
      (data) => this.profileData = data
    )
  }

}
