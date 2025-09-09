package proyectos.modelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Cliente;
import proyectos.modelo.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, String>{

	Optional<Factura> findByProyectoIdProyecto(String idProyecto);
}
