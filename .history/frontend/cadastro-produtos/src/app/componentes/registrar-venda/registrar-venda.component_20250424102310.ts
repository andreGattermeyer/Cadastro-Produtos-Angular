import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { VendedorService } from '../../services/vendedor.service';
import { ProdutoService } from '../../services/produto.service';

@Component({
  selector: 'app-registrar-venda',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule
  ],
  templateUrl: './registrar-venda.component.html',
  styleUrl: './registrar-venda.component.css'
})
export class RegistrarVendaComponent implements OnInit {
  venda = {
    vendedor: { id: null },
    produto: { id: null },
    quantidade: 0,
    precoVendido: 0
  };

  vendedores: any[] = [];
  produtos: any[] = [];
  produtoSelecionado: any = null;

  constructor(
    private vendaService: VendaService,
    private vendedorService: VendedorService,
    private produtoService: ProdutoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarVendedores();
    this.carregarProdutos();
  }

  carregarVendedores(): void {
    this.vendedorService.buscarTodosVendedores().subscribe(
      (data) => {
        this.vendedores = data;
      },
      (error) => {
        console.error('Erro ao carregar vendedores:', error);
      }
    );
  }

  carregarProdutos(): void {
    this.produtoService.buscarTodosProdutos().subscribe(
      (data) => {
        this.produtos = data;
      },
      (error) => {
        console.error('Erro ao carregar produtos:', error);
      }
    );
  }

  onProdutoChange(): void {
    if (this.venda.produto.id) {
      this.produtoService.buscarProdutoPorId(this.venda.produto.id).subscribe(
        (produto) => {
          this.produtoSelecionado = produto;
          this.venda.precoVendido = produto.precoVenda;
        },
        (error) => {
          console.error('Erro ao carregar detalhes do produto:', error);
        }
      );
    }
  }

  onSubmit(): void {
    if (!this.venda.vendedor.id || !this.venda.produto.id || this.venda.quantidade <= 0) {
      alert('Por favor, preencha todos os campos corretamente.');
      return;
    }

    if (this.produtoSelecionado && this.venda.quantidade > this.produtoSelecionado.quantidade) {
      alert('Quantidade insuficiente em estoque.');
      return;
    }

    this.vendaService.registrarVenda(this.venda).subscribe(
      (response) => {
        console.log('Venda registrada com sucesso!', response);
        this.router.navigate(['/vendas']);
      },
      (error) => {
        console.error('Erro ao registrar venda:', error);
        alert('Erro ao registrar a venda. Por favor, verifique os dados e tente novamente.');
      }
    );
  }
}
