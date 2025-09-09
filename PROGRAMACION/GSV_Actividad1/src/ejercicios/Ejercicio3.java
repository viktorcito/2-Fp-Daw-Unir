package ejercicios;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		int contador = 0;
		int suma = 0;
		int pares = 0;
		
		for (int i = 100; i >= 0; i-=7) {
			System.out.println(i);
			suma += i;
			contador++;
			if (i % 2 == 0) {
				pares++;
			}
		}
		
		System.out.println("Números escritos: " + contador);
        System.out.println("Suma de los números escritos: " + suma);
        System.out.println("Cantidad de números pares: " + pares);

	}

}
