import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ProductService } from '../../services/product.service';
import { IProduct } from '../../models/product.model';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {

  productForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private productService: ProductService
  ) {
    // Definimos el formulario con sus validaciones
    this.productForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      description: ['', [Validators.required, Validators.minLength(5)]],
      price: [0, [Validators.required, Validators.min(0)]],
      category: ['', Validators.required],
      image: ['', Validators.required],
      active: [true]
    });
  }

  onSubmit(): void {
    if (this.productForm.valid) {
      
      const newProduct: IProduct = this.productForm.value;

      
      this.productService.addProduct(newProduct);

      
      this.productForm.reset({
        name: '',
        description: '',
        price: 0,
        category: '',
        image: '',
        active: true
      });

      alert('Producto agregado correctamente');
    } else {
      alert('Por favor, completa correctamente el formulario');
    }
  }
}
/** this.fb.group({...}) construye un objeto de formulario con campos y validaciones.
 * 
 * (ngSubmit)="onSubmit()"  se llama cuando haces submit en el HTML
 * 
 * this.productService.addProduct(...) para registrar el producto
 * 
 */
