package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarDao.CarDao;

import java.util.Optional;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String carsPage(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carDao.index(count.orElse(0)));
        return "/cars";
    }
}
