import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

export interface Terminal {
    terminalId: string,
    terminalName: string,
    country: string,
    itemType: string,
    terminalDescription: string,
    capacity: number,
    availableCapacity: number,
    harborLocation: string,
    status: string
}

const terminalsData = [{
  terminalId: "T10",
  terminalName: "Fremantle",
  country: "Australia",
  itemType: "Electronics",
  terminalDescription: "T10-Electronics",
  capacity: 94700,
  availableCapacity: 20000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T11",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Computer Hardware",
  terminalDescription: "T1-Computer Hardware",
  capacity: 50000,
  availableCapacity: 40000,
  harborLocation: "Sydney Harbor",
  status: "NOTAVAILABLE"
},
{
  terminalId: "T12",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Computer Hardware",
  terminalDescription: "T1-Computer Hardware",
  capacity: 50000,
  availableCapacity: 40000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T13",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Computer Hardware",
  terminalDescription: "T1-Computer Hardware",
  capacity: 50000,
  availableCapacity: 40000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T14",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Oil Container",
  terminalDescription: "T13-Container Terminal",
  capacity: 80000,
  availableCapacity: 40000,
  harborLocation: "Sydney Harbor",
  status: "NOTAVAILABLE"
},
{
  terminalId: "T15",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Computer Hardware",
  terminalDescription: "T15-Computer Hardware",
  capacity: 50000,
  availableCapacity: 40000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T16",
  terminalName: "Fremantle2",
  country: "Australia",
  itemType: "Electronics",
  terminalDescription: "T11-Electronics",
  capacity: 74700,
  availableCapacity: 20000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T17",
  terminalName: "Fremantle2",
  country: "Australia",
  itemType: "Electronics",
  terminalDescription: "T11-Electronics",
  capacity: 74700,
  availableCapacity: 6000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},
{
  terminalId: "T18",
  terminalName: "Kakinada",
  country: "India",
  itemType: "Computer Hardware",
  terminalDescription: "T20-Computer Hardware",
  capacity: 50000,
  availableCapacity: 30000,
  harborLocation: "Sydney Harbor",
  status: "AVAILABLE"
},]

@Component({
  selector: 'app-terminals',
  templateUrl: './terminals.component.html',
  styleUrls: ['./terminals.component.css']
})
export class TerminalsComponent implements AfterViewInit, OnInit {

  displayedColumns: string[] = 
  ['terminalId', 'terminalName', 'country', 'itemType','availableCapacity', 'harborLocation', 'status', 'action'];
  dataSource = new MatTableDataSource<Terminal>(terminalsData);
  isModalOpen: boolean = false;
  itemData!: Terminal;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor() { }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  openModal(data: Terminal){
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

  newCapValue = this.itemData ? this.itemData.availableCapacity : ''
  updateCapacity(val:any) {
    console.log(this.newCapValue)
  }

}
