import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyticketsComponent } from './modifytickets.component';

describe('ModifyticketsComponent', () => {
  let component: ModifyticketsComponent;
  let fixture: ComponentFixture<ModifyticketsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyticketsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyticketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
