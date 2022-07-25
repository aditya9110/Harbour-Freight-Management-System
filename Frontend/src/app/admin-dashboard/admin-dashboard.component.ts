import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

export interface WorkItem {
    workItemId:string,
    userId:number,
    itemName:string,
    itemType:string,
    itemDescription:string,
    messageToRecipient:string,
    quantity:number,
    amount:number
    sourceCountry:string,
    destinationCountry:string ,
    originHarborLocation: string,
    selectedHarborLocations: string,
    shippingDate:string
}

const WorkItemData : WorkItem[]= [
  {
    workItemId:"J2012",
    userId: 10001,
    itemName: "UPS",
    itemType:"Computer Hardware",
    itemDescription:"Luminous Inverter battery Combo 1100+150AH",
    messageToRecipient:"Please confirm once recived.",
    quantity:7500,
    amount: Math.round(Math.random() * 100),
    sourceCountry:"India" ,
    destinationCountry:"Singapore" ,
    originHarborLocation: 'Kochi',
    selectedHarborLocations: 'dc',
    shippingDate:'12-Aug-2020'
  },
]

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements AfterViewInit {

  @ViewChild('paginator') paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  displayedColumns: string[] = ['id', 'itemName', 'itemType', 'quantity', 'sourceCountry', 'destinationCountry', 'shippingDate', 'amount', 'action' ];
  dataSource = new MatTableDataSource<WorkItem>(WorkItemData);
  isModalOpen: boolean = false;
  itemData!: WorkItem;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  
  openModal(data: WorkItem){
    this.isModalOpen = true;
    this.itemData = data;
    console.log(data);
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

}
