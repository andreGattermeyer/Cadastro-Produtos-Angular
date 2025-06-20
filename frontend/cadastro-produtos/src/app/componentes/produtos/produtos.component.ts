import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { ProdutoService } from '../../services/produto.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MomentDateAdapter, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';
import { DateAdapter } from '@angular/material/core';
import { ActivatedRoute } from '@angular/router';

const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'DD/MM/YYYY',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'DD/MM/YYYY',
    monthYearA11yLabel: 'MMMM YYYY',
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
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS },
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    }
  ],
  templateUrl: './produtos.component.html',
  styleUrl: './produtos.component.css'
})
export class ProdutosComponent implements OnInit {
  produto = {
    id: null,
    nomeProduto: '',
    quantidade: 0,
    precoCusto: 0,
    precoVenda: 0,
    dataEntrada: new Date(),
    dataSaida: null
  };

  constructor(
    private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.produtoService.buscarProdutoPorId(params['id']).subscribe(
          produto => {
            // Convertendo as strings de data para objetos Date
            const dataEntrada = produto.dataEntrada ? new Date(this.converterDataStringParaDate(produto.dataEntrada)) : new Date();
            const dataSaida = produto.dataSaida ? new Date(this.converterDataStringParaDate(produto.dataSaida)) : null;

            this.produto = {
              ...produto,
              dataEntrada: dataEntrada,
              dataSaida: dataSaida
            };
          },
          error => {
            console.error('Erro ao carregar produto:', error);
            alert('Erro ao carregar o produto.');
          }
        );
      }
    });
  }

  // Adicione este novo método para converter a string de data do formato BR para o formato aceito pelo Date
  converterDataStringParaDate(dataString: string): string {
    if (!dataString) return '';

    // Separa a data e hora
    const [data, hora] = dataString.split(' ');

    // Separa dia, mês e ano
    const [dia, mes, ano] = data.split('/');

    // Se tiver hora, usa ela, senão usa 00:00:00
    const horaCompleta = hora || '00:00:00';

    // Retorna no formato que o Date aceita (YYYY-MM-DD HH:mm:ss)
    return `${ano}-${mes}-${dia} ${horaCompleta}`;
  }

  onSubmit() {
    const produtoParaEnviar = {
      id: this.produto.id,
      nomeProduto: this.produto.nomeProduto,
      quantidade: Number(this.produto.quantidade),
      precoCusto: Number(this.produto.precoCusto),
      precoVenda: Number(this.produto.precoVenda),
      dataEntrada: this.produto.dataEntrada instanceof Date
        ? this.formatarData(this.produto.dataEntrada)
        : this.formatarData(new Date(this.produto.dataEntrada)),
      dataSaida: this.produto.dataSaida
        ? this.formatarData(new Date(this.produto.dataSaida))
        : null
    };

    const operacao = this.produto.id
      ? this.produtoService.atualizarProduto(this.produto.id, produtoParaEnviar)
      : this.produtoService.salvarProduto(produtoParaEnviar);

    operacao.subscribe(
      response => {
        console.log('Produto salvo/atualizado com sucesso!', response);
        this.limparFormulario();
        this.router.navigate(['/lista-produtos']);
      },
      error => {
        console.error('Erro ao salvar/atualizar produto:', error);
        alert('Erro ao salvar/atualizar o produto. Por favor, verifique os dados e tente novamente.');
      }
    );
  }

  formatarData(data: Date | string | null): string | null {
    if (!data) return null;

    let dataObj: Date;

    if (typeof data === 'string') {
      // Se a data vier como string, precisamos converter para Date
      const [dataParte, horaParte] = data.split(' ');
      const [dia, mes, ano] = dataParte.split('/').map(Number);
      const [hora, minuto, segundo] = horaParte ? horaParte.split(':').map(Number) : [0, 0, 0];

      dataObj = new Date(ano, mes - 1, dia, hora, minuto, segundo);
    } else {
      dataObj = data as Date;
    }

    const pad = (num: number) => String(num).padStart(2, '0');

    const dia = pad(dataObj.getDate());
    const mes = pad(dataObj.getMonth() + 1);
    const ano = dataObj.getFullYear();
    const hora = pad(dataObj.getHours());
    const minuto = pad(dataObj.getMinutes());
    const segundo = pad(dataObj.getSeconds());

    return `${dia}/${mes}/${ano} ${hora}:${minuto}:${segundo}`;
  }

  limparFormulario() {
    this.produto = {
      id: null,
      nomeProduto: '',
      quantidade: 0,
      precoCusto: 0,
      precoVenda: 0,
      dataEntrada: new Date(),
      dataSaida: null
    };
  }
}

