import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { VendaService } from '../../venda.service';
import { ProdutoService } from '../../produto.service';
import { VendedorService } from '../../vendedor.service';

@Component({
  selector: 'app-registrar-venda',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [VendaService, ProdutoService, VendedorService],
  templateUrl: './registrar-venda.component.html',
  styleUrl: './registrar-venda.component.css'
})
export class RegistrarVendaComponent implements OnInit {
  venda = {
    id: null,
    vendedor: { id: null },
    produto: { id: null },
    quantidade: 0,
    precoVendido: 0,
    dataVenda: new Date()
  };

  vendedores: any[] = [];
  produtos: any[] = [];
  produtoSelecionado: any = null;

  constructor(
    private vendaService: VendaService,
    private produtoService: ProdutoService,
    private vendedorService: VendedorService,
    private router: Router
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
        alert('Erro ao carregar a lista de vendedores.');
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
        alert('Erro ao carregar a lista de produtos.');
      }
    );
  }

  onProdutoChange(produtoId: number): void {
    this.produtoSelecionado = this.produtos.find(p => p.id === produtoId);
    if (this.produtoSelecionado) {
      this.venda.precoVendido = this.produtoSelecionado.precoVenda;
    }
  }

  onSubmit(): void {
    if (!this.venda.vendedor.id || !this.venda.produto.id) {
      alert('Por favor, selecione um vendedor e um produto.');
      return;
    }

    if (this.venda.quantidade <= 0) {
      alert('A quantidade deve ser maior que zero.');
      return;
    }

    if (this.produtoSelecionado && this.venda.quantidade > this.produtoSelecionado.quantidade) {
      alert('Quantidade insuficiente em estoque.');
      return;
    }

    this.vendaService.registrarVenda(this.venda).subscribe(
      response => {
        console.log('Venda registrada com sucesso!', response);
        this.limparFormulario();
        this.router.navigate(['/lista-vendas']);
      },
      error => {
        console.error('Erro ao registrar venda:', error);
        alert('Erro ao registrar a venda. Por favor, verifique os dados e tente novamente.');
      }
    );
  }

  limparFormulario(): void {
    this.venda = {
      id: null,
      vendedor: { id: null },
      produto: { id: null },
      quantidade: 0,
      precoVendido: 0,
      dataVenda: new Date()
    };
    this.produtoSelecionado = null;
  }
}
