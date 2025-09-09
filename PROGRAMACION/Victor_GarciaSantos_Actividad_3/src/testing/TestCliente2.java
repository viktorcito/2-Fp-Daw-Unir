package testing;

import java.time.LocalDate;
import java.util.ArrayList;

import javabean.Banco;
import javabean.Cliente2;
import javabean.DireccionCliente;
import javabean.Pais;
import javabean.TarjetaBancaria;

public class TestCliente2 {

	public static void main(String[] args) {
		
		
		Pais pais1 = new Pais(1,"Hungria");
		Pais pais2 = new Pais(2,"Rumania");

		Banco banco1 = new Banco(669,"Banco Budapest",pais1);
		Banco banco2 = new Banco(700,"Banco Bucarest",pais2);
		
		TarjetaBancaria tarjeta1 = new TarjetaBancaria(66666666, 2025, 3, 606, banco1);
	    TarjetaBancaria tarjeta2 = new TarjetaBancaria(77777777, 2025, 6, 707, banco2);
		
	    DireccionCliente direccion = new DireccionCliente("Kaleti 66","Budapest","Budapest",pais1);
                 
	    Cliente2 cliente2 = new Cliente2("v","Victor Garcia","victor@ejemplo.com",LocalDate.now(),direccion, null);     

	    ArrayList<TarjetaBancaria> listaTarjetas = new ArrayList<>();
        listaTarjetas.add(tarjeta1);
        listaTarjetas.add(tarjeta2);
        
        cliente2.setTarjetas(listaTarjetas);
        
        System.out.println("Cliente: " + cliente2.getNombre());
        for (TarjetaBancaria tarjeta : cliente2.getTarjetas()) {
            System.out.println(" - Tarjeta num: " + tarjeta.getNumero());
            System.out.println("   Banco: " + tarjeta.getBanco().getNombre());
            System.out.println("   País del banco: " + tarjeta.getBanco().getPaisOpera().getNombre());
        }
	    
	}

}
