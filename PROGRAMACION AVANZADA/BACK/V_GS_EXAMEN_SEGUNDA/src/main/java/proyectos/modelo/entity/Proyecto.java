package proyectos.modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="proyectos")
@Data
@NoArgsConstructor
public class Proyecto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_proyecto")
	private String idProyecto;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_previsto")
	private LocalDate fechaFinPrevisto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_real")
	private LocalDate fechaFinReal;
	
	@Column(name="venta_previsto")
	private double ventaPrevisto;
	
	@Column(name="costes_previsto")
	private double costesPrevisto;
	
	@Column(name="coste_real")
	private double costeReal;
	
	@Enumerated(EnumType.STRING)
	private EstadoProyecto estado;
	
	@ManyToOne
	@JoinColumn(name="jefe_proyecto")
	private Empleado jefeProyecto;
	
	@ManyToOne
	@JoinColumn(name="cif")
	private Cliente cliente;
	
	
	
	
	

}
