export interface IProduct {

_id: string;
  id?: number;            
  name: string;
  description: string;
  price: number;
  category: string;
  image: string;
  active: boolean;
}
export interface ProductsResponse {
    page: number;
    per_page: number;
    total: number;
    total_pages: number;
    results: IProduct[];
  }