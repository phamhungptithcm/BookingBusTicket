import { TestBed } from '@angular/core/testing';

import { ProvinceServiceImp } from './province.service';

describe('ProvinceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProvinceServiceImp = TestBed.get(ProvinceServiceImp);
    expect(service).toBeTruthy();
  });
});
