import { TestBed } from '@angular/core/testing';

import { TripServiceImp } from './trip.service';

describe('TripService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TripServiceImp = TestBed.get(TripServiceImp);
    expect(service).toBeTruthy();
  });
});
