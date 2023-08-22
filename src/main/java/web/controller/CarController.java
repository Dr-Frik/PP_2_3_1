package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarServices.CarService;
import web.models.Car;

import java.util.List;


@Controller
public class CarController {


    private final CarService carService;

    @Autowired
    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public String getCar(@RequestParam(value = "num") int carCount, Model model) {

        model.addAttribute("cars", carService.getCars(carCount));

        return "/car";
    }
}
