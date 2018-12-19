import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoticketComponent } from './infoticket.component';

describe('InfoticketComponent', () => {
  let component: InfoticketComponent;
  let fixture: ComponentFixture<InfoticketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoticketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
