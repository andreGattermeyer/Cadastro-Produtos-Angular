import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule, ActivatedRoute } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { VendedorService } from '../../services/vendedor.service';

@Component({
  selector: 'app-lista-vendas',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    RouterModule
  ],
  templateUrl: './lista-vendas.component.html',
  styleUrl: './lista-vendas.component.css'
})
export class ListaVendasComponent implements OnInit {
  vendas: any[] = [];
  displayedColumns: string[] = ['id', 'vendedor', 'produto', 'quantidade', 'precoVendido', 'valorTotal', 'dataVenda', 'acoes'];
  vendedorId: number | null = null;
  vendedor: any = null;
  titulo = 'Todas as Vendas';

  constructor(
    private vendaService: VendaService,
    private vendedorService: VendedorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['vendedorId']) {
        this.vendedorId = +params['vendedorId'];
        this.carregarVendasPorVendedor(this.vendedorId);
        this.carregarVendedor(this.vendedorId);
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
      }
    );
  }

  carregarVendedor(vendedorId: number): void {
    this.vendedorService.buscarVendedorPorId(vendedorId).subscribe(
      (data) => {
        this.vendedor = data;
        this.titulo = `Vendas do Vendedor: ${this.vendedor.nome}`;
      },
      (error) => {
        console.error('Erro ao carregar vendedor:', error);
      }
    );
  }

  formatarData(data: string): string {
    if (!data) return '';
    const dataObj = new Date(data);
    return dataObj.toLocaleDateString('pt-BR') + ' ' + dataObj.toLocaleTimeString('pt-BR');
  }

  calcularValorTotal(venda: any): number {
    return venda.quantidade * venda.precoVendido;
  }

  cancelarVenda(id: number): void {
    if (confirm('Tem certeza que deseja cancelar esta venda? Isso devolverá a quantidade ao estoque.')) {
      this.vendaService.cancelarVenda(id).subscribe(
        () => {
          console.log('Venda cancelada com sucesso!');
          if (this.vendedorId) {
            this.carregarVendasPorVendedor(this.vendedorId);
          } else {
            this.carregarTodasVendas();
          }
        },
        (error) => {
          console.error('Erro ao cancelar venda:', error);
        }
      );
    }
  }
}
