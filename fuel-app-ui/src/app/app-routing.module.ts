import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllOrderDetailsComponent} from "./all-order-details/all-order-details.component";
import {AddOrderComponent} from "./add-order/add-order.component";
import {FuelAppHomeComponent} from "./fuel-app-home/fuel-app-home.component";
import {OrderCheckComponent} from "./order-check/order-check.component";
import {OrderReceiverComponent} from "./order-receiver/order-receiver.component";

const routes: Routes = [
  {path: '', component: FuelAppHomeComponent},
  {path: 'add-order', component: AddOrderComponent},
  {path: 'order-details', component: AllOrderDetailsComponent},
  {path: 'home', component: FuelAppHomeComponent},
  {path: 'order-status', component: OrderCheckComponent},
  {path: 'order-receiver', component: OrderReceiverComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
