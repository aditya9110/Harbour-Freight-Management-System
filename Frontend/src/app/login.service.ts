import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private url = 'http://localhost:9000/ftr/userProfile'

  getUserData(data:any) : Observable<any> {
    return this.http.post(this.url + '/login', data)
  }

  registerUser(data:any) : Observable<any> {
    return this.http.post(this.url, data)
  }

  updateUser(id:any, data:any) : Observable<any> {
    return this.http.put(this.url + `/${id}`, data)
  }

  getProfile(id:any) : Observable<any> {
    return this.http.get(this.url + `/${id}`)
  }

  public isloggedIn = false;

//   isUserAuthenticated(username: string, password: string): Observable<boolean> {
//     return this.getUserData().pipe(
//         map(users => {
//             const Authenticateduser = users.find(user => (user.username === username) && (user.password === password));
//             if (Authenticateduser) {
//                 this.isloggedIn = true;
//             } else {
//                 this.isloggedIn = false;
//             }
//             return this.isloggedIn;
//         })
//     );
//   }

//   isUserLoggedIn(): boolean {
//     return this.isloggedIn;
// }
}
