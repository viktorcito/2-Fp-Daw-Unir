package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		System.out.print("Introduce una nota (0 a 10): ");
		int nota = leer.nextInt();
		
		if (nota <= 4) {
			System.out.println("Insuficiente");
		}if (nota == 5) {
			System.out.println("Suficiente");
		}if (nota == 6) {
			System.out.println("Bien");
		}if (nota >= 7 && nota <= 8) {
			System.out.println("Notable");
		}if (nota >= 9 && nota <= 10) {
			System.out.println("Sobresaliente");
		}if (nota > 10) {
			System.out.println("Nota erronea");
		}
		
		leer.close();
	}

}
