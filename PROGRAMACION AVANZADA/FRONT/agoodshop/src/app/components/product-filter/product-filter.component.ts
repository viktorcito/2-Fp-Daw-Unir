import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

import { ProductService } from '../../services/product.service';
import { IProduct } from '../../models/product.model';
import { ProductCardComponent } from "../product-card/product-card.component";

@Component({
  selector: 'app-product-filter',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ProductCardComponent
],
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.css']
})
export class ProductFilterComponent {
  name: string = '';
  category: string = '';
  price: number | null = null;
  active: string = '';

  filteredProducts: IProduct[] = [];

  constructor(private productService: ProductService) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      // Convertimos el valor "active" a boolean o undefined
      const activeValue = this.active === '' ? undefined : this.active === 'true';

      this.filteredProducts = this.productService.filterProducts(
        this.name,
        this.category,
        this.price || undefined, // Si es null, lo pasamos como undefined
        activeValue
      );
    }
  }

  clearFilters(form: NgForm) {
    this.name = '';
    this.category = '';
    this.price = null;
    this.active = '';
    form.resetForm();
    this.filteredProducts = [];
  }
}

