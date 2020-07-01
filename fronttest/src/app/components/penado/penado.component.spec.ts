import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PenadoComponent } from './penado.component';

describe('PenadoComponent', () => {
  let component: PenadoComponent;
  let fixture: ComponentFixture<PenadoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PenadoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PenadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
