package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/create")
    public String create(@ModelAttribute Product prod){
        productService.create(prod);
        return "redirect:/";
    }

    //På update siden skal vises navn, pris og beskrivelse for et specifikt produktid (gøres med @PathVariable)
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        //Tilføj Product med id til model view
        model.addAttribute("prod", productService.read(id));
        return "update";
    }

    //Post-metode, som opdaterer det specifikke produkt ved hjælp af id
    @PostMapping("/update")
    public String update(@ModelAttribute Product prod){
        productService.update(prod);
        return "redirect:/";
    }

    //Delete metode, som sletter et specifik id
}
