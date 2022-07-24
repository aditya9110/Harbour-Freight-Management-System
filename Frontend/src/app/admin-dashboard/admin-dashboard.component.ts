import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements AfterViewInit {

  @ViewChild('paginator') paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  selectedValue!: string;
  foods = [
    {viewValue: 'Steak'},
    {viewValue: 'Pizza'},
    {viewValue: 'Tacos'},
  ];

  displayedColumns = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<WorkItem>(ELEMENT_DATA);

  constructor() { }

  ngOnInit(): void {
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}

export interface WorkItem {
  workItemId:string,
    userId:number,
    itemName:string,
    itemType:string,
    itemDescription:string,
    messageToRecipient:string,
    capacity:number,
    fromCountry:string,
    destinationCountry:string ,
    availableHarborLocations:string,
    shippingDate:string
}

const ELEMENT_DATA : WorkItem[]= [
  {
    workItemId:"J2012",
    userId: 10001,
    itemName: "UPS",
    itemType:"Computer Hardware",
    itemDescription:"Luminous Inverter battery Combo 1100+150AH",
    messageToRecipient:"Please confirm once recived.",
    capacity:7500,
    fromCountry:"India" ,
    destinationCountry:"Singapore" ,
    availableHarborLocations: "Tanjong Pagar",
    shippingDate:'12-Aug-20'
},
];
