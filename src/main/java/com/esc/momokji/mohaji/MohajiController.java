package com.esc.momokji.mohajii;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MohajiController {
    @Value("${header.logo.message2}")
    String logoText;

    @GetMapping(value = "/mohaji/main")
    public String mohajiMain(Model model) throws Exception {
        model.addAttribute("logoText", logoText);

        return "mohaji/mohajiMain";
    }
}
