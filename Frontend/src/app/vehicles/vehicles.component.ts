import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Terminal } from '../terminals/terminals.component';
import { VehicleService } from '../vehicle.service';

export interface Vehicle {
  vehicleNumber:string,
  vehicleName:string,
  maxLiftingCapacity:number,
  retireDate:string,
  vehicleStatus:string,
  country:string,
  harborLocation:string
}

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  displayedColumns: string[] = 
  ['vehicleNumber', 'vehicleName', 'maxLiftingCapacity', 'retireDate', 'country', 'vehicleStatus', 'harborLocation', 'action'];
  vehiclesData = []
  dataSource!: MatTableDataSource<Vehicle>;
  isModalOpen: boolean = false;
  itemData!: Vehicle;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();
  isDeleteModalOpen : boolean = false
  newStatus = this.itemData ? this.itemData.vehicleStatus : ''

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit(): void {
    this.vehicleService.getVehicleData().subscribe({next: data => this.vehiclesData = data, 
      complete: ()=>{this.dataSource = new MatTableDataSource<Vehicle>(this.vehiclesData)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;}}) 
  }
  
  openModal(data: Vehicle){
    this.isModalOpen = true;
    this.itemData = data;
  }

  closeModal(){
    this.isModalOpen = false;
  }

  applyFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    
    this.dataSource.filter = filterValue.trim().toLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  updateStatus(val:any) {
    console.log(this.newStatus)
  }

  deleteVehicle() {
    this.vehicleService.deleteVehicleData(this.itemData.vehicleNumber).subscribe(
      data => {console.log(data)}, error => {
        this.isDeleteModalOpen = false
        this.reloadCurrentRoute()
      })
  }

  reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }
}
