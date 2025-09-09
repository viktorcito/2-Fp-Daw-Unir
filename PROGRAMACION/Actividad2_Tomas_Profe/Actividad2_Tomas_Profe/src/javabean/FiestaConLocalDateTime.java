package javabean;

import java.time.LocalDate;
import java.time.LocalTime;

public class FiestaConLocalDateTime {
	/*
	 * CONSTANTES
	 *  5 euros por cada invitado, 2 euros por cada bebida y 3 euros por cada
		bocadillo
	 */
	
	public static final double PRECIO_INVITADO =5;
	public static final double PRECIO_BOCADILLO =3;
	public static final double PRECIO_BEBIDA =3;
	

	private String tipoFiesta;
	private String direccion;
	private int bocadillos;
	private int bebidas;
	private int invitados;
	private LocalDate fecha;
	private LocalTime hora;
	
	//para el new: constructores
	
	public FiestaConLocalDateTime() {
		
	}
	
	

	
	
	public FiestaConLocalDateTime(String tipoFiesta, String direccion, int bocadillos, int bebidas, int invitados,
			LocalDate fecha, LocalTime hora) {
		super();
		this.tipoFiesta = tipoFiesta;
		this.direccion = direccion;
		this.bocadillos = bocadillos;
		this.bebidas = bebidas;
		this.invitados = invitados;
		this.fecha = fecha;
		this.hora = hora;
	}





	///  una vez existe el objeto en memoria : las variables privates de la clase

	
	
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

	
	
	
	
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}





	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}





	public LocalTime getHora() {
		return hora;
	}





	public void setHora(LocalTime hora) {
		this.hora = hora;
	}





	public void invitar() {
		invitados++;
		
	}
	
	


	@Override
	public String toString() {
		return "FiestaConLocalDateTime [tipoFiesta=" + tipoFiesta + ", direccion=" + direccion + ", bocadillos="
				+ bocadillos + ", bebidas=" + bebidas + ", invitados=" + invitados + ", fecha=" + fecha + ", hora="
				+ hora + "]";
	}





	// metodos propios
	public void invitar2() {
		invitados++;
	}
	
	public void cancelarInvitacion() {
		invitados--;
	}
	
	public void invitar(int cantidad) {
		invitados += cantidad;
	}
	public void cancelarInvitacion(int cantidad) {
		invitados -= cantidad;
	}
	
	public double precioFiesta() {
		return invitados * PRECIO_INVITADO + bocadillos * PRECIO_BOCADILLO 
				+ bebidas * PRECIO_BEBIDA;
	}
	
	
	
	
	
	
	
	

}
