package com.webapp.Controller;


import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{

    @GetMapping("/")
    public String homePage()
    {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage()
    {
        return "home";
    }

    @GetMapping("/hello")
    public String getHelloPage()
    {
        return "hello";
    }


}
