package ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Escribe un nombre");		
		String nombre = leer.nextLine();
		
		if (nombre.equals("sara")) {
			System.out.println("Contraseña porfavor");
			String contraseña = leer.nextLine();
			
			if (contraseña.equals("sarita")) {
				System.out.println("Usuario y contraseña correctas, bienvenido a la aplicación");
			} else {
				System.out.println("Contraseña incorrecta");
			}
			
			
		} else {
            System.out.println("Usuario incorrecto");
        }
		
		
		leer.close();

	}

}
