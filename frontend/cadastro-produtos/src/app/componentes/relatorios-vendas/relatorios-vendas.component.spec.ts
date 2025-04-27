import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatoriosVendasComponent } from './relatorios-vendas.component';

describe('RelatoriosVendasComponent', () => {
  let component: RelatoriosVendasComponent;
  let fixture: ComponentFixture<RelatoriosVendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RelatoriosVendasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RelatoriosVendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
