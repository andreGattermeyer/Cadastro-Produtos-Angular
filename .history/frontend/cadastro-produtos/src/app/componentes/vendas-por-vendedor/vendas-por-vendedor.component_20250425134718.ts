import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { VendedorService } from '../../services/vendedor.service';

@Component({
  selector: 'app-vendas-por-vendedor',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    RouterModule
  ],
  templateUrl: './vendas-por-vendedor.component.html',
  styleUrl: './vendas-por-vendedor.component.css'
})
export class VendasPorVendedorComponent implements OnInit {
  vendas: any[] = [];
  vendedor: any = {};
  displayedColumns: string[] = ['id', 'produto', 'quantidade', 'precoVendido', 'dataVenda', 'acoes'];

  constructor(
    private route: ActivatedRoute,
    private vendaService: VendaService,
    private vendedorService: VendedorService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const vendedorId = +params['id'];
      this.carregarVendedor(vendedorId);
      this.carregarVendas(vendedorId);
    });
  }

  carregarVendedor(id: number): void {
    this.vendedorService.buscarVendedorPorId(id).subscribe(
      (data) => {
        this.vendedor = data;
      },
      (error) => {
        console.error('Erro ao carregar vendedor:', error);
      }
    );
  }

  carregarVendas(vendedorId: number): void {
    this.vendaService.buscarVendasPorVendedor(vendedorId).subscribe(
      (data) => {
        this.vendas = data;
      },
      (error) => {
        console.error('Erro ao carregar vendas:', error);
      }
    );
  }

  cancelarVenda(id: number): void {
    if (confirm('Tem certeza que deseja cancelar esta venda?')) {
      this.vendaService.cancelarVenda(id).subscribe(
        () => {
          console.log('Venda cancelada com sucesso!');
          this.carregarVendas(this.vendedor.id);
        },
        (error) => {
          console.error('Erro ao cancelar venda:', error);
        }
      );
    }
  }
}
