package springapplication.springapplication.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springapplication.springapplication.Model.UserModel;
import springapplication.springapplication.Repositiory.UserResponse;

//import jakarta.annotation.PostConstruct;

@Controller
public class UserController {
    
    @Autowired
    private UserResponse userResponse_obj;

    @GetMapping
    public String index()
    {
        return "index";
    }
    @PostMapping("/createuser")
    public String saveUser(UserModel usernew){
        
        System.out.println("************************");
        System.out.println("Inside Create");
        System.out.println("************************");
         userResponse_obj.save(usernew);
         return "WELCOME";

    }

}