package com.food.food.Controllers;

import com.food.food.Models.CheckForm;
import com.food.food.Models.DeliveryForm;
import com.food.food.Services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class CheckController {
    private final DeliveryService DeliveryService;
    public CheckController(DeliveryService DeliveryService) {
        this.DeliveryService = DeliveryService;
    }
    @GetMapping("/CheckForm")
    public String checkForm(@ModelAttribute("form") CheckForm form) {
        return "CheckForm";
    }
    @PostMapping("/CheckFormSubmit")
    public String checkFormSubmit(@ModelAttribute("form") CheckForm form, Model page) {
        Long id=Long.parseLong(form.getStatus());
        String res="Не найдено";
        DeliveryForm Form=DeliveryService.getOrder(id);
        if(Form!=null){
            res="В процессе приготовления";
        }
        page.addAttribute("result", res);
        return "CheckForm";
    }

}
