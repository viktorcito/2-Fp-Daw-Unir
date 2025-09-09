package cajeroweb.modelo.dao;

import cajeroweb.modelo.entidades.Cuenta;

public interface CuentaDao {

    Cuenta buscarCuentaPorId(int idCuenta);

    int modificarCuenta(Cuenta cuenta);

}
