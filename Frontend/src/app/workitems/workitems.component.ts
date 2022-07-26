/// @ts-nocheck
import {Component, ViewChild, OnInit } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { WorkitemService } from '../workitem.service';
import { Router } from '@angular/router';

export interface Workitem {
  workitemId: number;
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

@Component({
  selector: 'app-workitems',
  templateUrl: './workitems.component.html',
  styleUrls: ['./workitems.component.css']
})

export class WorkitemsComponent implements OnInit  {
  displayedColumns: string[] = ['id', 'itemName', 'itemType', 'quantity', 'sourceCountry', 'destinationCountry', 'shippingDate', 'amount', 'action' ];
  workitemData = []
  dataSource!: MatTableDataSource<Workitem>;
  isModalOpen: boolean = false;
  itemData!: Workitem;
  isUpdateFormOpen: boolean = false;
  workItemUpdateForm!: FormGroup;
  minDate = new Date();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private fb: FormBuilder, private workitemService: WorkitemService, private router: Router) {  }

  ngOnInit() {
    this.workitemService.getWorkItems().subscribe({next: data => {
      for (var row in data) {
        if(data[row].userId == parseInt(localStorage.getItem('userId'))) {
            this.workitemData.push(data[row])
        }
      }
    }, 
      complete: ()=>{this.dataSource = new MatTableDataSource<Workitem>(this.workitemData)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;}}) 
  }
  get f(){
    return this.workItemUpdateForm.controls;
  }
  saveWorkItem(){
    console.log(this.workItemUpdateForm);
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

