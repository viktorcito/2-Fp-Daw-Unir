import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { lastValueFrom, Observable } from 'rxjs';
import { IProduct, ProductsResponse } from '../interfaces/iproduct';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  httpClient = inject(HttpClient);
  private apiUrl = 'https://peticiones.online/api/products';

  constructor() { }

  getAllWithObservables(): Observable<ProductsResponse> {
    return this.httpClient.get<ProductsResponse>(this.apiUrl);
  }

  
  async getAllWithPromises(): Promise<IProduct[]> {
    const resp = await lastValueFrom(
      this.httpClient.get<ProductsResponse>(this.apiUrl)
    );
    return resp.results;
  }

  
  getByIdWithObservable(_id: string): Observable<IProduct> {
    return this.httpClient.get<IProduct>(`${this.apiUrl}/${_id}`);
  }

 
  getById(_id: string): Promise<IProduct> {
    return lastValueFrom(this.httpClient.get<IProduct>(`${this.apiUrl}/${_id}`));
  }

  
  insertObservable(product: IProduct): Observable<IProduct> {
    return this.httpClient.post<IProduct>(this.apiUrl, product);
  }

 
  insert(product: IProduct): Promise<IProduct> {
    return lastValueFrom(this.httpClient.post<IProduct>(this.apiUrl, product));
  }

  
  update(product: IProduct): Promise<IProduct> {
    return lastValueFrom(this.httpClient.put<IProduct>(`${this.apiUrl}/${product._id}`, product));
  }

  
  delete(_id: string): Promise<IProduct> {
    return lastValueFrom(this.httpClient.delete<IProduct>(`${this.apiUrl}/${_id}`));
  }
}
