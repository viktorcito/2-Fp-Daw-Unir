package javabean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Contacto implements Serializable{
	
 
	private static final long serialVersionUID = 1L;
	
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String telefono;
	private LocalDate fechaNacimiento;
	
	public Contacto(int idContacto, String nombre, String apellidos, String telefono, LocalDate fechaNacimiento) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Contacto() {
		super();
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idContacto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contacto))
			return false;
		Contacto other = (Contacto) obj;
		return idContacto == other.idContacto;
	}
	
	
	
	
	

}
