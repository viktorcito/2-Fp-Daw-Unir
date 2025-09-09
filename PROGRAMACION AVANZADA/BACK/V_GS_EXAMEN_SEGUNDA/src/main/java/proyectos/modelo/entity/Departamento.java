package proyectos.modelo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="departamentos")
@Data
@NoArgsConstructor
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_depar")
	private int idDepar;
	
	private String nombre;
	private String direccion;

}
