import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallbookedComponent } from './viewallbooked.component';

describe('ViewallbookedComponent', () => {
  let component: ViewallbookedComponent;
  let fixture: ComponentFixture<ViewallbookedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewallbookedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewallbookedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
