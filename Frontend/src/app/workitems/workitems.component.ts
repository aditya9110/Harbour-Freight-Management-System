import { AfterViewInit, Component, ViewChild, OnInit } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

export interface Workitem {
  id: number;
  itemName: string;
  itemType: string;
  itemDescription: string;
  messageToRecipient: string;
  quantity: string;
  sourceCountry: string;
  destinationCountry: string;
  originHarborLocation: string;
  selectedHarborLocations: string;
  shippingDate: string;
  amount: number;
}

/** Constants used to fill up our data base. */
const FRUITS: string[] = [
  'blueberry',
  'lychee',
  'kiwi',
  'mango',
  'peach',
  'lime',
  'pomegranate',
  'pineapple',
];
const NAMES: string[] = [
  'Maia',
  'Asher',
  'Olivia',
  'Atticus',
  'Amelia',
  'Jack',
  'Charlotte',
  'Theodore',
  'Isla',
  'Oliver',
  'Isabella',
  'Jasper',
  'Cora',
  'Levi',
  'Violet',
  'Arthur',
  'Mia',
  'Thomas',
  'Elizabeth',
];

@Component({
  selector: 'app-workitems',
  templateUrl: './workitems.component.html',
  styleUrls: ['./workitems.component.css']
})
export class WorkitemsComponent implements AfterViewInit , OnInit  {
  displayedColumns: string[] = ['id', 'itemName', 'itemType', 'quantity', 'sourceCountry', 'destinationCountry', 'shippingDate', 'amount', 'action' ];
  dataSource: MatTableDataSource<Workitem>;
  isModalOpen: boolean = false;
  itemData!: Workitem;
  isUpdateFormOpen: boolean = false;
  workItemUpdateForm!: FormGroup;
  minDate = new Date();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  constructor(private fb: FormBuilder) {
    // Create 100 users
    const items = Array.from({length: 100}, (_, k) => createNewUser(k + 1));

    // Assign the data to the data source for the table to render

    this.dataSource = new MatTableDataSource(items);
    console.log(this.dataSource)
  }

  

  ngOnInit() {
    // this.workItemUpdateForm = this.fb.group({
    //   itemName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(25)]],
    //   itemType: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(25)]],
    //   itemDescription: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(45)]],
    //   messageToRecipient: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(50)]],
    //   capacity: ['',Validators.required],
    //   sourceCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
    //   destinationCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
    //   availableHarborLocation: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
    //   shippingDate: ['',Validators.required,Validators],
    //   amount: ['',Validators.required],
    // })
    console.log("init");
  }
  get f(){
    return this.workItemUpdateForm.controls;
  }
  saveWorkItem(){
    console.log(this.workItemUpdateForm);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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

  openUpdateWorkItem(){
    this.isUpdateFormOpen = true;
    this.workItemUpdateForm = this.fb.group({
      itemName: [this.itemData.itemName,[Validators.required,Validators.minLength(3),Validators.maxLength(25)]],
      itemType: [this.itemData.itemType,[Validators.required,Validators.minLength(4),Validators.maxLength(25)]],
      itemDescription: [this.itemData.itemDescription,[Validators.required,Validators.minLength(10),Validators.maxLength(45)]],
      messageToRecipient: [this.itemData.messageToRecipient,[Validators.required,Validators.minLength(10),Validators.maxLength(50)]],
      capacity: [this.itemData.quantity,Validators.required],
      sourceCountry: [this.itemData.sourceCountry,[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      destinationCountry: [this.itemData.destinationCountry,[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      availableHarborLocation: [this.itemData.selectedHarborLocations,[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      shippingDate: [new Date(this.itemData.shippingDate),Validators.required],
      amount: ['',Validators.required],
    })
    console.log("odal");
  }

  closeUpdateWorkItem(){
    this.isUpdateFormOpen = false;
  }
}

/** Builds and returns a new User */
function createNewUser(id: number): Workitem {
  const name =
    NAMES[Math.round(Math.random() * (NAMES.length - 1))] +
    ' ' +
    NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) +
    '.';

  return {
    id: id,
    itemName: name.toString(),
    itemType: 'hardware',
    quantity: '100 kg',
    sourceCountry: 'India',
    destinationCountry: 'USA',
    shippingDate: '20-Jan-2000',
    amount: Math.round(Math.random() * 100),
    itemDescription: 'Computer Accessories',
    messageToRecipient: 'Handle with care',
    originHarborLocation: 'Kochi',
    selectedHarborLocations: 'dc',
  }
}

