import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ProdutoService } from '../../produto.service';
import { Produto } from '../../Produto';


@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    
  ],
  providers: [ProdutoService],
  templateUrl: './lista-produtos.component.html',
  styleUrl: './lista-produtos.component.css'
})
export class ListaProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  displayedColumns: string[] = ['id', 'nomeProduto', 'quantidade', 'precoCusto', 'precoVenda', 'dataEntrada', 'dataSaida'];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit() {
    this.carregarProdutos();
  }

  carregarProdutos() {
    this.produtoService.buscarTodosProdutos()(
      (data) => {
        this.produtos = data;
      },
      (error) => {
        console.error('Erro ao carregar produtos:', error);
      }
    );
  }
}
