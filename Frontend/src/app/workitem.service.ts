import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorkitemService {

  constructor(private http: HttpClient) { }
  
  private url = 'http://localhost:9000/ftr/workItems'

  getWorkItems() : Observable<any> {
    return this.http.get(this.url)
  }

  addWorkItems(data:any) : Observable<any> {
    return this.http.post(this.url, data)
  }

  getHarbor(country:any) : Observable<any> {
    return this.http.get(this.url + `/${country}`)
  }

  updateStatus(id:any) : Observable<any> {
    return this.http.put(this.url + `/managed-update/${id}`, id)
  }

}
