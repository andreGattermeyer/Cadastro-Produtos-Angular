import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { VendaService } from '../../services/venda.service';
import { VendedorService } from '../../services/vendedor.service';
import { CustomDatePipe } from '../../pipes/custom-date.pipe';

@Component({
  selector: 'app-relatorio-vendas',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatTabsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    CustomDatePipe
  ],
  templateUrl: './relatorios-vendas.component.html',
  styleUrl: './relatorios-vendas.component.css'
})
export class RelatoriosVendasComponent implements OnInit {
  vendas: any[] = [];
  vendedores: any[] = [];

  // Relatórios
  vendasPorDia: any[] = [];
  vendasPorMes: any[] = [];
  totalVendas: number = 0;

  // Filtros
  vendedorSelecionado: number | null = null;
  dataInicio: Date | null = null;
  dataFim: Date | null = null;

  // Colunas para as tabelas
  colunasDiarias: string[] = ['data', 'vendedor', 'quantidadeVendas', 'valorTotal'];
  colunasMensais: string[] = ['mes', 'vendedor', 'quantidadeVendas', 'valorTotal'];

  constructor(
    private vendaService: VendaService,
    private vendedorService: VendedorService
  ) {}

  ngOnInit(): void {
    this.carregarVendedores();
    this.carregarVendas();
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

  carregarVendas(): void {
    this.vendaService.buscarTodasVendas().subscribe(
      (data) => {
        console.log('Vendas carregadas:', data);
        this.vendas = data;
        this.gerarRelatorios();
      },
      (error) => {
        console.error('Erro ao carregar vendas:', error);
      }
    );
  }

  filtrarVendas(): void {
    console.log('Aplicando filtros:', {
      vendedor: this.vendedorSelecionado,
      dataInicio: this.dataInicio,
      dataFim: this.dataFim
    });

    // Gerar relatórios com os filtros aplicados
    this.gerarRelatorios();
  }

  gerarRelatorios(): void {
    console.log('Gerando relatórios com vendas:', this.vendas.length);

    // Aplicar filtros
    let vendasFiltradas = [...this.vendas];

    if (this.vendedorSelecionado) {
      console.log('Filtrando por vendedor ID:', this.vendedorSelecionado);
      vendasFiltradas = vendasFiltradas.filter(venda =>
        venda.vendedor && venda.vendedor.id === this.vendedorSelecionado);
    }

    if (this.dataInicio) {
      const dataInicioObj = new Date(this.dataInicio);
      console.log('Filtrando por data início:', dataInicioObj);
      vendasFiltradas = vendasFiltradas.filter(venda => {
        const dataVenda = new Date(venda.dataVenda);
        console.log('Comparando data venda:', dataVenda, 'com data início:', dataInicioObj);
        return dataVenda >= dataInicioObj;
      });
    }

    if (this.dataFim) {
      const dataFimObj = new Date(this.dataFim);
      dataFimObj.setHours(23, 59, 59);
      console.log('Filtrando por data fim:', dataFimObj);
      vendasFiltradas = vendasFiltradas.filter(venda => {
        const dataVenda = new Date(venda.dataVenda);
        return dataVenda <= dataFimObj;
      });
    }

    console.log('Vendas filtradas:', vendasFiltradas);

    // Gerar relatório por dia
    this.gerarRelatorioPorDia(vendasFiltradas);

    // Gerar relatório por mês
    this.gerarRelatorioPorMes(vendasFiltradas);

    // Calcular total de vendas
    this.calcularTotalVendas(vendasFiltradas);
  }

  gerarRelatorioPorDia(vendas: any[]): void {
    // Agrupar vendas por dia e por vendedor
    const vendasPorDia: Map<string, Map<number, any[]>> = new Map();

    vendas.forEach(venda => {
      const data = new Date(venda.dataVenda).toISOString().split('T')[0];
      const vendedorId = venda.vendedor?.id || 0;

      if (!vendasPorDia.has(data)) {
        vendasPorDia.set(data, new Map());
      }

      if (!vendasPorDia.get(data)?.has(vendedorId)) {
        vendasPorDia.get(data)?.set(vendedorId, []);
      }

      vendasPorDia.get(data)?.get(vendedorId)?.push(venda);
    });

    // Converter para array para exibição
    this.vendasPorDia = [];
    vendasPorDia.forEach((vendedoresMap, data) => {
      vendedoresMap.forEach((vendasVendedor, vendedorId) => {
        const vendedor = this.vendedores.find(v => v.id === vendedorId);
        const quantidadeVendas = vendasVendedor.length;
        const valorTotal = vendasVendedor.reduce((total, venda) =>
          total + (venda.precoVendido * venda.quantidade), 0);

        this.vendasPorDia.push({
          data: data,
          vendedorId: vendedorId,
          vendedorNome: vendedor?.nome || 'Desconhecido',
          quantidadeVendas: quantidadeVendas,
          valorTotal: valorTotal
        });
      });
    });

    // Ordenar por data
    this.vendasPorDia.sort((a, b) => a.data.localeCompare(b.data));
  }

  gerarRelatorioPorMes(vendas: any[]): void {
    // Agrupar vendas por mês e por vendedor
    const vendasPorMes: Map<string, Map<number, any[]>> = new Map();

    vendas.forEach(venda => {
      const data = new Date(venda.dataVenda);
      const mes = `${data.getFullYear()}-${String(data.getMonth() + 1).padStart(2, '0')}`;
      const vendedorId = venda.vendedor?.id || 0;

      if (!vendasPorMes.has(mes)) {
        vendasPorMes.set(mes, new Map());
      }

      if (!vendasPorMes.get(mes)?.has(vendedorId)) {
        vendasPorMes.get(mes)?.set(vendedorId, []);
      }

      vendasPorMes.get(mes)?.get(vendedorId)?.push(venda);
    });

    // Converter para array para exibição
    this.vendasPorMes = [];
    vendasPorMes.forEach((vendedoresMap, mes) => {
      vendedoresMap.forEach((vendasVendedor, vendedorId) => {
        const vendedor = this.vendedores.find(v => v.id === vendedorId);
        const quantidadeVendas = vendasVendedor.length;
        const valorTotal = vendasVendedor.reduce((total, venda) =>
          total + (venda.precoVendido * venda.quantidade), 0);

        this.vendasPorMes.push({
          mes: mes,
          vendedorId: vendedorId,
          vendedorNome: vendedor?.nome || 'Desconhecido',
          quantidadeVendas: quantidadeVendas,
          valorTotal: valorTotal
        });
      });
    });

    // Ordenar por mês
    this.vendasPorMes.sort((a, b) => a.mes.localeCompare(b.mes));
  }

  calcularTotalVendas(vendas: any[]): void {
    console.log('Calculando total de vendas para:', vendas.length, 'vendas');

    // Verificar se há dados válidos para calcular
    if (vendas.length === 0) {
      this.totalVendas = 0;
      return;
    }

    // Verificar a estrutura dos dados
    console.log('Exemplo de venda:', vendas[0]);

    // Calcular o total com verificação de segurança
    this.totalVendas = vendas.reduce((total, venda) => {
      const preco = venda.precoVendido || 0;
      const quantidade = venda.quantidade || 0;
      const subtotal = preco * quantidade;
      console.log(`Venda ID: ${venda.id}, Preço: ${preco}, Qtd: ${quantidade}, Subtotal: ${subtotal}`);
      return total + subtotal;
    }, 0);

    console.log('Total calculado:', this.totalVendas);
  }

  limparFiltros(): void {
    this.vendedorSelecionado = null;
    this.dataInicio = null;
    this.dataFim = null;
    this.carregarVendas();
  }

  formatarData(data: string): string {
    const [ano, mes, dia] = data.split('-');
    return `${dia}/${mes}/${ano}`;
  }

  formatarMes(mes: string): string {
    const [ano, mesNum] = mes.split('-');
    const meses = [
      'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
      'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
    ];
    return `${meses[parseInt(mesNum) - 1]} de ${ano}`;
  }

  exportarRelatorioDiario(): void {
    if (this.vendasPorDia.length === 0) {
      alert('Não há dados para exportar.');
      return;
    }

    // Simulação de exportação - em um ambiente real, isso enviaria para o backend
    // ou usaria uma biblioteca como FileSaver.js para gerar um arquivo CSV/Excel
    const dadosExportacao = this.vendasPorDia.map(item => ({
      Data: this.formatarData(item.data),
      Vendedor: item.vendedorNome,
      'Quantidade de Vendas': item.quantidadeVendas,
      'Valor Total': `R$ ${item.valorTotal.toFixed(2)}`
    }));

    console.log('Exportando relatório diário:', dadosExportacao);
    alert('Relatório diário exportado com sucesso! (Simulação)');
  }

  exportarRelatorioMensal(): void {
    if (this.vendasPorMes.length === 0) {
      alert('Não há dados para exportar.');
      return;
    }

    const dadosExportacao = this.vendasPorMes.map(item => ({
      Mês: this.formatarMes(item.mes),
      Vendedor: item.vendedorNome,
      'Quantidade de Vendas': item.quantidadeVendas,
      'Valor Total': `R$ ${item.valorTotal.toFixed(2)}`
    }));

    console.log('Exportando relatório mensal:', dadosExportacao);
    alert('Relatório mensal exportado com sucesso! (Simulação)');
  }

  exportarRelatorioCompleto(): void {
    if (this.vendas.length === 0) {
      alert('Não há dados para exportar.');
      return;
    }

    const dadosExportacao = this.vendas.map(venda => ({
      ID: venda.id,
      Produto: venda.produto?.nomeProduto || 'Não disponível',
      Vendedor: venda.vendedor?.nome || 'Não disponível',
      Quantidade: venda.quantidade,
      'Preço Vendido': `R$ ${venda.precoVendido.toFixed(2)}`,
      'Data da Venda': new Date(venda.dataVenda).toLocaleDateString('pt-BR')
    }));

    console.log('Exportando relatório completo:', dadosExportacao);
    alert('Relatório completo exportado com sucesso! (Simulação)');
  }
}


Analisei os logs que você compartilhou e identifiquei o problema no seu componente de relatórios de vendas. O problema está relacionado às datas que você está tentando filtrar.

## O Problema

De acordo com os logs:

1. Você está tentando filtrar vendas para:
   - Vendedor com ID 52
   - Data de início: 01/04/2025
   - Data de fim: 26/04/2025

2. O sistema está aplicando os filtros corretamente, mas o resultado é uma lista vazia (`Vendas filtradas: []`).

3. Como não há vendas no período selecionado, o total de vendas é zero (`Calculando total de vendas para: 0 vendas`).

## Possíveis Causas

1. **Datas futuras**: Você está filtrando por datas em 2025, que ainda não chegaram. Se suas vendas estão todas em datas passadas ou atuais, não haverá resultados.

2. **Vendedor inexistente**: Pode ser que não existam vendas associadas ao vendedor com ID 52.

3. **Formato de data**: Pode haver um problema na comparação de datas se o formato das datas no banco de dados for diferente do formato que você está usando para filtrar.

## Soluções

### 1. Verificar se existem vendas para o período selecionado

Tente selecionar um período de datas onde você sabe que existem vendas. Por exemplo, se você tem vendas de 2023 ou 2024, selecione essas datas em vez de 2025.

### 2. Verificar se o vendedor tem vendas

Tente filtrar apenas por vendedor, sem especificar datas, para ver se o vendedor com ID 52 tem alguma venda registrada.

### 3. Adicionar mais logs para depuração

Adicione logs para verificar as datas das vendas existentes:
```typescript
carregarVendas(): void {
  this.vendaService.buscarTodasVendas().subscribe(
    (data) => {
      console.log('Vendas carregadas:', data);

      // Verificar as datas das vendas existentes
      if (data && data.length > 0) {
        console.log('Datas das vendas:');
        data.forEach(venda => {
          console.log(`Venda ID: ${venda.id}, Data: ${venda.dataVenda}, Vendedor ID: ${venda.vendedor?.id}`);
        });
      }

      this.vendas = data;
      this.gerarRelatorios();
    },
    (error) => {
      console.error('Erro ao carregar vendas:', error);
    }
  );
}
