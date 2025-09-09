import { Component, inject } from '@angular/core';
import { IProduct } from '../../interfaces/iproduct';
import { ProductCardComponent } from '../../components/product-card/product-card.component';
import { ProductService } from '../../services/product.service';

@Component({
  standalone: true,
  selector: 'app-product-list',
  imports: [ProductCardComponent],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  
  arrProducts: IProduct[];
  productService  = inject(ProductService);

  constructor() {
    this.arrProducts = [];
  }

  async ngOnInit(): Promise<void> {
    
    this.productService.getAllWithObservables().subscribe((data) => {
      
      this.arrProducts = data.results;
    });

    // O usando promesas
    /*
    try {
      this.arrProducts = await this.productsService.getAllWithPromises();
    } catch (err) {
      console.log('Error al conectar con la API: ' + err);
    }
    */
  }

}
