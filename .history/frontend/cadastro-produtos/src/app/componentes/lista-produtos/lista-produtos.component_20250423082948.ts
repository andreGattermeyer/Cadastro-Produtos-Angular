import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ProdutoService } from '../../produto.service';
import { Produto } from '../../Produto';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-lista-produtos',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    HttpClientModule,
    
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

    // If the data is already in dd/MM/yyyy format, parse it first
    if (typeof data === 'string' && data.includes('/')) {
      const [day, month, year] = data.split(' ')[0].split('/');
      const time = data.split(' ')[1] || '00:00:00';
      data = `${year}-${month}-${day}T${time}`;
    }

    return this.datePipe.transform(data, 'dd/MM/yyyy HH:mm:ss') || '';
  }
}
