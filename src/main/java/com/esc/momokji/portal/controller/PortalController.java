package com.esc.momokji.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    @GetMapping(value = { "/", "/main/main", "/main" })
    public String goMainPortal() throws Exception {
        return "portal/mainPortal";
    }
}
