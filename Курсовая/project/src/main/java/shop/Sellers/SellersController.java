package shop.Sellers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.Contacts.ContactsService;
import shop.Post.PostService;

@Controller
public class SellersController {
    private SellersService sellersService;
    private PostService postService;
    private ContactsService contactsService;

    @Autowired
    public SellersController(SellersService sellersService,
                             PostService postService, ContactsService contactsService){
        this.sellersService = sellersService;
        this.postService = postService;
        this.contactsService = contactsService;
    }

    @GetMapping("/sellers")
    public String showAll(Model model) {
        model.addAttribute("data", sellersService.getAll());
        return "sellers";
    }

    @GetMapping("/sellers_add")
    public String add(Model model){
        model.addAttribute("sellers", new Sellers());
        model.addAttribute("post", postService.getAll());
        model.addAttribute("contacts", contactsService.getAll());
        return "sellers_add";
    }

    @PostMapping("/sellers")
    public String save(@ModelAttribute("sellers") Sellers sellers){
        sellersService.save(sellers);
        return "redirect:/sellers";
    }

    @GetMapping("/sellers_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("sellers", sellersService.findById(id));
        model.addAttribute("post", postService.getAll());
        model.addAttribute("contacts", contactsService.getAll());
        return "sellers_add";
    }

    @GetMapping("/sellers_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", sellersService.delete(id));
        return "sellers";
    }
}
