import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrtcardsComponent } from './frtcards.component';

describe('FrtcardsComponent', () => {
  let component: FrtcardsComponent;
  let fixture: ComponentFixture<FrtcardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrtcardsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FrtcardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
