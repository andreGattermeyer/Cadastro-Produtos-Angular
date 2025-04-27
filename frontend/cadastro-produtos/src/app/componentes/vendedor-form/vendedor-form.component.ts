import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ActivatedRoute, Router } from '@angular/router';
import { VendedorService } from '../../services/vendedor.service';

@Component({
  selector: 'app-vendedor-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './vendedor-form.component.html',
  styleUrl: './vendedor-form.component.css'
})
export class VendedorFormComponent implements OnInit {
  vendedor = {
    id: null,
    nome: '',
    email: '',
    telefone: ''
  };
  
  isEdicao = false;

  constructor(
    private vendedorService: VendedorService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEdicao = true;
        this.vendedorService.buscarVendedorPorId(params['id']).subscribe(
          vendedor => {
            this.vendedor = vendedor;
          },
          error => {
            console.error('Erro ao carregar vendedor:', error);
            alert('Erro ao carregar o vendedor.');
          }
        );
      }
    });
  }

  onSubmit(): void {
    const operacao = this.isEdicao
      ? this.vendedorService.atualizarVendedor(this.vendedor.id, this.vendedor)
      : this.vendedorService.salvarVendedor(this.vendedor);

    operacao.subscribe(
      response => {
        console.log('Vendedor salvo/atualizado com sucesso!', response);
        this.router.navigate(['/vendedores']);
      },
      error => {
        console.error('Erro ao salvar/atualizar vendedor:', error);
        alert('Erro ao salvar/atualizar o vendedor. Por favor, verifique os dados e tente novamente.');
      }
    );
  }

  limparFormulario(): void {
    this.vendedor = {
      id: null,
      nome: '',
      email: '',
      telefone: ''
    };
  }
}