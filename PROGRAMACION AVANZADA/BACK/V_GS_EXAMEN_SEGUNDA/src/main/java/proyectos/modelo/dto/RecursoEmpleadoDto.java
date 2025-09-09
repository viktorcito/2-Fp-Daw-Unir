package proyectos.modelo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecursoEmpleadoDto {
	
	private String apellidos;
    private String nombre;
    private Integer horasAsignadas;
    private double importeRepercutido;

}
