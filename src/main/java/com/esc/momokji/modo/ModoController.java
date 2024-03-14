package com.esc.momokji.modo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModoController {
    @GetMapping(value = "/modo/main")
    public String modoMain() throws Exception {
        return "moDo/modoMain";
    }
}
