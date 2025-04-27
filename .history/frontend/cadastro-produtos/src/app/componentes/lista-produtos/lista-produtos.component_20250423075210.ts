import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ProdutoService } from '../../produto.service';
import { Produto } from '../../Produto';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [ProdutoService],
  templateUrl: './lista-produtos.component.html',
  styleUrl: './lista-produtos.component.css'
})
export class ListaProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  displayedColumns: string[] = ['id', 'nomeProduto', 'quantidade', 'precoCusto', 'precoVenda', 'dataEntrada', 'dataSaida', 'margemLucro'];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit() {
    this.carregarProdutos();
  }

  carregarProdutos() {
    this.produtoService.buscarTodosProdutos().subscribe(
      (data) => {
        this.produtos = data;
      },
      (error) => {
        console.error('Erro ao carregar produtos:', error);
      }
    );
  }

  calcularMargemLucro(produto: Produto): number {
    if (produto.precoCusto && produto.precoVenda) {
      return produto.precoVenda - produto.precoCusto;
    }
    return 0;
  }
}
