import { TestBed } from '@angular/core/testing';

import { OrderServiceImp } from './order.service';

describe('OrderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OrderServiceImp = TestBed.get(OrderServiceImp);
    expect(service).toBeTruthy();
  });
});
