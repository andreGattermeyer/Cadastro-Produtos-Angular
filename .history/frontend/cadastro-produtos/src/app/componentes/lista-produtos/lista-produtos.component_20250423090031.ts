import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ProdutoService } from '../../produto.service';
import { Produto } from '../../Produto';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    HttpClientModule,
    RouterModule,
    MatIconModule,
    MatButtonModule
  ],
  providers: [ProdutoService, DatePipe],
  templateUrl: './lista-produtos.component.html',
  styleUrl: './lista-produtos.component.css'
})
export class ListaProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  displayedColumns: string[] = ['id', 'nomeProduto', 'quantidade', 'precoCusto', 'precoVenda', 'dataEntrada', 'dataSaida', 'margemLucro', 'acoes'];

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

  atualizarProduto(produto: Produto) {
    this.produtoService.atualizarProduto(produto.id, produto).subscribe(
      (response) => {
        console.log('Produto atualizado com sucesso!', response);
        this.carregarProdutos();
      },
      (error) => {
        console.error('Erro ao atualizar produto:', error);
        alert('Erro ao atualizar o produto. Por favor, tente novamente.');
      }
    );
  }

  reduzirQuantidade(produto: Produto) {
    const quantidade = prompt('Digite a quantidade a ser reduzida:');
    if (quantidade && !isNaN(Number(quantidade))) {
      this.produtoService.reduzirQuantidade(produto.id, Number(quantidade)).subscribe(
        (response) => {
          console.log('Quantidade reduzida com sucesso!', response);
          this.carregarProdutos();
        },
        (error) => {
          console.error('Erro ao reduzir quantidade:', error);
          alert('Erro ao reduzir a quantidade. Por favor, tente novamente.');
        }
      );
    }
  }
}
