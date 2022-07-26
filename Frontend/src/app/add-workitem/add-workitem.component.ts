import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { WorkitemService } from '../workitem.service';

@Component({
  selector: 'app-add-workitem',
  templateUrl: './add-workitem.component.html',
  styleUrls: ['./add-workitem.component.css']
})
export class AddWorkitemComponent implements OnInit {
  workItemForm!: FormGroup;
  minDate = new Date();
  itemList = ['Computer Hardware', 'Oil Container', 'Wood', 'Motorcycles', 'Electonics']
  harborList = []

  constructor(private fb: FormBuilder, private workitemService: WorkitemService, private router: Router) { }

  ngOnInit() {
    this.workItemForm = this.fb.group({
      userId: [localStorage.getItem('userId')],
      itemName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(25)]],
      itemType: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(25)]],
      itemDescription: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(45)]],
      messageToRecipient: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(50)]],
      quantity: ['',Validators.required],
      sourceCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      destinationCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      availableHarborLocations: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      shippingDate: ['',Validators.required],
    })
  }
  get f(){
    return this.workItemForm.controls;
  }
  createWorkItem(){
    console.log(this.workItemForm.value)
    this.workitemService.addWorkItems(this.workItemForm.value).subscribe(() => {this.router.navigate(['/workitem'])})
  }

  countryClick(country:any) {
    console.log(country)
  }
}
