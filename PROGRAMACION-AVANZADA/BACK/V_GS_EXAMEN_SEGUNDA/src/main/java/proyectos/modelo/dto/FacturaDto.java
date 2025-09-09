package proyectos.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDto {

    
    private String codigoFactura;
    private String descripcionFactura;
    private LocalDate fechaFactura; 

    
    private String nombreCliente;
    private String direccionCliente;  

    
    private String codigoProyecto;
    private String descripcionProyecto;
    private LocalDate  fechaInicio;
    private LocalDate  fechaFinReal;

    
    private List<RecursoEmpleadoDto> recursos;

    private Integer totalHoras;      
    private double importeVenta;   
    private double totalFacturado; 

    
}

