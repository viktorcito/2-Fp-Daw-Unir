package proyectos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.modelo.dto.FacturaDto;
import proyectos.modelo.service.FacturaService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
    private FacturaService facturaService;

    @GetMapping("/factura/{idProyecto}")
    public ResponseEntity<FacturaDto> obtenerFactura(@PathVariable String idProyecto) {
        FacturaDto dto = facturaService.generarFacturaPorProyecto(idProyecto);
        return ResponseEntity.ok(dto);
    }
}
