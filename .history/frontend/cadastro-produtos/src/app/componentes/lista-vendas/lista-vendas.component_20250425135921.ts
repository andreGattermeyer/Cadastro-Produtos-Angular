import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { VendaService } from '../../services/venda.service';

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
  displayedColumns: string[] = ['id', 'produto', 'vendedor', 'quantidade', 'precoVendido', 'dataVenda', 'acoes'];

  constructor(private vendaService: VendaService) {}

  ngOnInit(): void {
    this.carregarVendas();
  }

  carregarVendas(): void {
    this.vendaService.buscarTodasVendas().subscribe(
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
          this.carregarVendas();
        },
        (error) => {
          console.error('Erro ao cancelar venda:', error);
        }
      );
    }
  }
}
