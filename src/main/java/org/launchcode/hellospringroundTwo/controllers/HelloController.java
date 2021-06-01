package org.launchcode.hellospringroundTwo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //metadata: tells compiler that this is a controller and will do special shit.
@ResponseBody //will be obsolete later in the class when we're using templates

public class HelloController {

//  @GetMapping //will only take GET requests. handled at localhost:8080 with no ext
    @GetMapping("hello") //only GET reqs, handled at the extension /hello
    public String hello() {
        return ("Hello, spring");
    }

    @GetMapping("goodbye") //only GET reqs, will live at the extension /bye
    public String goodbye() {
        return ("Goodbyeeeee, spring");
    }

    /*    Create handler that handles request with extensions using...
    -query parameters- ?variable=value-- in this case: localhost:8080/hello?name=Jimmy
commented out lines 13-17, would have failed due to mult handlers
at the same extension
    */
    //@GetMapping ("helloQueryParam")//only GET reqs sent to ext/helloQueryParam
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloQueryParam")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests that look like: /hello/parameter, where "parameter" will be the name to greet.
    @GetMapping ("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){ //variable MUST MATCH the variable in the GetMapping  path EXACTLY
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return
                "<html>" +
                    "<body>" +
                    "   <form action = 'helloQueryParam' method = 'POST'>" +  //action attribute tells handler to submit the request to /hello
                    "       <input type = 'text' name = 'name'>" + //name is the parameter input the form will use to spawn the pathParam
                    "       <input type = 'submit' value = 'Greet me!'>" + //value says what to output on the button if you want something other than 'submit'
                    "   </form>" +
                    "</body>" +
                "</html>";
    }

}
