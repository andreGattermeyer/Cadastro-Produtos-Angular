import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';
import { HomeComponent } from './componentes/home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  
  { path: 'lista-produtos', component: ListaProdutosComponent },


];
