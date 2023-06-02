package com.lab.lab1.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    RegistrationHandler registrationHandler;

    public RegistrationController(RegistrationHandler registrationHandler){
        this.registrationHandler = registrationHandler;
    }

    @PostMapping("/post")
    public RegistrationResponseModel create(@RequestBody() RegistrationRequestModel body){
        boolean response = registrationHandler.create(body);

        if(response){
            System.out.println("Registration successful");
            return new RegistrationResponseModel(
              "Registration successful",
              true, 200, body
            );
        }
        else{
            return new RegistrationResponseModel(
                    "Registration not successful",
                    false, 500, null
            );
        }
    }

    @PutMapping("/put")
    public String update(){
        return "";
    }

    @GetMapping("/get")
    public RegistrationResponseModel findAll(){
        return new RegistrationResponseModel(
                "Registration successful",
                true, 200, registrationHandler.fetch()
        );
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "";
    }
}
