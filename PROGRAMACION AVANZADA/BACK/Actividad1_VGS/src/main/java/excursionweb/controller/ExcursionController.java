package excursionweb.controller;

import excursionweb.modelo.dao.ExcursionDao;
import excursionweb.modelo.javabean.Excursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/excursion")
public class ExcursionController {

    @Autowired
    private ExcursionDao excursionDao;

    @GetMapping("/")
    public String getCreadoExcursions(Model model) {
        model.addAttribute("excursiones", excursionDao.findByActivos());
        return "home";
    }

    @GetMapping("/detalle/{idExcursion}")
    public String getExcursionDetail(@PathVariable int idExcursion, Model model) {
        Excursion excursion = excursionDao.findById(idExcursion);
        model.addAttribute("excursion", excursion);
        return excursion != null ? "detalleExcursion" : "redirect:/excursion/";
    }

    @GetMapping("/cancelar/{idExcursion}")
    public String cancelExcursion(@PathVariable int idExcursion, RedirectAttributes ratt) {
        Excursion excursion = excursionDao.findById(idExcursion);
        if (excursion != null) {
            excursion.setEstado("CANCELADO");
            excursionDao.updateOne(excursion);
            ratt.addFlashAttribute("mensaje", "Excursión cancelada correctamente.");
        } else {
            ratt.addFlashAttribute("mensaje", "Excursión no encontrada.");
        }
        return "redirect:/excursion/";
    }

    @GetMapping("/destacados")
    public String getDestacadosExcursions(Model model) {
        model.addAttribute("excursiones", excursionDao.findByDestacados());
        return "home";
    }

    @GetMapping("/terminados")
    public String getTerminadosExcursions(Model model) {
        model.addAttribute("excursiones", excursionDao.findByCancelados());
        return "home";
    }

    @GetMapping("/alta")
    public String showCreateForm(Model model) {
        model.addAttribute("excursion", new Excursion());
        return "formAltaExcursion";
    }

    @PostMapping("/alta")
    public String createExcursion(Excursion excursion, RedirectAttributes ratt) {
        excursionDao.insertOne(excursion);
        ratt.addFlashAttribute("mensaje", "Excursión creada exitosamente.");
        return "redirect:/excursion/";
    }

    @GetMapping("/modificar/{idExcursion}")
    public String showUpdateForm(@PathVariable int idExcursion, Model model) {
        model.addAttribute("excursion", excursionDao.findById(idExcursion));
        return "formModificarExcursion";
    }

    @PostMapping("/modificar/{idExcursion}")
    public String updateExcursion(@PathVariable int idExcursion, Excursion excursion, RedirectAttributes ratt) {
        excursion.setIdExcursion(idExcursion);
        excursionDao.updateOne(excursion);
        ratt.addFlashAttribute("mensaje", "Excursión modificada correctamente.");
        return "redirect:/excursion/";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    
}


