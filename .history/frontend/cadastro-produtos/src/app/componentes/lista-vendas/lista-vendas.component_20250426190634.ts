import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { VendedorService } from '../../services/vendedor.service';
import { ProdutoService } from '../../services/produto.service';
import { CustomDatePipe } from '../../pipes/custom-date.pipe';

@Component({
  selector: 'app-lista-vendas',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    RouterModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    CustomDatePipe
  ],
  templateUrl: './lista-vendas.component.html',
  styleUrl: './lista-vendas.component.css'
})
export class ListaVendasComponent implements OnInit {
  vendas: any[] = [];
  displayedColumns: string[] = ['id', 'produto', 'vendedor', 'quantidade', 'precoVendido', 'dataVenda', 'acoes'];

  // Nova venda
  novaVenda: any = {
    vendedor: {},
    produto: {},
    quantidade: 1,
    precoVendido: 0
  };

  // Listas para os selects
  vendedores: any[] = [];
  produtos: any[] = [];

  // Controle de exibição do formulário
  mostrarFormulario = false;

  constructor(
    private vendaService: VendaService,
    private vendedorService: VendedorService,
    private produtoService: ProdutoService
  ) {}

  ngOnInit(): void {
    // Primeiro carregamos os vendedores, depois as vendas
    this.carregarVendedores();
    this.carregarProdutos();
  }

  

  carregarVendedores(): void {
    this.vendedorService.buscarTodosVendedores().subscribe(
      (data) => {
        this.vendedores = data;
        // Só carregamos as vendas depois que os vendedores estiverem disponíveis
        this.carregarVendas();
      },
      (error) => {
        console.error('Erro ao carregar vendedores:', error);
        // Mesmo com erro, tentamos carregar as vendas
        this.carregarVendas();
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



  carregarProdutos(): void {
    this.produtoService.buscarTodosProdutos().subscribe(
      (data) => {
        this.produtos = data;
      },
      (error) => {
        console.error('Erro ao carregar produtos:', error);
      }
    );
  }

  atualizarPreco(): void {
    if (this.novaVenda.produto && this.novaVenda.produto.id) {
      const produtoSelecionado = this.produtos.find(p => p.id === this.novaVenda.produto.id);
      if (produtoSelecionado) {
        this.novaVenda.precoVendido = produtoSelecionado.precoVenda;
      }
    }
  }

  toggleFormulario(): void {
    this.mostrarFormulario = !this.mostrarFormulario;
    if (this.mostrarFormulario) {
      this.limparFormulario();
    }
  }

  registrarVenda(): void {
    this.vendaService.registrarVenda(this.novaVenda).subscribe(
      (response) => {
        console.log('Venda registrada com sucesso!', response);
        this.limparFormulario();
        this.mostrarFormulario = false;
        this.carregarVendas();
        alert('Venda registrada com sucesso!');
      },
      (error) => {
        console.error('Erro ao registrar venda:', error);
        alert('Erro ao registrar venda. Verifique se há estoque suficiente.');
      }
    );
  }

  limparFormulario(): void {
    this.novaVenda = {
      vendedor: {},
      produto: {},
      quantidade: 1,
      precoVendido: 0
    };
  }
}
