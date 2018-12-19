import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelbookedComponent } from './cancelbooked.component';

describe('CancelbookedComponent', () => {
  let component: CancelbookedComponent;
  let fixture: ComponentFixture<CancelbookedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelbookedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelbookedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
