import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TerminalService } from '../terminal.service';

@Component({
  selector: 'app-add-terminal-form',
  templateUrl: './add-terminal-form.component.html',
  styleUrls: ['./add-terminal-form.component.css'],
})
export class AddTerminalFormComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private terminalService: TerminalService, private router: Router,) { }

  get terminalName() {
    return this.addTerminalForm.controls['terminalName']
  }
  get country() {
    return this.addTerminalForm.controls['country']
  }
  get itemType() {
    return this.addTerminalForm.controls['itemType']
  }
  get harborLocation() {
    return this.addTerminalForm.controls['harborLocation']
  }
  get terminalDescription() {
    return this.addTerminalForm.controls['terminalDescription']
  }
  get capacity() {
    return this.addTerminalForm.controls['capacity']
  }
  get availableCapacity() {
    return this.addTerminalForm.controls['availableCapacity']
  }
  get status() {
    return this.addTerminalForm.controls['status']
  }

  addTerminalForm!:FormGroup
  ngOnInit(): void {
    this.addTerminalForm=this.formBuilder.group({
      terminalName:['',[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      country:['',[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      itemType:['',[Validators.required, Validators.minLength(4), Validators.maxLength(30)]],
      harborLocation:['',[Validators.required, Validators.minLength(5), Validators.maxLength(25)]],
      terminalDescription:['',[Validators.required, Validators.maxLength(25), this.validateTerminalDescription]],
      capacity:['',[Validators.required, Validators.max(99999)]],
      availableCapacity:['',[Validators.required, Validators.max(99999)]],
      status:['Available',Validators.required],
      });
  }

  validateTerminalDescription(f:FormControl) : any {
    const valRegExp = /^[a-zA-Z0-9-]*$/
    return valRegExp.test(f.value) ? null : {
      descInvalid: {
        message: "Alphanumeric and hypen(-) is allowed"
      }
    };
  }

  addTerminal() {
    this.terminalService.addTerminalData(this.addTerminalForm.value).subscribe(() => {this.router.navigate(['/terminals'])})
  }
}
