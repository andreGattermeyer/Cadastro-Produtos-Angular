import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VendaService {
  private apiUrl = 'http://localhost:8080/api/vendas';

  constructor(private http: HttpClient) {}

  // POST: Registrar venda
  registrarVenda(venda: any): Observable<any> {
    return this.http.post(this.apiUrl, venda);
  }

  // GET: Listar todas as vendas
  buscarTodasVendas(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  // GET: Buscar venda por ID
  buscarVendaPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  // GET: Buscar vendas por vendedor
  buscarVendasPorVendedor(vendedorId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/vendedor/${vendedorId}`);
  }

  // GET: Buscar vendas por produto
  buscarVendasPorProduto(produtoId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/produto/${produtoId}`);
  }

  // DELETE: Cancelar venda
  cancelarVenda(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  // Armazenar temporariamente uma venda para visualização detalhada
  private vendaParaVisualizar: any = null;

  setVendaParaVisualizar(venda: any): void {
    this.vendaParaVisualizar = venda;
  }

  getVendaParaVisualizar(): any {
    return this.vendaParaVisualizar;
  }
}