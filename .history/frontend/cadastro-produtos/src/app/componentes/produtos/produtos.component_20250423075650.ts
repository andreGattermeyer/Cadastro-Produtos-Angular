import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ProdutoService } from '../../produto.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produtos',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule
  ],
  providers: [ProdutoService],
  templateUrl: './produtos.component.html',
  styleUrl: './produtos.component.css'
})
export class ProdutosComponent {
  produto = {
    nomeProduto: '',
    quantidade: null,
    precoCusto: null,
    precoVenda: null,
    dataEntrada: new Date()
  };

  constructor(
    private produtoService: ProdutoService,
    private router: Router
  ) {}

  onSubmit() {
    this.produtoService.salvarProduto(this.produto).subscribe(
      (response) => {
        console.log('Produto salvo com sucesso!', response);
        this.limparFormulario();
        this.router.navigate(['/lista-produtos']); // Redireciona para a lista após salvar
      },
      (error) => {
        console.error('Erro ao salvar produto:', error);
      }
    );
  }

  limparFormulario() {
    this.produto = {
      nomeProduto: '',
      quantidade: null,
      precoCusto: null,
      precoVenda: null,
      dataEntrada: new Date()
    };
  }
}
