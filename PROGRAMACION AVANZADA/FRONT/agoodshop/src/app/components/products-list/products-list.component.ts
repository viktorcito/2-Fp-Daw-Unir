
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductCardComponent } from '../product-card/product-card.component';
import { ProductService } from '../../services/product.service';
import { IProduct } from '../../models/product.model';

@Component({
  selector: 'app-products-list',
  standalone: true,
  imports: [
    CommonModule,         
    ProductCardComponent  
  ],
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent {

  products: IProduct[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.products = this.productService.getAllProducts();
  }

  
  refresh(): void {
    this.loadProducts();
  }

}

