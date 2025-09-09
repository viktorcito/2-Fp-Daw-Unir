package proyectos.modelo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="proyecto_con_empleados")
@Data
@NoArgsConstructor
public class ProyectoConEmpleados implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="numero_orden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroOrden;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name="id_empl")
	private Empleado empleado;
	
	@Column(name="horas_asignadas")
	private int horasAsignadas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_incorporacion")
	private LocalDate fechaIncorporacion;
	

}
