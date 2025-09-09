package testing;

import javabean.Fiesta;

public class TestFiesta {

	public static void main(String[] args) {
		Fiesta fiesta1,fiesta2;
		System.out.println("FIESTA 1");
		fiesta1 = new Fiesta();
		fiesta1.setBebidas(14);
		fiesta1.setBocadillos(14);
		fiesta1.setDireccion("Madrid");
		fiesta1.setFecha("2024-12-02");
		fiesta1.setHora("19:30");
		fiesta1.setInvitados(7);
		fiesta1.setTipoFiesta("Cumple de David");
		
		fiesta1.invitar();// 8
		fiesta1.invitar(20); // 28
		fiesta1.cancelarInvitacion(); // 27
		fiesta1.cancelarInvitacion(10); // 17
		fiesta1.setBebidas(30);
		fiesta1.setBocadillos(34);
		System.out.println(fiesta1);
		System.out.println(fiesta1.precioFiesta());
		
		System.out.println("FIESTA 2");
		fiesta2 = new Fiesta("Epi", "Majadahonda", 234, 6789, 230, "2025-01-01", "18:00");
		fiesta2.invitar();
		fiesta2.invitar(10); 
		fiesta2.cancelarInvitacion(); 
		fiesta2.cancelarInvitacion(3); 
		fiesta2.setBebidas(15);
		fiesta2.setBocadillos(12);
		System.out.println(fiesta2);
		System.out.println(fiesta2.precioFiesta());
		
		 

	}

}
