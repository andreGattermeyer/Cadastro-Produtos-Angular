import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ProdutoService } from '../../produto.service';
import { Produto } from '../../Produto';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';

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
    private datePipe: DatePipe,
    private router: Router
  ) {}

  ngOnInit() {
    this.carregarProdutos();
  }

  carregarProdutos() {
    this.produtoService.buscarTodosProdutos().subscribe(
      (data) => {
        console.log('Produtos carregados:', data); // Adicione este log
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

  formatarData(data: any): string {
    if (!data) return ''; // Verifica se a data existe
    const dataObj = typeof data === 'string'
      ? new Date(data.replace(/(\d{2})\/(\d{2})\/(\d{4}) (\d{2}):(\d{2}):(\d{2})/, '$3-$2-$1T$4:$5:$6'))
      : data; // Converte a string "DD/MM/YYYY HH:mm:ss" para um objeto Date
    return this.datePipe.transform(dataObj, 'dd/MM/yyyy HH:mm:ss') || '';
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

  atualizarProduto(produto: Produto) {
    this.router.navigate(['/produtos/editar', produto.id]);
  }

  deletarProduto(id: number) : void {
    console.log(id);
    this.produtoService.deletarProduto(id).subscribe({
      next: (res) => {
        console.log(res);
        this.buscarTodosProdutos();
      },
      
    })
  }
}
