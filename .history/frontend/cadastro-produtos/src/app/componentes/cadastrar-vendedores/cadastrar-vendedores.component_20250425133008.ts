import { Component } from '@angular/core';
import { VendedorFormComponent } from '../vendedor-form/vendedor-form.component';

@Component({
  selector: 'app-cadastrar-vendedores',
  standalone: true,
  imports: [VendedorFormComponent],
  templateUrl: './cadastrar-vendedores.component.html',
  styleUrl: './cadastrar-vendedores.component.css'
})
export class CadastrarVendedoresComponent {

}
