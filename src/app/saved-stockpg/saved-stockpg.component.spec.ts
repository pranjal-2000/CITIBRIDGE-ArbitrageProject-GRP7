import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedStockpgComponent } from './saved-stockpg.component';

describe('SavedStockpgComponent', () => {
  let component: SavedStockpgComponent;
  let fixture: ComponentFixture<SavedStockpgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavedStockpgComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavedStockpgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
