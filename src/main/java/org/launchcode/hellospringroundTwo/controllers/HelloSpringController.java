package org.launchcode.hellospringroundTwo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //metadata: tells compiler that this is a controller and will do special shit.
//@ResponseBody //will be obsolete later in the class when we're using templates
//@RequestMapping("hello")
public class HelloSpringController {


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
     public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";                              //references template hello.html
    }

    //handles requests that look like: /hello/hello/parameter, where "parameter" will be the name to greet.
    @GetMapping ("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){ //variable MUST MATCH the variable in the GetMapping  path EXACTLY
        String theGreeting = "Hello, " + name + "!!!!!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "form")
    public String helloForm() {
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "helloPostResponse")
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language, Model model){ //name and language refer to the variables given by helloForm HTML setup, they MUST BE EXACT MATCHES
        if (name == null || name == ""){
            name = "World";
        }

        String theGreeting = "";
        model.addAttribute("greeting", theGreeting);
        if (language.equals("english")){
            theGreeting =  "Hello, ";
        }else if (language.equals("french")) {
            theGreeting =  "Bonjour, ";
        }else if (language.equals("spanish")) {
            theGreeting = "Hola, ";
        }else if (language.equals("german")) {
            theGreeting =  "Hallo, " ;
        }else if (language.equals("portuguese")) {
            theGreeting = "Olá, " ;
        }
        return theGreeting + name + "!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "hello-names")
    public String helloNames(Model model){

        List<String> names = new ArrayList<>();
        names.add("jimmy fred");
        names.add("billy joe");
        names.add("sammy gene");

        model.addAttribute("nameReference", names);
        return "hello-list";
    }
}
