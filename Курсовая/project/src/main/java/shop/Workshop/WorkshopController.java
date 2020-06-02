package shop.Workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkshopController {
    private WorkshopService service;

    @Autowired
    public WorkshopController(WorkshopService service){
        this.service = service;
    }

    @GetMapping("/workshop")
    public String showAllBlank(Model model) {
        model.addAttribute("data", service.getAll());
        return "workshop";
    }

    @GetMapping("/workshop_add")
    public String addBlank(Model model){
        model.addAttribute("workshop", new Workshop());
        return "workshop_add";
    }

    @PostMapping("/workshop")
    public String save(@ModelAttribute("workshop") Workshop workshop){
        service.save(workshop);
        return "redirect:/workshop";
    }

    @GetMapping("/workshop_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("workshop", service.findById(id));
        return "workshop_add";
    }

    @GetMapping("/workshop_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "workshop";
    }
}
