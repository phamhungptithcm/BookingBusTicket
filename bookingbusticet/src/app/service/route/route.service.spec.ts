import { TestBed } from '@angular/core/testing';

import { RouteServiceImp } from './route.service';

describe('RouteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RouteServiceImp = TestBed.get(RouteServiceImp);
    expect(service).toBeTruthy();
  });
});
