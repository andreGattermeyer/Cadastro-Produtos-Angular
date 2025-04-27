import { Component } from '@angular/core';
import { VendedorComponent } from '../vendedor/vendedor.component';

@Component({
  selector: 'app-cadastrar-vendedores',
  standalone: true,
  imports: [VendedorComponent],
  templateUrl: './cadastrar-vendedores.component.html',
  styleUrl: './cadastrar-vendedores.component.css'
})
export class CadastrarVendedoresComponent {
  // Não é necessário adicionar lógica aqui se estiver apenas redirecionando para o VendedorComponent
}
