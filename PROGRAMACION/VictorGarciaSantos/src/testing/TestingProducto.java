package testing;

import javabean.Producto;

public class TestingProducto {
    
    private static Producto producto1 = new Producto(123456789L, "Camiseta", 20.0, 50, "M", "Rojo");
    private static Producto producto2 = new Producto(987654321L, "Pantalón", 40.0, 30, "L", "Azul");

    public static void main(String[] args) {
        pruebaPrecioConIva();
        pruebaAumentarStock();
        pruebaDisminuirStock();
        pruebaPrecioAplicado();
    }

    //Deje la plantilla de la clase de repaso como enseñastes tomas asi he podido completar todo gracias
    
    public static void pruebaPrecioConIva() {
        System.out.println("\n*** PRUEBA PRECIO CON IVA ***");
        System.out.println("Precio con IVA (producto1): " + producto1.precioConIva()); 
        System.out.println("Precio con IVA (producto2): " + producto2.precioConIva()); 
    }

    public static void pruebaAumentarStock() {
        System.out.println("\n*** PRUEBA AUMENTAR STOCK ***");
        producto1.aumentarStock(20);
        System.out.println("Nuevo stock de producto1: " + producto1.getCantidadStock()); 
    }

    public static void pruebaDisminuirStock() {
        System.out.println("\n*** PRUEBA DISMINUIR STOCK ***");
        System.out.println("Disminuir 30 del producto1: " + producto1.disminuirStock(30)); 
        System.out.println("Stock actual de producto1: " + producto1.getCantidadStock()); 

        System.out.println("Disminuir 50 del producto1: " + producto1.disminuirStock(50)); 
        System.out.println("Stock actual de producto1: " + producto1.getCantidadStock()); 

        System.out.println("Disminuir -5 del producto1: " + producto1.disminuirStock(-5)); 
        System.out.println("Stock actual de producto1: " + producto1.getCantidadStock()); 
    }

    public static void pruebaPrecioAplicado() {
        System.out.println("\n*** PRUEBA PRECIO APLICADO ***");
        String[] tallas = {"XS", "S", "M", "L", "XL", "XXL", "XXXL"};

        for (String talla : tallas) {
            producto1.setTalla(talla);
            System.out.println("Talla: " + talla + ", Precio aplicado: " + producto1.precioAplicado());
        }
    }
}