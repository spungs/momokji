package comj.esc.momokji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // test
    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/test1")
    public String test1() {
        return "commonTemplate/test1";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        return "commonTemplate/test2";
    }
}
