package javabean;

public class Producto {

	private long codigoDeBarras;
	private String descripcion;
	private double precioUnitario;
	private int cantidadStock;
	private String talla;
	private String color;
	
	
	public Producto(long codigoDeBarras, String descripcion, double precioUnitario, int cantidadStock, String talla,
			String color) {
		super();
		this.codigoDeBarras = codigoDeBarras;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.cantidadStock = cantidadStock;
		this.talla = talla;
		this.color = color;
	}


	public Producto() {
		super();
	}


	public long getCodigoDeBarras() {
		return codigoDeBarras;
	}


	public void setCodigoDeBarras(long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public int getCantidadStock() {
		return cantidadStock;
	}


	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public String getTalla() {
		return talla;
	}


	public void setTalla(String talla) {
		this.talla = talla;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Producto [codigoDeBarras=" + codigoDeBarras + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + ", cantidadStock=" + cantidadStock + ", talla=" + talla + ", color=" + color + "]";
	}
	
	//AHORA CREO LOS METODOS PROPIOS
	
	public double precioConIva() {
		return precioUnitario * 1.21;
	}
	
	public void aumentarStock(int cantidad) {
		
		cantidadStock += cantidad;
		
	}
	
	public boolean disminuirStock(int cantidad) {
	    if (cantidad > cantidadStock) {
	        System.out.println("No hay suficiente stock para disminuir esa cantidad.");
	        return false;
	    } else {
	    	cantidadStock -= cantidad;
	    	return true;
	    }
	}
	
	public double precioAplicado() {
		double precioConjunto = precioConIva();
        switch (talla) {
            case "XS":
                return precioConjunto;
            case "S","M","L","XL":
                return precioConjunto * 1.03;
            case "XXL","XXXL":
                return precioConjunto * 1.04;
            default:
                return precioConjunto;
        }
    }
	
	
}
