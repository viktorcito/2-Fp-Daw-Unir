package cajeroweb.modelo.dao;

import java.util.List;
import cajeroweb.modelo.entidades.Movimiento;
import cajeroweb.modelo.entidades.Cuenta;

public interface MovimientoDao {

    Movimiento insertarMovimiento(Movimiento movimiento);

    List<Movimiento> buscarMovimientosPorCuenta(Cuenta cuenta);

}
