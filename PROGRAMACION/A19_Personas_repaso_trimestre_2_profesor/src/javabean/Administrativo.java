package javabean;

public class Administrativo extends AbstractPersona{
	
	private String tareas;

	public Administrativo() {
		super();
	}

	public Administrativo(String nif, String nombre, String direccion, String telefono, String tareas) {
		super(nif, nombre, direccion, telefono);
		this.tareas = tareas;
	}

	public String getTareas() {
		return tareas;
	}

	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	@Override
	public String toString() {
		return "Administrativo [nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", tareas=" + tareas + "]";
	}
	
	public String gestionarMatricula() {
		return "Soy administrativo me llamo " + nombre;
	}

	@Override
	public String trabajar() {
		// TODO Auto-generated method stub
		return tareas;
	}
	
	
	
	
	
	
	
	

}
