package org.launchcode.hellospringroundTwo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //metadata: tells compiler that this is a controller and will do special shit.
@ResponseBody //will be obsolete later in the class when we're using templates
@RequestMapping("hello")
public class HelloSpringController {

//  @GetMapping //will only take GET requests. handled at localhost:8080 with no ext

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String hello() {
//        return ("Hello, spring");
//    }

//    @GetMapping("goodbye") //only GET reqs, will live at the extension /hello/goodbye
//    public String goodbye() {
//        return ("Goodbyeeeee, spring");
//    }  make a new controller for goodbye, add other languages, too.

    /*    Create handler that handles request with extensions using...
    -query parameters- ?variable=value-- in this case: localhost:8080/hello?name=Jimmy
commented out lines 13-17, would have failed due to mult handlers
at the same extension
    */
    //@GetMapping ("helloQueryParam")//only GET reqs sent to ext /hello/helloQueryParam

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloQueryParam")
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }
//
//    //handles requests that look like: /hello/hello/parameter, where "parameter" will be the name to greet.
//    @GetMapping ("hello/{name}")
//    public String helloWithPathParam(@PathVariable String name){ //variable MUST MATCH the variable in the GetMapping  path EXACTLY
//        return "Hello, " + name + "!";
//    }

    @RequestMapping(method = {RequestMethod.GET} )
    public String helloForm(){
        return
                "   <form  method = 'POST'>" +  //action attribute tells handler to submit the request to /hello
                "       <input type = 'text' name = 'name'>" + //name is the parameter input the form will use to spawn the pathParam
                "       <select name='language'>" +
                    "   <option value = 'english'> English </option>" +
                    "   <option value = 'spanish'> Español </option>" +
                    "   <option value = 'french'> Français </option>" +
                    "   <option value = 'german'> Deutsch </option>" +
                    "   <option value = 'portuguese'> Portugues </option>" +
                    "   </select>" +
                    "   <input type = 'submit' value = 'Greet me!'>" + //value says what to output on the button if you want something other than 'submit'
                "   </form>" ;

    }

    @RequestMapping(method = RequestMethod.POST)
    public String createMessage(@RequestParam String name, @RequestParam String language){ //name and language refer to the variables given by helloForm HTML setup, they MUST BE EXACT MATCHES
        if (name == null || name == ""){
            name = "World";
        }
        String greeting = "";
        if (language.equals("english")){
            greeting =  "Hello, ";
        }else if (language.equals("french")) {
            greeting =  "Bonjour, ";
        }else if (language.equals("spanish")) {
            greeting = "Hola, ";
        }else if (language.equals("german")) {
            greeting =  "Hallo, " ;
        }else if (language.equals("portuguese")) {
            greeting = "Olá, " ;
        }
        return greeting + name + "!";
    }
}
