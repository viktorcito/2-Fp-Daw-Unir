import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductFormComponent } from './components/product-form/product-form.component';
import { ProductFilterComponent } from './components/product-filter/product-filter.component';
import { ProductsListComponent } from './components/products-list/products-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    ProductFormComponent,
    ProductFilterComponent,
    ProductsListComponent
    
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'agoodshop';
}

