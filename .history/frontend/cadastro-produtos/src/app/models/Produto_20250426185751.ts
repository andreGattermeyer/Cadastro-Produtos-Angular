import { Vendedor } from 

export interface Produto {
  id: number;
  nomeProduto: string;
  quantidade: number;
  precoCusto: number;
  precoVenda: number;
  dataEntrada: string;
  dataSaida?: string;


}
