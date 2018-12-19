import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateticketdetailComponent } from './updateticketdetail.component';

describe('UpdateticketdetailComponent', () => {
  let component: UpdateticketdetailComponent;
  let fixture: ComponentFixture<UpdateticketdetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateticketdetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateticketdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
