package com.esc.momokji.portal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    @GetMapping(value = { "/", "/main/main", "/main" })
    public String goMainPortal(Model model) throws Exception {
        return "portal/mainPortal";
    }
}
