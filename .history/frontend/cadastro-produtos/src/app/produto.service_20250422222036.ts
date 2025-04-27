import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private apiUrl = 'http://localhost/api/produtos'; // URL base do controlador

  constructor(private http: HttpClient) {}

  // POST: Gravar produto
  salvarProduto(produto: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/gravar-produto`, produto);
  }

  // GET: Listar todos os produtos
  buscarTodosProdutos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/listar-produtos`);
  }

  // GET: Buscar produto por ID
  buscarProdutoPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  // PUT: Atualizar produto
  atualizarProduto(id: number, produto: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, produto);
  }

  // PUT: Reduzir quantidade
  reduzirQuantidade(id: number, quantidade: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}/reduzir-quantidade`, null, {
      params: { quantidade: quantidade.toString() },
    });
  }

  // PUT: Registrar saída
  registrarSaidaProduto(id: number, quantidade: number): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}/registrar-saida`, null, {
      params: { quantidade: quantidade.toString() },
    });
  }

  // GET: Calcular margem de lucro
  calcularMargemLucro(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}/margem-lucro`);
  }
}
