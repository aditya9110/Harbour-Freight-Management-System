import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { WorkitemService } from '../workitem.service';

export interface Workitem {
    workitemId:string,
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

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  @ViewChild('paginator') paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  displayedColumns: string[] = ['id', 'itemName', 'itemType', 'quantity', 'sourceCountry', 'destinationCountry', 'shippingDate', 'amount', 'action' ];
  workitemData = []
  dataSource!: MatTableDataSource<Workitem>;
  isModalOpen: boolean = false;
  itemData!: Workitem;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();
  isDeleteModalOpen:boolean = false;

  constructor(private workitemService: WorkitemService, private router: Router) { }

  ngOnInit() {
    this.workitemService.getWorkItems().subscribe({next: data => this.workitemData = data, 
      complete: ()=>{this.dataSource = new MatTableDataSource<Workitem>(this.workitemData)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;}}) 
  }
  
  openModal(data: Workitem){
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

  // updateWorkStatus(row:any) {
  //   this.workitemService.updateStatus(row.workitemId).subscribe(data => console.log(data),
  //     (error) => {console.log(error)})
  // }

  reloadCurrentRoute() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([currentUrl]);
    });
  }
}
