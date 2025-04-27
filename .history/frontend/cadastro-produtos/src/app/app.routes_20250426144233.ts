import { Routes } from '@angular/router';
import { ListaProdutosComponent } from './componentes/lista-produtos/lista-produtos.component';
import { HomeComponent } from './componentes/home/home.component';
import { ProdutosComponent } from './componentes/produtos/produtos.component';
import { VendedorComponent } from './componentes/vendedor/vendedor.component';
import { ListaVendedoresComponent } from './componentes/lista-vendedores/lista-vendedores.component';
import { CadastrarVendedoresComponent } from './componentes/cadastrar-vendedores/cadastrar-vendedores.component';
import { VendasPorVendedorComponent } from './componentes/vendas-por-vendedor/vendas-por-vendedor.component';
import { ListaVendasComponent } from './componentes/lista-vendas/lista-vendas.component';
import { RelatorioVendasComponent }  from './componentes/relatorios-vendas/relatorios-vendas.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'lista-produtos', component: ListaProdutosComponent },
  { path: 'produtos', component: ProdutosComponent},
  { path: 'produtos/editar/:id', component: ProdutosComponent },
  { path: 'vendedor', component: VendedorComponent },
  { path: 'vendedor/editar/:id', component: VendedorComponent },
  { path: 'vendedores/editar/:id', component: VendedorComponent }, // Adicione esta linha
  { path: 'lista-vendedores', component: ListaVendedoresComponent },
  { path: 'vendedores/cadastro', component: CadastrarVendedoresComponent },
  { path: 'vendas/vendedor/:id', component: VendasPorVendedorComponent },
  { path: 'vendas', component: ListaVendasComponent },
  { path: 'relatorios-vendas', component: RelatorioVendasComponent },
  { path: '**', redirectTo: 'home' }
];
