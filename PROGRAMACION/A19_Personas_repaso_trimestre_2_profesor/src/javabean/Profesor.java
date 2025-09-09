package javabean;

public class Profesor extends AbstractPersona{
	
	private String competencias;

	public Profesor() {
		super();
	}

	public Profesor(String nif, String nombre, String direccion, String telefono, String competencias) {
		super(nif, nombre, direccion, telefono);
		this.competencias = competencias;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	@Override
	public String toString() {
		return "Profesor [nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", competencias=" + competencias + "]";
	}
	
	
	public String ponerNotas() {
		return "Soy un profe entregado me llamo " + nombre + " y me paso el dia corrigiendo";
	}

	@Override
	public String trabajar() {
		// TODO Auto-generated method stub
		return "Yo doy cursos de : " + competencias;
	}
	
	
	
	
	
	

}
