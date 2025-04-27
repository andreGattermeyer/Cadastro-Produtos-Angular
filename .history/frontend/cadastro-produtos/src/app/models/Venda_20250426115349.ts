import { Produto } from "../Produto";
import { Vendedor } from "./Vendedor";

export interface Venda {
  id: number;
  vendedor: any;
 // vendedor: Vendedor;
  produto: Produto;
  quantidade: number;
  precoVendido: number;
  dataVenda: string;
}
