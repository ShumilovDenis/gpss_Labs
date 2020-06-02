package shop.Contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactsController {
    private final ContactsService service;

    @Autowired
    public ContactsController(ContactsService service){
        this.service = service;
    }

    @GetMapping("/contacts")
    public String showAll(Model model) {
        model.addAttribute("data", service.getAll());
        return "contacts";
    }

    @GetMapping("/contacts_add")
    public String add(Model model){
        model.addAttribute("contacts", new Contacts());
        return "contacts_add";
    }

    @PostMapping("/contacts")
    public String save(@ModelAttribute("contacts") Contacts contacts){
        service.save(contacts);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("contacts", service.findById(id));
        return "contacts_add";
    }

    @GetMapping("/contacts_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "contacts";
    }
}
