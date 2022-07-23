import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-terminal-form',
  templateUrl: './update-terminal-form.component.html',
  styleUrls: ['./update-terminal-form.component.css']
})
export class UpdateTerminalFormComponent implements OnInit {

  // TODO: routing se terminal id lena hai
  terminal = {
    "terminalId": "T10",
    "terminalName": "Fremantle",
    "country": "Australia",
    "itemType": "Electronics",
    "terminalDescription": "T10-Electronics",
    "capacity": 94700,
    "availableCapacity": 20000,
    "status": "AVAILABLE"
  }

  newCapValue = this.terminal.availableCapacity
  updateCapacity(val:any) {
    console.log(this.newCapValue)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
