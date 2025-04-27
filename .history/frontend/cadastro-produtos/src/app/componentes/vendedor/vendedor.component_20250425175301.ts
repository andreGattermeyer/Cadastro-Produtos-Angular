import { VendedorService } from './../../services/vendedor.service';
import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { HttpClientModule } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-vendedor',
  standalone: true,
  imports: [
    RouterModule,
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule
  ],
  providers: [VendedorService],
  templateUrl: './vendedor.component.html',
  styleUrl: './vendedor.component.css'
})
export class VendedorComponent implements OnInit {
  // Removi a linha problemática [x: string]: any;

  vendedor = {
    id: null as number | null,
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
    console.log('Inicializando vendedor:', this.vendedor);
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.vendedorService.buscarVendedorPorId(params['id']).subscribe(
          vendedor => {
            this.vendedor = vendedor;
            console.log('Vendedor carregado:', this.vendedor);
          },
          error => {
            console.error('Erro ao carregar vendedor:', error);
            alert('Erro ao carregar o vendedor.');
          }
        );
      } else {
        console.log('Criando novo vendedor');
        // Garantir que o ID seja null para um novo vendedor
        this.vendedor = {
          id: null,
          nome: '',
          email: '',
          telefone: ''
        };
      }
    });
  }

  onSubmit(): void {
    console.log('Enviando dados do vendedor:', this.vendedor);

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

  navegarParaListaVendedores(): void {
    this.router.navigate(['/lista-vendedores']);
  }
}
