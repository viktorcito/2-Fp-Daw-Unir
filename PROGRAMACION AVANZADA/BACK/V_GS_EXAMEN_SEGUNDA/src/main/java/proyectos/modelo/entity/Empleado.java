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
@Table(name="empleados")
@Data
@NoArgsConstructor
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empl")
	private int idEmpl;
	
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private double salario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name="id_depar")
	private Departamento departamento;

}
