package testing;

import java.util.List;

import javabean.Familia;
import javabean.Producto;
import javabean.Proveedor;
import negocio.CatalogoProductosImpl;
import negocio.ICatalogo;



public class TestActividad {
	
	private static ICatalogo catalogo = new CatalogoProductosImpl();

	public static void main(String[] args) {
		
		testAltaProducto();
        testBuscarUno();
        testModificarProducto();
        testEliminarProducto();
        
        testBuscarTodos();
        testProductosPorFamilia();
        testProductosPorPrecioMayorQue();
        testProductosPorDescripcionLarga();
        testProductosPorProveedor();
		
	}
	
	public static void nombremetodo() {
		
	}
		
		public static void testAltaProducto() {
			System.out.println("\n=== testAltaProducto ===");
			
			Familia f = new Familia(2, "Especial");
			Proveedor prov = new Proveedor("202", "Juan", "Ropa", "j@j.es", "Portugal");
			Producto nuevo = new Producto(6, "Bufanda", "Bufanda de invierno", "Mango", "Rojo", 15.0, f, prov);
			
			boolean resultado = catalogo.altaProducto(nuevo);
			System.out.println("Resultado alta: " + resultado);  
			
			System.out.println("Catálogo tras alta: " + catalogo.buscarTodos());
		}
		
		public static void testBuscarUno() {
			System.out.println("\n=== testBuscarUno ===");
			Producto p = catalogo.buscarUno(2); 
			System.out.println("Encontrado: " + p); 
		}
		
		public static void testModificarProducto() {
			System.out.println("\n=== testModificarProducto ===");
			
			Producto p = catalogo.buscarUno(1);
			if(p != null) {
				p.setMarca("Nike-Modificado");
				boolean ok = catalogo.modificarProducto(p);
				System.out.println("Resultado modificar: " + ok);
			} else {
				System.out.println("No existe producto con ID 1 para modificar");
			}
			
			System.out.println("Catálogo tras modificar: " + catalogo.buscarTodos());
		}
		
		public static void testEliminarProducto() {
			System.out.println("\n=== testEliminarProducto ===");
			boolean ok = catalogo.eliminarProducto(3); 
			System.out.println("Resultado eliminar: " + ok);
			
			System.out.println("Catálogo tras eliminar producto 3: " + catalogo.buscarTodos());
		}
		
		
		
		public static void testBuscarTodos() {
			System.out.println("\n=== testBuscarTodos ===");
			List<Producto> lista = catalogo.buscarTodos();
			for(Producto p : lista) {
				System.out.println(p);
			}
		}
		
		public static void testProductosPorFamilia() {
			System.out.println("\n=== testProductosPorFamilia ===");
			int idFamilia = 1;
			List<Producto> lista = catalogo.productosPorFamilia(idFamilia);
			System.out.println("Familia " + idFamilia + ", productos encontrados:");
			for(Producto p : lista) {
				System.out.println(p);
			}
		}
		
		public static void testProductosPorPrecioMayorQue() {
			System.out.println("\n=== testProductosPorPrecioMayorQue ===");
			double precio = 50.0;
			List<Producto> lista = catalogo.productosPorPrecioMayorQue(precio);
			System.out.println("Productos con precio > " + precio + ":");
			for(Producto p : lista) {
				System.out.println(p);
			}
		}
		
		public static void testProductosPorDescripcionLarga() {
			System.out.println("\n=== testProductosPorDescripcionLarga ===");
			String subCadena = "mujer";
			List<Producto> lista = catalogo.productosPorDescripcionLarga(subCadena);
			System.out.println("Productos cuya desc. larga contiene '" + subCadena + "':");
			for(Producto p : lista) {
				System.out.println(p);
			}
		}
		
		public static void testProductosPorProveedor() {
			System.out.println("\n=== testProductosPorProveedor ===");
			String cif = "101"; 
			List<Producto> lista = catalogo.productosPorProveedor(cif);
			System.out.println("Productos del proveedor con cif '" + cif + "':");
			for(Producto p : lista) {
				System.out.println(p);
			}
		}
		
	
}
