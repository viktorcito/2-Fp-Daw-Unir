
import { Injectable } from '@angular/core';
import { IProduct } from '../models/product.model';
import { v4 as uuidv4 } from 'uuid'; // Para generar IDs de manera local he instalado esto: npm install uuid


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl: string = 'http://jsonblob.com/1333102442090520576';
  
  // Paso 1: GUardo los productos en memoria
  private products: IProduct[] = []; //Utilizo el array para guardar una lista de productos que obtengo de la api

  constructor() {
    this.fetchProducts();
  }

  // 2: Cargar los productos usando fetch en vez de https.
  private async fetchProducts(): Promise<void> {
    try {
      const response = await fetch(this.apiUrl); // llama a la API Y obtengo una respuesta
      this.products = await response.json();
    } catch (error) {
      console.error('Error al obtener productos:', error);
    }
  }

  // Devuelvo
  getAllProducts(): IProduct[] {
    return this.products;
  }

  // Agrego
  addProduct(product: IProduct): void {
    
    product._id = uuidv4(); 
    this.products.push(product);
  }

  // Elimino un producto
  removeProduct(productId: string): void {
    this.products = this.products.filter(prod => prod._id !== productId);
  }

  // Método para filtrar lo que me costo buscando por sitios
  filterProducts(name?: string, category?: string, price?: number, active?: boolean): IProduct[] {
    return this.products.filter(product => {
      const matchName = name ? product.name.toLowerCase().includes(name.toLowerCase()) : true;
      const matchCategory = category ? product.category === category : true;
      const matchActive = (active !== undefined) ? product.active === active : true;
      const matchPrice = price ? product.price <= price : true;
      return matchName && matchCategory && matchActive && matchPrice;
    });
  }
}
/*Apuntes para estudiar: Esta clase sirve para un servicio imyectable en cualquier parte de la app */