import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';

export const routes: Routes = [
  { path: 'lista-produtos', component: ListaProdutosComponent },
  { path: '', redirectTo: '/lista-produtos', pathMatch: 'full' },
  { path: '**', redirectTo: '/lista-produtos' }
];
