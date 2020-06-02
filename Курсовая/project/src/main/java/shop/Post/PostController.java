package shop.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private PostService service;

    @Autowired
    public PostController(PostService service){
        this.service = service;
    }

    @GetMapping("/post")
    public String showAll(Model model) {
        model.addAttribute("data", service.getAll());
        return "post";
    }

    @GetMapping("/post_add")
    public String add(Model model){
        model.addAttribute("post", new Post());
        return "post_add";
    }

    @PostMapping("/post")
    public String save(@ModelAttribute("post") Post post){
        service.save(post);
        return "redirect:/post";
    }

    @GetMapping("/post_edit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("post", service.findById(id));
        return "post_add";
    }

    @GetMapping("/post_delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "post";
    }
}
