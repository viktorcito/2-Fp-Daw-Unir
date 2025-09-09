package cajeroweb.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cajeroweb.modelo.entidades.Movimiento;
import cajeroweb.modelo.entidades.Cuenta;
import cajeroweb.modelo.repository.MovimientoRepository;
import java.util.List;

@Repository
public class MovimientoDaoImpl implements MovimientoDao {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public Movimiento insertarMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public List<Movimiento> buscarMovimientosPorCuenta(Cuenta cuenta) {
        return movimientoRepository.findByCuenta(cuenta);
    }

}
