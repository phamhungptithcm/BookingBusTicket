import { TestBed } from '@angular/core/testing';

import { TicketdetailServiceImp } from '../ticketdetail/ticketdetail.service';

describe('TicketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TicketdetailServiceImp = TestBed.get(TicketdetailServiceImp);
    expect(service).toBeTruthy();
  });
});
