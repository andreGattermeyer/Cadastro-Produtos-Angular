import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { ProdutoService } from '../../produto.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'dd/MM/yyyy',
  },
  display: {
    dateInput: 'dd/MM/yyyy',
    monthYearLabel: 'MMM yyyy',
    dateA11yLabel: 'dd/MM/yyyy',
    monthYearA11yLabel: 'MMMM yyyy',
  },
};

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
  providers: [
    ProdutoService,
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ],
  templateUrl: './produtos.component.html',
  styleUrl: './produtos.component.css'
})
export class ProdutosComponent {
  produto = {
    nomeProduto: '',
    quantidade: 0,
    precoCusto: 0,
    precoVenda: 0,
    dataEntrada: new Date(),
    dataSaida: null
  };

  constructor(
    private produtoService: ProdutoService,
    private router: Router
  ) {}

  formatarData(data: Date | null): string | null {
    if (!data) return null;

    const pad = (num: number) => String(num).padStart(2, '0');

    const dia = pad(data.getDate());
    const mes = pad(data.getMonth() + 1);
    const ano = data.getFullYear();
    const hora = pad(data.getHours());
    const minuto = pad(data.getMinutes());
    const segundo = pad(data.getSeconds());

    return `${dia}/${mes}/${ano} ${hora}:${minuto}:${segundo}`;
  }

  onSubmit() {
    const produtoParaEnviar = {
      nomeProduto: this.produto.nomeProduto,
      quantidade: Number(this.produto.quantidade),
      precoCusto: Number(this.produto.precoCusto),
      precoVenda: Number(this.produto.precoVenda),
      dataEntrada: this.formatarData(this.produto.dataEntrada),
      dataSaida: this.formatarData(this.produto.dataSaida)
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
      dataEntrada: new Date(),
      dataSaida: null
    };
  }
}

