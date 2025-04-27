import {}
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { VendedorService } from '../../vendedor.service';

@Component({
  selector: 'app-vendedor',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule
  ],
  providers: [VendedorService],
  templateUrl: './vendedor.component.html',
  styleUrl: './vendedor.component.css'
})
export class VendedorComponent implements OnInit {
  vendedor = {
    id: null,
    nome: '',
    email: '',
    telefone: ''
  };

  constructor(
    private vendedorService: VendedorService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.vendedorService.buscarVendedorPorId(params['id']).subscribe(
          vendedor => {
            this.vendedor = vendedor;
          },
          error => {
            console.error('Erro ao carregar vendedor:', error);
            alert('Erro ao carregar o vendedor.');
          }
        );
      }
    });
  }

  onSubmit(): void {
    const operacao = this.vendedor.id
      ? this.vendedorService.atualizarVendedor(this.vendedor.id, this.vendedor)
      : this.vendedorService.salvarVendedor(this.vendedor);

    operacao.subscribe(
      response => {
        console.log('Vendedor salvo/atualizado com sucesso!', response);
        this.limparFormulario();
        this.router.navigate(['/lista-vendedores']);
      },
      error => {
        console.error('Erro ao salvar/atualizar vendedor:', error);
        alert('Erro ao salvar/atualizar o vendedor. Por favor, verifique os dados e tente novamente.');
      }
    );
  }

  limparFormulario(): void {
    this.vendedor = {
      id: null,
      nome: '',
      email: '',
      telefone: ''
    };
  }
}
