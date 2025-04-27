import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
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
  providers: [ProdutoService, DatePipe],
  templateUrl: './lista-produtos.component.html',
  styleUrl: './lista-produtos.component.css'
})
export class ListaProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  displayedColumns: string[] = ['id', 'nomeProduto', 'quantidade', 'precoCusto', 'precoVenda', 'dataEntrada', 'dataSaida', 'margemLucro'];

  constructor(
    private produtoService: ProdutoService,
    private datePipe: DatePipe
  ) {}

  ngOnInit() {
    this.carregarProdutos();
  }

  carregarProdutos() {
    this.produtoService.buscarTodosProdutos().subscribe(
      (data) => {
        this.produtos = data.map(produto => ({
          ...produto,
          dataEntrada: produto.dataEntrada ? new Date(produto.dataEntrada) : null,
          dataSaida: produto.dataSaida ? new Date(produto.dataSaida) : null
        }));
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

  formatarData(data: any): string {
    if (!data) return '';

    try {
      // Convert string date to Date object if it's a string
      const dateObj = typeof data === 'string' ? new Date(data) : data;

      // Check if date is valid
      if (isNaN(dateObj.getTime())) {
        return '';
      }

      return this.datePipe.transform(dateObj, 'dd/MM/yyyy HH:mm:ss') || '';
    } catch (error) {
      console.error('Error formatting date:', error);
      return '';
    }
  }
}
