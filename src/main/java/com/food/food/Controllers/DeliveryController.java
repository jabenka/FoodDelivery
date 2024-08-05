package com.food.food.Controllers;

import com.food.food.Models.DeliveryForm;
import com.food.food.Services.DeliveryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService DeliveryService;
    @GetMapping("/DeliveryForm")
    public String DeliveryForm(@ModelAttribute("form") DeliveryForm form){

        return "DeliveryForm";
    }
    @PostMapping("/DeliveryFormSubmit")
    @Transactional
    public String DeliveryFormSubmit(@ModelAttribute("form") DeliveryForm form,Model page){
        DeliveryService.addOrder(form);
        float price=0;
        String name=form.getName();
        switch (name){
            case "пицца":
                price=29.99f;
                break;
            case "суши":
                price=19.99f;
                break;
            default:
                price=35.99f;
        }
        page.addAttribute("success","Заказ успешно принят");
        page.addAttribute("id",form.getId());
        page.addAttribute("price",price);
        return "DeliveryForm";
    }

}
