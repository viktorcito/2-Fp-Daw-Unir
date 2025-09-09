package cajeroweb.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cajeroweb.modelo.entidades.Cuenta;
import cajeroweb.modelo.repository.CuentaRepository;

@Repository
public class CuentaDaoImpl implements CuentaDao {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Cuenta buscarCuentaPorId(int idCuenta) {
        return cuentaRepository.findById(idCuenta).orElse(null);
    }

    @Override
    public int modificarCuenta(Cuenta cuenta) {
        if (cuentaRepository.existsById(cuenta.getIdCuenta())) {
            cuentaRepository.save(cuenta);
            return 1;
        }
        return 0;
    }

}

