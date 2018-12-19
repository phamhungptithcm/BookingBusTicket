import { TestBed } from '@angular/core/testing';

import { BusServiceImp } from './bus.service';

describe('BusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BusServiceImp = TestBed.get(BusServiceImp);
    expect(service).toBeTruthy();
  });
});
