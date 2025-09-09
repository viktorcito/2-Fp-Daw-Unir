import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IProduct } from '../../models/product.model';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [
    CommonModule,  
  ],
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent {

  @Input() product!: IProduct;  
  @Output() onRemove = new EventEmitter<void>();

  constructor(private productService: ProductService) {}

  removeProduct(): void {
    if (this.product._id) {
      this.productService.removeProduct(this.product._id);
      this.onRemove.emit();
    }
  }
}
/** utilizo CommonModule para el ngIf que es igual al @ if.
 * @Input() product!: IProduct; Indica que este componente recibe una propiedad “product” desde su padre
 * @Output() define un evento que el componente puede emitir hacia fuera
 * EventEmitter<void> significa que emitirá un evento sin datos extra.
 *   */ 

