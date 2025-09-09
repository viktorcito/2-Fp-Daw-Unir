import { Routes } from '@angular/router';

import { ProductListComponent } from './pages/product-list/product-list.component';  
import { ProductViewComponent } from './pages/product-view/product-view.component';


export const routes: Routes = [
  { path: '', redirectTo: 'product-list', pathMatch: 'full' },
  { path: 'product-list', component: ProductListComponent }, 
  { path: 'product/:_id', component: ProductViewComponent },
  { path: '**', redirectTo: 'product-list' }
];
