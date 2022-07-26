import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isAdmin : any
  
  public logoutBtn() {
    localStorage.clear()
    this.router.navigate(['/']);  
  }
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.isAdmin = localStorage.getItem('isAdmin')
  }

}
