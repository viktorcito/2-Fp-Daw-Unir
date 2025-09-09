package javabean;

public class DireccionCliente {

	private String direccion;
    private String localidad;
    private String provincia;
    private Pais pais;
	public DireccionCliente() {
		super();
	}
	public DireccionCliente(String direccion, String localidad, String provincia, Pais pais) {
		super();
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "DireccionCliente [direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", pais=" + pais + "]";
	}
    
    
    
	
	
}
