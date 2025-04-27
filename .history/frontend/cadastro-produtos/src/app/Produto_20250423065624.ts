export interface Produto {
  id: number;
  nomeProduto: string;
  quantidade: number;
  precoCusto: number;
  precoVenda: number;
  dataEntrada: string; // Formato de data (ISO ou personalizado)
  dataSaida?: string;  // Opcional


  constructor(){}
}
