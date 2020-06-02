package shop.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/product")
    public String showAll(Model model) {
        model.addAttribute("data", service.getAll());
        return "product";
    }

    @GetMapping("/product_add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "product_add";
    }

    @PostMapping("/product")
    public String save(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("product", service.findById(id));
        return "product_add";
    }

    @GetMapping("/product_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "product";
    }
}
