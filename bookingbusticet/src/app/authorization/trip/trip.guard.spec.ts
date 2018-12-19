import { TestBed, async, inject } from '@angular/core/testing';

import { TripGuard } from './trip.guard';

describe('TripGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TripGuard]
    });
  });

  it('should ...', inject([TripGuard], (guard: TripGuard) => {
    expect(guard).toBeTruthy();
  }));
});
