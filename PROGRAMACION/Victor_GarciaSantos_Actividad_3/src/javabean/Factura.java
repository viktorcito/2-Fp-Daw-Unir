package javabean;

import java.time.LocalDate;

public class Factura {

	private String codigoFactura;
    private String descripcion;
    private LocalDate fechaFactura;
    private Pedido pedido;
	public Factura() {
		super();
	}
	public Factura(String codigoFactura, String descripcion, LocalDate fechaFactura, Pedido pedido) {
		super();
		this.codigoFactura = codigoFactura;
		this.descripcion = descripcion;
		this.fechaFactura = fechaFactura;
		this.pedido = pedido;
	}
	public String getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "Factura [codigoFactura=" + codigoFactura + ", descripcion=" + descripcion + ", fechaFactura="
				+ fechaFactura + ", pedido=" + pedido + "]";
	}
	
}
