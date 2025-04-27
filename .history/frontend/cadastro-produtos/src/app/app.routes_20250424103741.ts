import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';
import { HomeComponent } from './componentes/home/home.component';
import { ProdutosComponent } from './componentes/produtos/produtos.component';
import { VendedorComponent } from './componentes/vendedor/vendedor.component';
import { ListaVendedoresComponent } from './componentes/lista-vendedores/lista-vendedores.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'lista-produtos', component: ListaProdutosComponent },
  { path: 'produtos', component: ProdutosComponent},
  { path: 'produtos/editar/:id', component: ProdutosComponent },
  { path: 'vendedor', component: VendedorComponent },
  { path: 'vendedor/editar/:id', component: VendedorComponent },
  { path: 'lista-vendedores', component: ListaVendedoresComponent },
];
