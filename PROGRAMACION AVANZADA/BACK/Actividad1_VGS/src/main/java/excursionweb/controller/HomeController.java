package excursionweb.controller;

import excursionweb.modelo.dao.ExcursionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ExcursionDao excursionDao;

    @GetMapping("/")
    public String procHome(Model model) {
        model.addAttribute("excursiones", excursionDao.findAll());
        return "home";  
    }
}

