package proyectos.modelo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.modelo.dto.FacturaDto;
import proyectos.modelo.dto.RecursoEmpleadoDto;
import proyectos.modelo.entity.Cliente;
import proyectos.modelo.entity.Empleado;
import proyectos.modelo.entity.Factura;
import proyectos.modelo.entity.Proyecto;
import proyectos.modelo.entity.ProyectoConEmpleados;
import proyectos.modelo.repository.ClienteRepository;
import proyectos.modelo.repository.EmpleadoRepository;
import proyectos.modelo.repository.FacturaRepository;
import proyectos.modelo.repository.ProyectoConEmpleadosRepository;
import proyectos.modelo.repository.ProyectoRepository;


@Service
public class FacturaServiceImpl implements FacturaService{
	
	 @Autowired
	    private FacturaRepository facturaRepository;

	    @Autowired
	    private ProyectoRepository proyectoRepository;

	    @Autowired
	    private ClienteRepository clienteRepository;

	    @Autowired
	    private EmpleadoRepository empleadoRepository;

	    @Autowired
	    private ProyectoConEmpleadosRepository proyectoConEmpleadosRepository;

	@Override
	public FacturaDto generarFacturaPorProyecto(String idProyecto) {
		// TODO Auto-generated method stub
		   Factura factura = facturaRepository
	                .findByProyectoIdProyecto(idProyecto)
	                .orElseThrow(() -> new RuntimeException("No existe factura para proyecto " + idProyecto));

	        
	        Proyecto proyecto = factura.getProyecto(); 
	        

	        
	        Cliente cliente = proyecto.getCliente(); 
	       

	        
	        List<ProyectoConEmpleados> asignaciones = proyectoConEmpleadosRepository.findByProyectoIdProyecto(idProyecto);
	        
	        
	        double totalFacturado = 0.0;
	        int totalHoras = 0;
	        
	        
	        List<RecursoEmpleadoDto> recursos = new ArrayList<>();

	        for (ProyectoConEmpleados asign : asignaciones) {
	            
	            Empleado empleado = asign.getEmpleado();

	            
	            double salario = empleado.getSalario(); 
	            double costeHora = salario / 1800.0; 

	            
	            double repercutido = costeHora * asign.getHorasAsignadas();

	            
	            RecursoEmpleadoDto rec = new RecursoEmpleadoDto();
	            rec.setApellidos(empleado.getApellidos());
	            rec.setNombre(empleado.getNombre());
	            rec.setHorasAsignadas(asign.getHorasAsignadas());
	            rec.setImporteRepercutido(repercutido);

	            recursos.add(rec);

	            
	            totalFacturado += repercutido;
	            totalHoras += asign.getHorasAsignadas();
	        }

	        
	        FacturaDto dto = new FacturaDto();

	        
	        dto.setCodigoFactura(factura.getIdFactura());
	        dto.setDescripcionFactura(factura.getDescripcion());
	        
	        
	        
	        dto.setNombreCliente(cliente.getNombre() + " " + cliente.getApellidos());
	        dto.setDireccionCliente(cliente.getDomicilio());

	        
	        dto.setCodigoProyecto(proyecto.getIdProyecto());
	        dto.setDescripcionProyecto(proyecto.getDescripcion());
	        dto.setFechaInicio(proyecto.getFechaInicio());
	        dto.setFechaFinReal(proyecto.getFechaFinReal());

	        
	        dto.setRecursos(recursos);
	        dto.setTotalHoras(totalHoras);

	        
	        dto.setImporteVenta(proyecto.getVentaPrevisto());

	        
	        dto.setTotalFacturado(totalFacturado);

	        return dto;
	}

}
