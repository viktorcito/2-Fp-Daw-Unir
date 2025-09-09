package app;

public class Fiesta {
    
    private String tipoFiesta;
    private String direccion;
    private int bocadillos;
    private int bebidas;
    private int invitados;
    private String fecha;
    private String hora;

    
    private static final double PRECIO_INVITADO = 5.0;
    private static final double PRECIO_BEBIDA = 2.0;
    private static final double PRECIO_BOCADILLO = 3.0;

    /**
     * Primero hago un con constructor con todos los parámetros.
     */
    public Fiesta(String tipoFiesta, String direccion, int bocadillos, int bebidas, int invitados, String fecha, String hora) {
        this.tipoFiesta = tipoFiesta;
        this.direccion = direccion;
        this.bocadillos = bocadillos;
        this.bebidas = bebidas;
        this.invitados = invitados;
        this.fecha = fecha;
        this.hora = hora;
    }

    /**
     * Constructor sin parámetros para que no de ninguna excepcion tambien se puede hacer vacio sin poner nada.
     */
    public Fiesta() {
        this.tipoFiesta = "";
        this.direccion = "";
        this.bocadillos = 0;
        this.bebidas = 0;
        this.invitados = 0;
        this.fecha = "";
        this.hora = "";
    }

    //Poner los que te piden aunque yo siempre sulop poner todos
    public String getTipoFiesta() {
        return tipoFiesta;
    }

    public void setTipoFiesta(String tipoFiesta) {
        this.tipoFiesta = tipoFiesta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getBocadillos() {
        return bocadillos;
    }

    public void setBocadillos(int bocadillos) {
        this.bocadillos = bocadillos;
    }

    public int getBebidas() {
        return bebidas;
    }

    public void setBebidas(int bebidas) {
        this.bebidas = bebidas;
    }

    public int getInvitados() {
        return invitados;
    }

    public void setInvitados(int invitados) {
        this.invitados = invitados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

   
    @Override
    public String toString() {
        return "Fiesta{" +
                "tipoFiesta='" + tipoFiesta + '\'' +
                ", direccion='" + direccion + '\'' +
                ", bocadillos=" + bocadillos +
                ", bebidas=" + bebidas +
                ", invitados=" + invitados +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

    /**
     * Aumenta en 1 el contador de invitados.
     */
    public void invitar() {
        this.invitados += 1;
    }

    /**
     * Resta en 1 el contador de invitados.
     */
    public void cancelarInvitacion() {
        if (this.invitados > 0) {
            this.invitados -= 1;
        } else {
            System.out.println("No hay invitados para cancelar.");
        }
    }

    /**
     * Aumenta el contador de invitados en la cantidad especificada.
     *
     * @param cantidad Cantidad de invitados a añadir.
     */
    public void invitar(int cantidad) {
        if (cantidad > 0) {
            this.invitados += cantidad;
        } else {
            System.out.println("La cantidad debe ser mayor que cero.");
        }
    }

    /**
     * Resta del contador de invitados la cantidad especificada.
     *
     * @param cantidad Cantidad de invitados a restar.
     */
    public void cancelarInvitacion(int cantidad) {
        if (cantidad > 0) {
            if (this.invitados >= cantidad) {
                this.invitados -= cantidad;
            } else {
                System.out.println("No hay suficientes invitados para cancelar esa cantidad.");
            }
        } else {
            System.out.println("La cantidad debe ser mayor que cero.");
        }
    }

    /**
     * Calcula y retorna el precio total de la fiesta.
     *
     * @return Precio total de la fiesta.
     */
    public double precioFiesta() {
        return (this.invitados * PRECIO_INVITADO) + (this.bebidas * PRECIO_BEBIDA) + (this.bocadillos * PRECIO_BOCADILLO);
    }
}
