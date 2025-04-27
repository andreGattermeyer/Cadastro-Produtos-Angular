import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';
import { ProdutosComponent } from './componentes/produtos/produtos.component';

export const routes: Routes = [
  { path: '', redirectTo: 'lista-produtos', pathMatch: 'full' },
  { path: 'lista-produtos', component: ListaProdutosComponent },
  { path: 'produtos', component: ProdutosComponent },
  { path: 'produtos/editar/:id', component: ProdutosComponent }
];
