package javabean;

public class Banco {

	private int codigo;
    private String nombre;
    private Pais paisOpera;
	public Banco() {
		super();
	}
	public Banco(int codigo, String nombre, Pais paisOpera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.paisOpera = paisOpera;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPaisOpera() {
		return paisOpera;
	}
	public void setPaisOpera(Pais paisOpera) {
		this.paisOpera = paisOpera;
	}
	@Override
	public String toString() {
		return "Banco [codigo=" + codigo + ", nombre=" + nombre + ", paisOpera=" + paisOpera + "]";
	}
	
    
	
}
