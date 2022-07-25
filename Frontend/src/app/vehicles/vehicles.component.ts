import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

export interface Vehicle {
  vehicleNumber:string,
  vehicleName:string,
  maxLiftingCapacity:number,
  retireDate:string,
  vehicleStatus:string,
  country:string,
  harborLocation:string
}

const VehiclesData : Vehicle[] = [
  {
    vehicleNumber:"UE7890",
    vehicleName:"Tower crane",
    maxLiftingCapacity: 19.8,
    retireDate:"20-Dec-2030",
    vehicleStatus:"Active",
    country:"Australia",
    harborLocation:"Sydney Harbor"
  },
  {
    vehicleNumber:"UE7850",
    vehicleName:"Tower crane",
    maxLiftingCapacity: 19.8,
    retireDate:"20-Dec-2030",
    vehicleStatus:"Active",
    country:"Singapore",
    harborLocation:"Jurong"
  },      
  {
    vehicleNumber:"WK7876",
    vehicleName:"Fireplace crane",
    maxLiftingCapacity: 7100,
    retireDate:"21-Jan-2022",
    vehicleStatus:"InActive",
    country:"Australia",
    harborLocation:"Syndey Harbor"
  }]

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  displayedColumns: string[] = 
  ['vehicleNumber', 'vehicleName', 'maxLiftingCapacity', 'retireDate', 'country', 'vehicleStatus', 'harborLocation', 'action'];
  dataSource = new MatTableDataSource<Vehicle>(VehiclesData);
  isModalOpen: boolean = false;
  itemData!: Vehicle;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();
  newStatus = this.itemData ? this.itemData.vehicleStatus : ''

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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

}
