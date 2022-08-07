import {Component, OnInit} from '@angular/core';
import {OrderDetail} from "../service/model/order-detail";
import {OrderService} from "../service/order.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AcceptRejectRequest} from "../service/model/accept-reject-request";

@Component({
  selector: 'app-order-receiver',
  templateUrl: './order-receiver.component.html',
  styleUrls: ['./order-receiver.component.css']
})
export class OrderReceiverComponent implements OnInit {

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

  declineOrder() {
    if (this.orderDetail) {
      let acceptReject: AcceptRejectRequest = {
        orderId: this.referenceId,
        stationId: this.orderDetail.fuelStationId,
        status: 'NOT_ACCEPTED'
      }
      this.orderService.updateOrder(acceptReject).then(response => {
        this.orderDetail = response.data;
      }).catch(() => {
        this.openSnackBar("Cannot update the order");
      });
    }
  }

  acceptOrder() {
    if (this.orderDetail) {
      let acceptReject: AcceptRejectRequest = {
        orderId: this.referenceId,
        stationId: this.orderDetail.fuelStationId,
        status: 'ACCEPTED'
      }
      this.orderService.updateOrder(acceptReject).then(response => {
        this.orderDetail = response.data;
      }).catch(() => {
        this.openSnackBar("Cannot update the order");
      });
    }
  }
}
