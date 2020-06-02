package shop.Ord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.Product.ProductService;
import shop.Sellers.SellersService;
import shop.Workshop.WorkshopService;

@Controller
public class OrdController {
    private OrdService ordService;
    private ProductService productService;
    private WorkshopService workshopService;
    private SellersService sellersService;

    @Autowired
    public OrdController(OrdService ordService, SellersService sellersService,
                         ProductService productService, WorkshopService workshopService){
        this.ordService = ordService;
        this.productService = productService;
        this.workshopService = workshopService;
        this.sellersService = sellersService;
    }

    @GetMapping("/order")
    public String showAll(Model model) {
        model.addAttribute("data", ordService.getAll());
        return "order";
    }

    @GetMapping("/order_add")
    public String add(Model model){
        model.addAttribute("order", new Ord());
        model.addAttribute("product", productService.getAll());
        model.addAttribute("workshop", workshopService.getAll());
        model.addAttribute("sellers", sellersService.getAll());
        return "order_add";
    }

    @PostMapping("/order")
    public String save(@ModelAttribute("order") Ord ord){
        ordService.save(ord);
        return "redirect:/order";
    }

    @GetMapping("/order_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("order", ordService.findById(id));
        model.addAttribute("product", productService.getAll());
        model.addAttribute("workshop", workshopService.getAll());
        model.addAttribute("sellers", sellersService.getAll());
        return "order_add";
    }

    @GetMapping("/order_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", ordService.delete(id));
        return "order";
    }
}
