import {Injectable} from '@angular/core';
import axios from "axios";
import {OrderDetail} from "./model/order-detail";
import {OrderDetails} from "./model/order-details";
import {OrderRequest} from "./model/order-request";
import {AcceptRejectRequest} from "./model/accept-reject-request";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl: string = "http://localhost:8081/api";

  constructor() {
  }

  getOrder(referenceId?: string) {
    return axios.get<OrderDetail>(this.baseUrl + '/order/' + referenceId,
      {
        headers: {
          Accept: 'application/json',
        },
      },
    )
  }

  getOrders() {
    return axios.get<OrderDetails>(this.baseUrl + '/orders',
      {
        headers: {
          Accept: 'application/json',
        },
      },
    )
  }

  createOrder(orderRequest: OrderRequest) {
    return axios.post(this.baseUrl + '/order',
      orderRequest,
      {
        headers: {
          Accept: 'application/json',
        },
      },
    )
  }

  updateOrder(acceptRejectRequest: AcceptRejectRequest) {
    return axios.put(this.baseUrl + '/order',
      acceptRejectRequest,
      {
        headers: {
          Accept: 'application/json',
        },
      },
    )
  }
}
