import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TerminalService {

  constructor(private http: HttpClient) { }
  
  private url = 'http://localhost:9000/ftr/terminals'

  getTerminalData() : Observable<any> {
    return this.http.get(this.url + '/list')
  }

  addTerminalData(data:any) : Observable<any> {
    return this.http.post(this.url, data)
  }

  deleteTerminalData(id:any) : Observable<any> {
    return this.http.delete(this.url + `/${id}`)
  }
}
