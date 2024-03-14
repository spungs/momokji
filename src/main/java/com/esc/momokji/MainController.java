package com.esc.momokji;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class MainController {
    @Value("appkey")
    private String appkey;

//    @GetMapping("/")
//    public String main() {
//        return "main";
//    }

    @GetMapping("chooseMenu")
    public String chooseMenu() {
        return "chooseMenu";
    }

    @GetMapping("kakaoMap")
    public String naverMap(Model model) {
        model.addAttribute("appkey", appkey);
        return "map/kakaoMap";
    }
}