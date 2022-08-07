import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {OrderService} from "../service/order.service";
import {OrderRequest} from "../service/model/order-request";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {
  selectFormControl = new FormControl('', Validators.required);

  selectedFuelType?: string;
  selectedFuelCapacity?: string;

  constructor(private orderService: OrderService, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
  }


  createOrder() {
    let orderRequest: OrderRequest = {
      fuelCapacity: this.selectedFuelCapacity,
      fuelType: this.selectedFuelType,
      fuelStationId: "STATION001"
    }
    this.orderService.createOrder(orderRequest).then(response => {
      this.openSuccessSnackBar("Order created reference id is " + response.data.referenceId);
    }).catch(() => {
      this.openErrorSnackBar("Cannot create the order please try again later!")
    })
  }

  openErrorSnackBar(message: string) {
    this.snackBar.open(message, "x", {
      duration: 10000,
      panelClass: ['error-snackbar'],
      horizontalPosition: "end",
      verticalPosition: "top"
    });
  }

  openSuccessSnackBar(message: string) {
    this.snackBar.open(message, "x", {
      duration: 20000,
      panelClass: ['success-snackbar'],
      horizontalPosition: "end",
      verticalPosition: "top"
    });
  }
}
