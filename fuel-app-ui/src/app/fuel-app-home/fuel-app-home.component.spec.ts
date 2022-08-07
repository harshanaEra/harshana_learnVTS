import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelAppHomeComponent } from './fuel-app-home.component';

describe('FuelAppHomeComponent', () => {
  let component: FuelAppHomeComponent;
  let fixture: ComponentFixture<FuelAppHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuelAppHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuelAppHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
