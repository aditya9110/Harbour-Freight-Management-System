import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-workitem',
  templateUrl: './add-workitem.component.html',
  styleUrls: ['./add-workitem.component.css']
})
export class AddWorkitemComponent implements OnInit {
  workItemForm!: FormGroup;
  minDate = new Date();

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.workItemForm = this.fb.group({
      itemName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(25)]],
      itemType: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(25)]],
      itemDescription: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(45)]],
      messageToRecipient: ['',[Validators.required,Validators.minLength(10),Validators.maxLength(50)]],
      capacity: ['',Validators.required],
      sourceCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      destinationCountry: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      availableHarborLocation: ['',[Validators.required,Validators.minLength(5),Validators.maxLength(25)]],
      shippingDate: ['',Validators.required,Validators],
      amount: ['',Validators.required],
    })
  }
  get f(){
    return this.workItemForm.controls;
  }
  createWorkItem(){
    console.log(this.workItemForm);
  }
}
