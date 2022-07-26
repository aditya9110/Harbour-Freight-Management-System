import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { TerminalService } from '../terminal.service';

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

@Component({
  selector: 'app-terminals',
  templateUrl: './terminals.component.html',
  styleUrls: ['./terminals.component.css']
})
export class TerminalsComponent implements OnInit {

  displayedColumns: string[] = 
  ['terminalId', 'terminalName', 'country', 'itemType','availableCapacity', 'harborLocation', 'status', 'action'];
  terminalsData = []
  dataSource! : MatTableDataSource<Terminal>;
  isModalOpen: boolean = false;
  itemData!: Terminal;
  isUpdateFormOpen: boolean = false;
  minDate = new Date();
  isDeleteModalOpen:boolean = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private terminalService: TerminalService, private router: Router,) { }

  ngOnInit(): void {
    this.terminalService.getTerminalData().subscribe({next: data => this.terminalsData = data, 
      complete: ()=>{this.dataSource = new MatTableDataSource<Terminal>(this.terminalsData)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;}}) 
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

  deleteTerminal() {
    this.terminalService.deleteTerminalData(this.itemData.terminalId).subscribe(
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
