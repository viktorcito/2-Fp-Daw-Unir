package cajeroweb.modelo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cajeroweb.modelo.entidades.Movimiento;
import cajeroweb.modelo.entidades.Cuenta;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
