package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int pares = 0;
		int impar = 0;
		int sumPar = 0;
		int sumImpar =0;
		int cantidadNumeros;
		
		System.out.print("¿Cuántos números deseas introducir?: ");
        cantidadNumeros = leer.nextInt();
		
		for (int i = 0; i < cantidadNumeros; i++) {
			System.out.print("Introduce un número: ");
            int num = leer.nextInt();
            
            
			if (num % 2 == 0) {
				pares ++;
				sumPar += num;
				System.out.println(num  + " es par");
			}else {
				impar ++;
				sumImpar +=num;
				System.out.println(num  + " es impar");
			} 
					
		}
		
		 System.out.println("Pares: " + pares + ", Impares: " + impar);
	     System.out.println("Suma de pares: " + sumPar + ", Suma de impares: " + sumImpar);
		
	     leer.close();

	}

}
