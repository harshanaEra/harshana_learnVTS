import {Component, OnInit} from '@angular/core';
import {OrderService} from "../service/order.service";
import {OrderDetail} from "../service/model/order-detail";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-order-check',
  templateUrl: './order-check.component.html',
  styleUrls: ['./order-check.component.css']
})
export class OrderCheckComponent implements OnInit {

  referenceId?: string;
  orderDetail?: OrderDetail;

  constructor(private orderService: OrderService, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {

  }

  searchOrder() {
    if (this.referenceId == undefined) {
      console.log("error");
      this.openSnackBar("Reference Id cannot be empty");
    } else {
      this.orderService.getOrder(this.referenceId).then(response => {
        this.orderDetail = response.data;
      }).catch(() => {
        this.openSnackBar("No Data available for the given reference Id");
      });
    }
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, "x", {
      duration: 10000,
      panelClass: ['error-snackbar'],
      horizontalPosition: "end",
      verticalPosition: "top"
    });
  }
}
