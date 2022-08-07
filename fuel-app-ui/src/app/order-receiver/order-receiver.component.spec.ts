import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderReceiverComponent } from './order-receiver.component';

describe('OrderReceiverComponent', () => {
  let component: OrderReceiverComponent;
  let fixture: ComponentFixture<OrderReceiverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderReceiverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderReceiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
