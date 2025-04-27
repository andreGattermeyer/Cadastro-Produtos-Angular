import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VendedorService {
  private apiUrl = 'http://localhost:8080/api/vendedores';
  private vendedorParaEditarSubject = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) {}

  // POST: Salvar vendedor
  salvarVendedor(vendedor: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, vendedor);
  }

  // GET: Listar todos os vendedores
  buscarTodosVendedores(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  // GET: Buscar vendedor por ID
  buscarVendedorPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  // PUT: Atualizar vendedor
  atualizarVendedor(id: number, vendedor: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, vendedor);
  }

  // DELETE: Excluir vendedor
  deletarVendedor(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

  // Métodos para compartilhar dados entre componentes
  setVendedorParaEditar(vendedor: any