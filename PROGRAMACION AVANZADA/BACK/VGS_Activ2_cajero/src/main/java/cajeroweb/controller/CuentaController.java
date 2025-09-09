package cajeroweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cajeroweb.modelo.entidades.Cuenta;
import cajeroweb.modelo.dao.CuentaDao;
import jakarta.servlet.http.HttpSession;

@Controller
public class CuentaController {

    @Autowired
    private CuentaDao cuentaDao;

    /**
     * Muestra la página de login para ingresar el número de cuenta.
     */
    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    /**
     * Procesa el login y valida si la cuenta existe.
     */
    @PostMapping("/login")
    public String procesarLogin(@RequestParam("idCuenta") int idCuenta, HttpSession session, Model model) {
        Cuenta cuenta = cuentaDao.buscarCuentaPorId(idCuenta);
        if (cuenta != null) {
            session.setAttribute("cuenta", cuenta);
            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Cuenta no existe");
            return "login";
        }
    }

    /**
     * Muestra el menú principal si el usuario ha iniciado sesión.
     */
    @GetMapping("/menu")
    public String mostrarMenu(HttpSession session) {
        if (session.getAttribute("cuenta") == null) {
            return "redirect:/";
        }
        return "menu";
    }

    /**
     * Cierra la sesión del usuario.
     */
    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
