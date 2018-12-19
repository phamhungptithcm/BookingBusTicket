import { TestBed } from '@angular/core/testing';

import { OrderstatusServiceImp } from './orderstatus.service';

describe('OrderstatusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrderstatusServiceImp = TestBed.get(OrderstatusServiceImp);
    expect(service).toBeTruthy();
  });
});
