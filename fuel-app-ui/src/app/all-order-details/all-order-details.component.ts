import {Component, OnInit, ViewChild} from '@angular/core';
import {OrderDetail} from "../service/model/order-detail";
import {OrderService} from "../service/order.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatTable} from "@angular/material/table";
import * as moment from 'moment';

let ELEMENT_DATA: OrderDetail[] = [];

@Component({
  selector: 'app-all-order-details',
  templateUrl: './all-order-details.component.html',
  styleUrls: ['./all-order-details.component.css']
})
export class AllOrderDetailsComponent implements OnInit {

  @ViewChild(MatTable) table?: MatTable<OrderDetail>;

  columns = [
    {
      columnDef: 'id',
      header: 'Id',
      cell: (element: OrderDetail) => `${element.id}`,
    },
    {
      columnDef: 'fuelStationId',
      header: 'Station Id',
      cell: (element: OrderDetail) => `${element.fuelStationId}`,
    },
    {
      columnDef: 'fuelType',
      header: 'Fuel Type',
      cell: (element: OrderDetail) => `${
        element.fuelType == 'OCTANE92' ? "Petrol 92" :
          element.fuelType == 'OCTANE95' ? "Petrol 95" :
            element.fuelType == 'SUPER_DIESEL' ? "Supper Diesel" : "Diesel"}`
    },
    {
      columnDef: 'fuelCapacity',
      header: 'Fuel Capacity',
      cell: (element: OrderDetail) => `${
        element.fuelCapacity == 'CAPACITY_13200' ? "13200 Liters" :
          element.fuelCapacity == 'CAPACITY_6600' ? "6600 Liters" :
            element.fuelCapacity == 'CAPACITY_3300' ? "3300 Liters" : ""}`,
    },
    {
      columnDef: 'status',
      header: 'Status',
      cell: (element: OrderDetail) => `${element.status}`,
    },
    {
      columnDef: 'orderDate',
      header: 'Order Date',
      cell: (element: OrderDetail) => `${element.orderDate == null ? '' : (moment(element.orderDate)).format('DD-MMM-YYYY HH:mm:ss')}`,
    },
    {
      columnDef: 'allocationDate',
      header: 'Allocation Date',
      cell: (element: OrderDetail) => `${element.allocationDate == null ? 'Not Allocated' : (moment(element.allocationDate)).format('DD-MMM-YYYY HH:mm:ss')}`,
    },
    {
      columnDef: 'dispatchDate',
      header: 'Dispatch Date',
      cell: (element: OrderDetail) => `${element.dispatchDate == null ? 'Not Dispatched' : (moment(element.dispatchDate)).format('DD-MMM-YYYY HH:mm:ss')}`,
    },
    {
      columnDef: 'driverId',
      header: 'Driver Id',
      cell: (element: OrderDetail) => `${element.driverId}`,
    },
  ];
  dataSource = ELEMENT_DATA;
  displayedColumns = this.columns.map(c => c.columnDef);

  constructor(private orderService: OrderService, private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.orderService.getOrders().then(response => {
      // @ts-ignore
      response.data.orderDetailResponses.forEach(orderDetail => {
        this.dataSource.push(orderDetail);
      })
      // @ts-ignore
      this.table.renderRows();
      console.log(this.dataSource);
    }).catch(() => {
      this.openErrorSnackBar("No Data available for the given reference Id");
    });
  }

  openErrorSnackBar(message: string) {
    this.snackBar.open(message, "x", {
      duration: 10000,
      panelClass: ['error-snackbar'],
      horizontalPosition: "end",
      verticalPosition: "top"
    });
  }
}
