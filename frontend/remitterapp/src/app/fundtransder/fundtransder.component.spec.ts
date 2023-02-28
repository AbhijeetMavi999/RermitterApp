import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundtransderComponent } from './fundtransder.component';

describe('FundtransderComponent', () => {
  let component: FundtransderComponent;
  let fixture: ComponentFixture<FundtransderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundtransderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FundtransderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
