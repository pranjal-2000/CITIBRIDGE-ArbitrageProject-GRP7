import { TestBed } from '@angular/core/testing';

import { SavedstockpageService } from './savedstockpage.service';

describe('SavedstockpageService', () => {
  let service: SavedstockpageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SavedstockpageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
