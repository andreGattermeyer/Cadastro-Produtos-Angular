import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { VendaService } from '../../venda.service';
import { HttpClientModule } from '@angular/common/http';
import { MatTabsModule } from '@angular/material/tabs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lista-vendas',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    RouterModule,
    HttpClientModule,
    MatTabsModule
  ],
  providers: [VendaService],
  templateUrl: './lista-vendas.component.html',
  styleUrl: './lista-vendas.component.css'
})
export class ListaVendasComponent implements OnInit {
  vendas: any[] = [];
  displayedColumns: string[] = ['id', 'vendedor', 'produto', 'quantidade', 'precoVendido', 'total', 'dataVenda', 'acoes'];
  vendedorId: number | null = null;
  produtoId: number | null = null;
  titulo: string = 'Todas as Vendas';

  constructor(
    private vendaService: VendaService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['vendedorId']) {
        this.vendedorId = +params['vendedorId'];
        this.carregarVendasPorVendedor(this.vendedorId);
        this.titulo = 'Vendas do Vendedor';
      } else if (params['produtoId']) {
        this.produtoId = +params['produtoId'];
        this.carregarVendasPorProduto(this.produtoId);
        this.titulo = 'Vendas do Produto';
      } else {
        this.carregarTodasVendas();
      }
    });
  }

  carregarTodasVendas(): void {
    this.vendaService.buscarTodasVendas().subscribe(
      (data) => {
        this.vendas = data;
      },
      (error) => {
        console.error('Erro ao carregar vendas:', error);
        alert('Erro ao carregar a lista de vendas.');
      }
    );
  }

  carregarVendasPorVendedor(vendedorId: number): void {
    this.vendaService.buscarVendasPorVendedor(vendedorId).subscribe(
      (data) => {
        this.vendas = data;
      },
      (error) => {
        console.error('Erro ao carregar vendas do vendedor:', error);
        alert('Erro ao carregar a lista de vendas do vendedor.');
      }
    );
  }

  carregarVendasPorProduto(produtoId: number): void {
    this.vendaService.buscarVendasPorProduto(produtoId).subscribe(
      (data) => {
        this.vendas = data;
      },
      (error) => {
        console.error('Erro ao carregar vendas do produto:', error);
        alert('Erro ao carregar a lista de vendas do produto.');
      }
    );
  }

  cancelarVenda(id: number): void {
    if (confirm('Tem certeza que deseja cancelar esta venda? Isso devolverá a quantidade ao estoque.')) {
      this.vendaService.cancelarVenda(id).subscribe(
        () => {
          console.log('Venda cancelada com sucesso!');
          // Recarrega a lista apropriada
          if (this.vendedorId) {
            this.carregarVendasPorVendedor(this.vendedorId);
          } else if (this.produtoId) {
            this.carregarVendasPorProduto(this.produtoId);
          } else {
            this.carregarTodasVendas();
          }
        },
        (error) => {
          console.error('Erro ao cancelar venda:', error);
          alert('Erro ao cancelar a venda.');
        }
      );
    }
  }

  calcularTotal(venda: any): number {
    return venda.quantidade * venda.precoVendido;
  }

  formatarData(data: string): string {
    if (!data) return '';
    const dataObj = new Date(data);
    return dataObj.toLocaleDateString('pt-BR') + ' ' + dataObj.toLocaleTimeString('pt-BR');
  }
}
