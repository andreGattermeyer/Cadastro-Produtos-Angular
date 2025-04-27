import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { VendedorService } from '../../vendedor.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-lista-vendedores',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [VendedorService],
  templateUrl: './lista-vendedores.component.html',
  styleUrl: './lista-vendedores.component.css'
})
export class ListaVendedoresComponent implements OnInit {
  vendedores: any[] = [];
  displayedColumns: string[] = ['id', 'nome', 'email', 'telefone', 'acoes'];

  constructor(private vendedorService: VendedorService) {}

  ngOnInit(): void {
    this.carregarVendedores();
  }

  carregarVendedores(): void {
    this.vendedorService.buscarTodosVendedores().subscribe(
      (data) => {
        this.vendedores = data;
      },
      (error) => {
        console.error('Erro ao carregar vendedores:', error);
        alert('Erro ao carregar a lista de vendedores.');
      }
    );
  }

  atualizarVendedor(vendedor: any): void {
    this.vendedorService.setVendedorParaEditar(vendedor);
    // Navega para a página de cadastro/edição
  }

  deletarVendedor(id: number): void {
    if (confirm('Tem certeza que deseja excluir este vendedor?')) {
      this.vendedorService.deletarVendedor(id).subscribe(
        () => {
          console.log('Vendedor excluído com sucesso!');
          this.carregarVendedores(); // Recarrega a lista
        },
        (error) => {
          console.error('Erro ao excluir vendedor:', error);
          alert('Erro ao excluir o vendedor.');
        }
      );
    }
  }
}
