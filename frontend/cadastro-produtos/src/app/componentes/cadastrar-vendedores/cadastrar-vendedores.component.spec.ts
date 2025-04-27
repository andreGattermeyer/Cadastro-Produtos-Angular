import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarVendedoresComponent } from './cadastrar-vendedores.component';

describe('CadastrarVendedoresComponent', () => {
  let component: CadastrarVendedoresComponent;
  let fixture: ComponentFixture<CadastrarVendedoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarVendedoresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarVendedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
