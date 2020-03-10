package com.webapp.Controller;


import com.webapp.entity.User;
import com.webapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController
{
    @Autowired
    UserRepo userRepo;

    @GetMapping("/registration")
    public String getRegistrationPage()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String getRegistrationPage(@RequestParam User user , Model model)
    {
        User user1 = userRepo.findUserByUsername(user.getUsername());


        if (user1 != null)
        {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(1);

            model.addAttribute("error", "This user has already been created");
            return "redirect:/registration";
        }

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
        {

            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(2);

            model.addAttribute("error", "Username or password is empty!");
            return "redirect:/registration";
        }




        return "redirect:/registration";
    }

}
