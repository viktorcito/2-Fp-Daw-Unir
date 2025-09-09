package cajeroweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cajeroweb.modelo.entidades.Cuenta;
import cajeroweb.modelo.entidades.Movimiento;
import cajeroweb.modelo.dao.CuentaDao;
import cajeroweb.modelo.dao.MovimientoDao;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/operacion")
public class OperacionController {

    @Autowired
    private CuentaDao cuentaDao;

    @Autowired
    private MovimientoDao movimientoDao;

    /**
     * Muestra el formulario para ingresar dinero.
     */
    @GetMapping("/ingresar")
    public String mostrarIngreso(HttpSession session) {
        if (session.getAttribute("cuenta") == null) {
            return "redirect:/";
        }
        return "ingresar";
    }

    /**
     * Procesa el ingreso de dinero y actualiza el saldo y movimientos.
     */
    @PostMapping("/ingresar")
    public String procesarIngreso(@RequestParam("cantidad") double cantidad, HttpSession session, Model model) {
        Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
        cuenta.setSaldo(cuenta.getSaldo() + cantidad);
        int resultado = cuentaDao.modificarCuenta(cuenta);

        if (resultado == 1) {
            Movimiento movimiento = new Movimiento();
            movimiento.setCuenta(cuenta);
            movimiento.setFecha(new Date());
            movimiento.setCantidad(cantidad);
            movimiento.setOperacion("ABONO");
            movimientoDao.insertarMovimiento(movimiento);

            session.setAttribute("cuenta", cuenta);
            model.addAttribute("mensaje", "Ingreso realizado con éxito");
        } else {
            model.addAttribute("error", "Error al realizar el ingreso");
        }

        return "ingresar";
    }

    /**
     * Muestra el formulario para extraer dinero.
     */
    @GetMapping("/extraer")
    public String mostrarExtraccion(HttpSession session) {
        if (session.getAttribute("cuenta") == null) {
            return "redirect:/";
        }
        return "extraer";
    }

    /**
     * Procesa la extracción de dinero, verificando el saldo.
     */
    @PostMapping("/extraer")
    public String procesarExtraccion(@RequestParam("cantidad") double cantidad, HttpSession session, Model model) {
        Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");

        if (cuenta.getSaldo() - cantidad >= 0) {
            cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            int resultado = cuentaDao.modificarCuenta(cuenta);

            if (resultado == 1) {
                Movimiento movimiento = new Movimiento();
                movimiento.setCuenta(cuenta);
                movimiento.setFecha(new Date());
                movimiento.setCantidad(-cantidad);
                movimiento.setOperacion("CARGO");
                movimientoDao.insertarMovimiento(movimiento);

                session.setAttribute("cuenta", cuenta);
                model.addAttribute("mensaje", "Extracción realizada con éxito");
            } else {
                model.addAttribute("error", "Error al realizar la extracción");
            }
        } else {
            model.addAttribute("error", "Saldo insuficiente");
        }

        return "extraer";
    }

    /**
     * Muestra la lista de movimientos de la cuenta.
     */
    @GetMapping("/movimientos")
    public String verMovimientos(HttpSession session, Model model) {
        if (session.getAttribute("cuenta") == null) {
            return "redirect:/";
        }

        Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
        List<Movimiento> movimientos = movimientoDao.buscarMovimientosPorCuenta(cuenta);
        model.addAttribute("movimientos", movimientos);
        model.addAttribute("saldo", cuenta.getSaldo());
        model.addAttribute("numeroCuenta", cuenta.getIdCuenta());
        return "movimientos";
    }
    
    
    
    
    /**
     * Muestra el formulario para transferir dinero.
     */
    @GetMapping("/transferir")
    public String mostrarTransferencia(HttpSession session, Model model) {
        if (session.getAttribute("cuenta") == null) {
            return "redirect:/";
        }
        Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
        model.addAttribute("numeroCuenta", cuenta.getIdCuenta());
        return "transferir";
    }

    /**
     * Procesa la transferencia de dinero.
     */
    @PostMapping("/transferir")
    public String procesarTransferencia(
            @RequestParam("idCuentaDestino") int idCuentaDestino,
            @RequestParam("cantidad") double cantidad,
            HttpSession session,
            Model model) {

        Cuenta cuentaOrigen = (Cuenta) session.getAttribute("cuenta");

        // Verificar si la cuenta de destino existe
        Cuenta cuentaDestino = cuentaDao.buscarCuentaPorId(idCuentaDestino);
        if (cuentaDestino == null) {
            model.addAttribute("error", "La cuenta de destino no existe");
            return "transferir";
        }

        // Verificar si hay saldo suficiente
        if (cuentaOrigen.getSaldo() < cantidad) {
            model.addAttribute("error", "Saldo insuficiente, operación cancelada");
            return "transferir";
        }

        // Realizar la transferencia
        // Actualizar saldo de la cuenta origen
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
        cuentaDao.modificarCuenta(cuentaOrigen);

        // Insertar movimiento en la cuenta origen
        Movimiento movimientoOrigen = new Movimiento();
        movimientoOrigen.setCuenta(cuentaOrigen);
        movimientoOrigen.setFecha(new Date());
        movimientoOrigen.setCantidad(-cantidad);
        movimientoOrigen.setOperacion("Extracto por transferencia");
        movimientoDao.insertarMovimiento(movimientoOrigen);

        // Actualizar saldo de la cuenta destino
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
        cuentaDao.modificarCuenta(cuentaDestino);

        // Insertar movimiento en la cuenta destino
        Movimiento movimientoDestino = new Movimiento();
        movimientoDestino.setCuenta(cuentaDestino);
        movimientoDestino.setFecha(new Date());
        movimientoDestino.setCantidad(cantidad);
        movimientoDestino.setOperacion("Ingreso por transferencia");
        movimientoDao.insertarMovimiento(movimientoDestino);

        // Actualizar la cuenta en sesión
        session.setAttribute("cuenta", cuentaOrigen);

        model.addAttribute("mensaje", "Transferencia realizada con éxito");
        return "transferir";
    }
    

}
