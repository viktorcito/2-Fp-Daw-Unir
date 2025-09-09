package proyectos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.modelo.entity.Cliente;
import proyectos.modelo.entity.ProyectoConEmpleados;

public interface ProyectoConEmpleadosRepository extends JpaRepository<ProyectoConEmpleados, Integer>{

	List<ProyectoConEmpleados> findByProyectoIdProyecto(String idProyecto);
}
