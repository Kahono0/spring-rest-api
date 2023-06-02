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
    public RegistrationResponseModel update(@RequestBody RegistrationRequestModel body, @RequestParam(name="id") String id) {
        boolean response = registrationHandler.update(body, id);

        if(response){
            return new RegistrationResponseModel(
                    "Update successful",
                    true, 200, null
            );
        }
        else{
            return new RegistrationResponseModel(
                    "Update not successful",
                    false, 500, null
            );
        }

    }

    @GetMapping("/get")
    public RegistrationResponseModel findAll(){
        return new RegistrationResponseModel(
                "Registration successful",
                true, 200, registrationHandler.fetch()
        );
    }

    @GetMapping("/get/{id}")
    public RegistrationResponseModel findOne(@PathVariable String id){
        return new RegistrationResponseModel(
                "Registration successful",
                true, 200, registrationHandler.fetchOne(id)
        );
    }

    @DeleteMapping("/delete")
    public RegistrationResponseModel delete(@RequestParam(name="id") String id){
        boolean response = registrationHandler.delete(id);

        if(response){
            return new RegistrationResponseModel(
                    "Delete successful",
                    true, 200, null
            );
        }
        else{
            return new RegistrationResponseModel(
                    "Delete not successful",
                    false, 500, null
            );
        }
    }
}
