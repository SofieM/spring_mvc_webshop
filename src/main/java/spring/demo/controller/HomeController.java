package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.demo.model.Product;
import spring.demo.service.ProductService;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        //Tilføjer alle produkter til view model fra ProductService
        model.addAttribute("prod", productService.listAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(){

        return "create";
    }

    //På update siden skal vises navn, pris og beskrivelse for at specifikt produktid
    @GetMapping("/update{ID}")
    public String update(){

        return "update";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product prod){
        productService.create(prod);
        return "redirect:/";
    }
}
