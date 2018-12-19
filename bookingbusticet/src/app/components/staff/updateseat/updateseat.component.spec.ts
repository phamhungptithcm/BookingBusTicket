import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateseatComponent } from './updateseat.component';

describe('UpdateseatComponent', () => {
  let component: UpdateseatComponent;
  let fixture: ComponentFixture<UpdateseatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateseatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateseatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
