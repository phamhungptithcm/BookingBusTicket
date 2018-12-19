import { TestBed } from '@angular/core/testing';

import { TicketServiceImp } from '../ticket/ticket.service';

describe('TicketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TicketServiceImp = TestBed.get(TicketServiceImp);
    expect(service).toBeTruthy();
  });
});
