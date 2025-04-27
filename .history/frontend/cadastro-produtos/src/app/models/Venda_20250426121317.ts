import { Produto } from "../Produto";
import { Vendedor } from "./Vendedor";

/*export interface Venda {
  id: number;
  vendedor: Vendedor;
  produto: Produto;
  quantidade: number;
  precoVendido: number;
  dataVenda: string;
}*/

export interface Venda {
  id: number;
  vendedor?: Vendedor; // Tornando opcional
  vendedorId?: number; // Adicionando campo para ID do vendedor
  produto: Produto;
  quantidade: number;
  precoVendido: number;
  dataVenda: string;
}
