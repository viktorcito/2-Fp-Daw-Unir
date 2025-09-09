package excursionweb.modelo.javabean;

import java.util.Date;
import java.util.Objects;

public class Excursion {
    private int idExcursion;
    private String descripcion;
    private String origen;
    private String destino;
    private Date fechaExcursion;
    private int duracion;
    private String estado;  // Valores: "CREADO", "CANCELADO", "TERMINADO"
    private String destacado;  // Valores: "S" o "N"
    private int aforoMaximo;
    private int minimoAsistentes;
    private double precioUnitario;
    private String imagen;
    private Date fechaAlta;

    public Excursion() {
        
        this.estado = "CREADO";
        this.destacado = "N";
    }

    
    public Excursion(int idExcursion, String descripcion, String origen, String destino, Date fechaExcursion, int duracion,
                     String estado, String destacado, int aforoMaximo, int minimoAsistentes, double precioUnitario,
                     String imagen, Date fechaAlta) {
        this.idExcursion = idExcursion;
        this.descripcion = descripcion;
        this.origen = origen;
        this.destino = destino;
        this.fechaExcursion = fechaExcursion;
        this.duracion = duracion;
        this.estado = estado;
        this.destacado = destacado;
        this.aforoMaximo = aforoMaximo;
        this.minimoAsistentes = minimoAsistentes;
        this.precioUnitario = precioUnitario;
        this.imagen = imagen;
        this.fechaAlta = fechaAlta;
    }

    
    

    public int getIdExcursion() {
		return idExcursion;
	}


	public void setIdExcursion(int idExcursion) {
		this.idExcursion = idExcursion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Date getFechaExcursion() {
		return fechaExcursion;
	}


	public void setFechaExcursion(Date fechaExcursion) {
		this.fechaExcursion = fechaExcursion;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDestacado() {
		return destacado;
	}


	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}


	public int getAforoMaximo() {
		return aforoMaximo;
	}


	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}


	public int getMinimoAsistentes() {
		return minimoAsistentes;
	}


	public void setMinimoAsistentes(int minimoAsistentes) {
		this.minimoAsistentes = minimoAsistentes;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	

    @Override
	public int hashCode() {
		return Objects.hash(idExcursion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Excursion other = (Excursion) obj;
		return idExcursion == other.idExcursion;
	}


	@Override
    public String toString() {
        return "Excursion{" +
                "idExcursion=" + idExcursion +
                ", descripcion='" + descripcion + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaExcursion=" + fechaExcursion +
                ", duracion=" + duracion +
                ", estado='" + estado + '\'' +
                ", destacado='" + destacado + '\'' +
                ", aforoMaximo=" + aforoMaximo +
                ", minimoAsistentes=" + minimoAsistentes +
                ", precioUnitario=" + precioUnitario +
                ", imagen='" + imagen + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
