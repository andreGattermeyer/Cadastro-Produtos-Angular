import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
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
    HttpClientModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [ProdutoService],
  templateUrl: './produtos.component.html',
  styleUrl: './produtos.component.css'
})
export class ProdutosComponent {
  produto = {
    nomeProduto: '',
    quantidade: 0,
    precoCusto: 0,
    precoVenda: 0,
    dataEntrada: new Date().toISOString().slice(0, 19),
    dataSaida: null
  };

  constructor(
    private produtoService: ProdutoService,
    private router: Router
  ) {}

  onSubmit() {
    const produtoParaEnviar = {
      nomeProduto: this.produto.nomeProduto,
      quantidade: Number(this.produto.quantidade),
      precoCusto: Number(this.produto.precoCusto),
      precoVenda: Number(this.produto.precoVenda),
      dataEntrada: this.produto.dataEntrada + "Z",
      dataSaida: this.produto.dataSaida ? this.produto.dataSaida + "Z" : null
    };

    console.log('Produto a ser enviado:', produtoParaEnviar);

    this.produtoService.salvarProduto(produtoParaEnviar).subscribe(
      (response) => {
        console.log('Produto salvo com sucesso!', response);
        this.limparFormulario();
        this.router.navigate(['/lista-produtos']);
      },
      (error) => {
        console.error('Erro ao salvar produto:', error);
        alert('Erro ao salvar o produto. Por favor, verifique os dados e tente novamente.');
      }
    );
  }

  limparFormulario() {
    this.produto = {
      nomeProduto: '',
      quantidade: 0,
      precoCusto: 0,
      precoVenda: 0,
      dataEntrada: new Date().toISOString().slice(0, 19),
      dataSaida: null
    };
  }
}
