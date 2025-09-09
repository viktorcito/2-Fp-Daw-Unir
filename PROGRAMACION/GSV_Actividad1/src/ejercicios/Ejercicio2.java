package ejercicios;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int suma = 0;
		int producto = 1;

		for (int i = 1; i <= 20; i+=2) {
			suma += i;
			producto *= i;
		}
		
		
		System.out.println("Primeros numeros impares " + suma);
		System.out.println("Los primeros productos "+ producto);
		
	}

}
