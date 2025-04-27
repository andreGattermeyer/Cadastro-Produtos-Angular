import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { VendedorService } from '../../services/vendedor.service';
import { ProdutoService } from '../../services/produto.service';

@Component({
  selector: 'app-registrar-venda',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    RouterModule
  ],
  templateUrl: './registrar-venda.component.html',
  styleUrl: './registrar-venda.component.css'
})
export class RegistrarVendaComponent implements OnInit {
  venda: any = {
    vendedor: {},
    produto: {},
    quantidade: 1,
    precoVendido: 0
  };

  vendedores: any[] = [];
  produtos: any[] = [];

  constructor(
    private vendaService: VendaService,
    private vendedorService: VendedorService,
    private produtoService: ProdutoService
  ) {}

  ngOnInit(): void {
    this.carregarVendedores();
    this.carregarProdutos();
  }

  carregarVendedores(): void {
    this.vendedorService.buscarTodosVendedores().subscribe(
      (data) => {
        this.vendedores = data;
      },
      (error) => {
        console.error('Erro ao carregar vendedores:', error);
      }
    );
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
    if (this.venda.produto && this.venda.produto.id) {
      const produtoSelecionado = this.produtos.find(p => p.id === this.venda.produto.id);
      if (produtoSelecionado) {
        this.venda.precoVendido = produtoSelecionado.preco;
      }
    }
  }

  onSubmit(): void {
    this.vendaService.registrarVenda(this.venda).subscribe(
      (response) => {
        console.log('Venda registrada com sucesso!', response);
        this.limparFormulario();
        alert('Venda registrada com sucesso!');
      },
      (error) => {
        console.error('Erro ao registrar venda:', error);
        alert('Erro ao registrar venda. Verifique se há estoque suficiente.');
      }
    );
  }

  limparFormulario(): void {
    this.venda = {
      vendedor: {},
      produto: {},
      quantidade: 1,
      precoVendido: 0
    };
  }
}
