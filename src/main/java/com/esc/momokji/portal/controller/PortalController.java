package com.esc.momokji.portal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    @Value("${header.logo.message1}")
    String logoText;

    @GetMapping(value = { "/", "/main/main", "/main" })
    public String goMainPortal(Model model) throws Exception {
        model.addAttribute("logoText", logoText);

        return "portal/mainPortal";
    }
}
