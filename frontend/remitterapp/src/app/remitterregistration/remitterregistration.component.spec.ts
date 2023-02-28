import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemitterregistrationComponent } from './remitterregistration.component';

describe('RemitterregistrationComponent', () => {
  let component: RemitterregistrationComponent;
  let fixture: ComponentFixture<RemitterregistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemitterregistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RemitterregistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
