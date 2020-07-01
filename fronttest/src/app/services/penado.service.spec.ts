import { TestBed } from '@angular/core/testing';

import { PenadoService } from './penado.service';

describe('PenadoService', () => {
  let service: PenadoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PenadoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
