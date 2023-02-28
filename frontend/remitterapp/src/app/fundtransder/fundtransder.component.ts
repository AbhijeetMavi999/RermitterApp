import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';

@Component({
  selector: 'app-fundtransder',
  templateUrl: './fundtransder.component.html',
  styleUrls: ['./fundtransder.component.css']
})
export class FundtransderComponent {

  constructor() {}

  ngOnInit() {}

  fundTransferForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  fundTransfer() {

  }
}
