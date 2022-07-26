import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }
  
  private url = 'http://localhost:9000/ftr/vehicles'

  getVehicleData() : Observable<any> {
    return this.http.get(this.url)
  }

  addVehicleData(data:any) : Observable<any> {
    return this.http.post(this.url, data)
  }

  deleteVehicleData(id:any) : Observable<any> {
    return this.http.delete(this.url + `/${id}`)
  }
}
