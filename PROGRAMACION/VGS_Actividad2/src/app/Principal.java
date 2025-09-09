package app;

public class Principal {

	public static void main(String[] args) {

        // Crear objeto fiesta1 con el constructor con parámetros
        Fiesta fiesta1 = new Fiesta("Cumpleaños", "Calle Luna 23", 50, 100, 20, "12/12/2024", "20:00");

        // Crear objeto fiesta2 con el constructor sin parámetros y establecer los valores
        Fiesta fiesta2 = new Fiesta();
        fiesta2.setTipoFiesta("Disfraces");
        fiesta2.setDireccion("Avenida Sol 45");
        fiesta2.setBocadillos(30);
        fiesta2.setBebidas(60);
        fiesta2.setInvitados(10);
        fiesta2.setFecha("31/10/2024");
        fiesta2.setHora("22:00");

        // Probamos los métodos con fiesta1
        System.out.println("Datos de la fiesta 1:");
        System.out.println(fiesta1.toString());
        System.out.println("Precio de la fiesta 1: " + fiesta1.precioFiesta() + " euros");

        fiesta1.invitar();
        fiesta1.invitar(10);
        fiesta1.cancelarInvitacion();
        fiesta1.cancelarInvitacion(3);

        System.out.println("Datos actualizados de la fiesta 1:");
        System.out.println(fiesta1.toString());
        System.out.println("Nuevo precio de la fiesta 1: " + fiesta1.precioFiesta() + " euros");

        // Probamos los métodos con fiesta2
        System.out.println("\nDatos de la fiesta 2:");
        System.out.println(fiesta2.toString());
        System.out.println("Precio de la fiesta 2: " + fiesta2.precioFiesta() + " euros");

        fiesta2.invitar(15);
        fiesta2.cancelarInvitacion(5);

        System.out.println("Datos actualizados de la fiesta 2:");
        System.out.println(fiesta2.toString());
        System.out.println("Nuevo precio de la fiesta 2: " + fiesta2.precioFiesta() + " euros");
    }
}