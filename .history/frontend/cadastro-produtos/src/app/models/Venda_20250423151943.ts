export interface Venda {
  id: number;
  vendedor: Vendedor;
  produto: Produto;
  quantidade: number;
  precoVendido: number;
  dataVenda: string;
}