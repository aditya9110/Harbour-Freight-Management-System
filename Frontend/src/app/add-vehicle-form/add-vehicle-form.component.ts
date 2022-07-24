import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-vehicle-form',
  templateUrl: './add-vehicle-form.component.html',
  styleUrls: ['./add-vehicle-form.component.css']
})
export class AddVehicleFormComponent implements OnInit {

  minDate = new Date();
  constructor(private formBuilder:FormBuilder) { }

  get vehicleNumber() {
    return this.addVehicleForm.controls['vehicleNumber']
  }
  get vehicleName() {
    return this.addVehicleForm.controls['vehicleName']
  }
  get maxLiftingCapacity() {
    return this.addVehicleForm.controls['maxLiftingCapacity']
  }
  get retireDate() {
    return this.addVehicleForm.controls['retireDate']
  }
  get harborLocation() {
    return this.addVehicleForm.controls['harborLocation']
  }
  get country() {
    return this.addVehicleForm.controls['country']
  }
  get vehicleStatus() {
    return this.addVehicleForm.controls['vehicleStatus']
  }

  addVehicleForm!:FormGroup
  vehicleNameList = ['Tower Crane', 'Fireplace Crane', 'Double Treadwheel Crane', 'Crawler Crane', 'Aerial Crane', 'Deck Crane']
  ngOnInit(): void {
    this.addVehicleForm=this.formBuilder.group({
      vehicleNumber:['',[Validators.required, this.validateVehicleNumber]],
      vehicleName:['',Validators.required],
      maxLiftingCapacity:['',Validators.required],
      retireDate:['',Validators.required],
      harborLocation:['',[Validators.required, Validators.minLength(5), Validators.maxLength(25)]],
      country:['',[Validators.required, Validators.minLength(5), Validators.maxLength(25)]],
      vehicleStatus:['Active',Validators.required],
      });
  }
  
  validateVehicleNumber(f: FormControl): any {
    let valRegExp = /^([A-Z]{2})([0-9]{4})$/;
    return valRegExp.test(f.value) ? null : {
      vehicleNumberInvalid: {
        message: "2 alphabets followed by 4 numbers allowed"
      }
    };
  }

  addVehicle() {

  }

}
