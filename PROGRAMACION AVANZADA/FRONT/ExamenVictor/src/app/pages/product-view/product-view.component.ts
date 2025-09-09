import { Component, inject } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from '../../interfaces/iproduct';

@Component({
  selector: 'app-product-view',
  standalone: true,
  imports: [],
  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.css'
})
export class ProductViewComponent {

  productsService = inject(ProductService);
  activatedRoute = inject(ActivatedRoute);

  miProduct!: IProduct;

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(async (params: any) => {
      let _id: string = params._id as string;
      try {
        this.miProduct = await this.productsService.getById(_id);
      } catch (err) {
        console.log('Error al llamar a la API: ' + err);
      }
    });
  }

}
