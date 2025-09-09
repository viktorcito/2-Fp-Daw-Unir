package testing;

import java.time.LocalDate;

import javabean.Banco;
import javabean.Cliente;
import javabean.DireccionCliente;
import javabean.Factura;
import javabean.Pais;
import javabean.Pedido;
import javabean.TarjetaBancaria;

public class Test {

	public static void main(String[] args) {
		
		
		Pais pais1 = new Pais(1,"Hungria");
		Pais pais2 = new Pais(2,"Rumania");

		Banco banco1 = new Banco(669,"Banco Budapest",pais1);
		Banco banco2 = new Banco(700,"Banco Bucarest",pais2);
		
		TarjetaBancaria tarjeta1 = new TarjetaBancaria(66666666, 2025, 3, 606, banco1);
	    TarjetaBancaria tarjeta2 = new TarjetaBancaria(77777777, 2025, 6, 707, banco2);
		
	    DireccionCliente direccion = new DireccionCliente("Kaleti 66","Budapest","Budapest",pais1);
                 
	    Cliente cliente = new Cliente("v","Victor Garcia","victor@ejemplo.com",LocalDate.now(),direccion,tarjeta1);    
                                  
	    Pedido pedido = new Pedido(100,LocalDate.of(2025, 3, 15),"Pendiente",cliente);
                
                
	    Factura factura = new Factura("FACTURA 1","Compra",LocalDate.now(),pedido);
                
                
	    System.out.println("1* Descripción de la Factura: " + factura.getDescripcion());
	    
        System.out.println("2* Fecha del pedido: " + pedido.getCreateAt() + " | Estado del pedido: " + pedido.getEstado());  
                           
        System.out.println("3* Nombre del cliente: " + pedido.getCliente().getNombre());
             
        System.out.println("4* Dirección del cliente: " + direccion.getDireccion());
                        
        System.out.println("5* Número de tarjeta: " + tarjeta1.getNumero()); 
        
        System.out.println("6* Titular de la tarjeta: " + pedido.getCliente().getNombre());
                
        System.out.println("7* Nombre del banco: " + banco1.getNombre() );
                
        System.out.println("8* País del banco: " + pais1.getNombre() );
                
        System.out.println("9* País de la dirección: " + pais1.getNombre() );
               
                
        
	    
	    
	    
	}

}
