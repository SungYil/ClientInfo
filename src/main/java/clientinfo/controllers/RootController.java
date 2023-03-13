package ClientInfo.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String text(){
        return "home domain";
    }

    @RequestMapping(value = "/getheader")
    public String gethead(@RequestHeader Map<String, String> headers){
        
        for(Map.Entry<String, String> entry : headers.entrySet()){
            System.out.println("key : "+entry.getKey()+" , value : "+entry.getValue());
        }
        return "success";
    } 
}
