import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-terminals',
  templateUrl: './terminals.component.html',
  styleUrls: ['./terminals.component.css']
})
export class TerminalsComponent implements OnInit {

  terminals = [{
    "terminalId": "T10",
    "terminalName": "Fremantle",
    "country": "Australia",
    "itemType": "Electronics",
    "terminalDescription": "T10-Electronics",
    "capacity": 94700,
    "availableCapacity": 20000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T11",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Computer Hardware",
    "terminalDescription": "T1-Computer Hardware",
    "capacity": 50000,
    "availableCapacity": 40000,
    "status": "NOTAVAILABLE"
},
{
    "terminalId": "T12",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Computer Hardware",
    "terminalDescription": "T1-Computer Hardware",
    "capacity": 50000,
    "availableCapacity": 40000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T13",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Computer Hardware",
    "terminalDescription": "T1-Computer Hardware",
    "capacity": 50000,
    "availableCapacity": 40000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T14",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Oil Container",
    "terminalDescription": "T13-Container Terminal",
    "capacity": 80000,
    "availableCapacity": 40000,
    "status": "NOTAVAILABLE"
},
{
    "terminalId": "T15",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Computer Hardware",
    "terminalDescription": "T15-Computer Hardware",
    "capacity": 50000,
    "availableCapacity": 40000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T16",
    "terminalName": "Fremantle2",
    "country": "Australia",
    "itemType": "Electronics",
    "terminalDescription": "T11-Electronics",
    "capacity": 74700,
    "availableCapacity": 20000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T17",
    "terminalName": "Fremantle2",
    "country": "Australia",
    "itemType": "Electronics",
    "terminalDescription": "T11-Electronics",
    "capacity": 74700,
    "availableCapacity": 6000,
    "status": "AVAILABLE"
},
{
    "terminalId": "T18",
    "terminalName": "Kakinada",
    "country": "India",
    "itemType": "Computer Hardware",
    "terminalDescription": "T20-Computer Hardware",
    "capacity": 50000,
    "availableCapacity": 30000,
    "status": "AVAILABLE"
},]

  constructor() { }

  ngOnInit(): void {
  }

}
