import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';
import { HomeComponent } from './componentes/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },  // Rota padrão
  { path: 'home', component: HomeComponent },
  { path: 'lista-produtos', component: ListaProdutosComponent },
  { path: 'lista-produtos/:id', component: ListaProdutosComponent},
  { path: '**', redirectTo: 'home' }  // Rota wildcard para páginas não encontradas
];
