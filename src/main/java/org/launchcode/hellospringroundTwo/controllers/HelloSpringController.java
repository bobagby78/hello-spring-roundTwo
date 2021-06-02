package org.launchcode.hellospringroundTwo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //metadata: tells compiler that this is a controller and will do special shit.
@RequestMapping("hello")
public class HelloSpringController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name) {
        return "Hello, " + name;
    }

    //handles requests that look like: /hello/hello/parameter, where "parameter" will be the name to greet.
    @GetMapping ("{name}")
    public String helloWithPathParam(@PathVariable String name){ //variable MUST MATCH the variable in the GetMapping  path EXACTLY
        return "Hello, " + name + "!";
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "form" )
    public String helloForm(){
        return "form";

    }

}
