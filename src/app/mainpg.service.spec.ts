import { TestBed } from '@angular/core/testing';

import { MainpgService } from './mainpg.service';

describe('MainpgService', () => {
  let service: MainpgService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainpgService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
