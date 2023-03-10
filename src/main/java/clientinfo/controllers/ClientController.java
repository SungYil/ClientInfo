package ClientInfo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ClientController{
    @RequestMapping(value = "clientinfo", method = RequestMethod.GET)
    public String home(Model model){

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");

        System.out.println(req.getHeader("user-agent"));
        if (ip == null)
            ip = req.getRemoteAddr();

        model.addAttribute("clientIP", ip);
        return ""+ip;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String text(Model model){
        return "home domain";
    }

    @RequestMapping(value = "clientinfo/getheader")
    public String gethead(@RequestHeader Map<String, String> headers){
        
        for(Map.Entry<String, String> entry : headers.entrySet()){
            System.out.println("key : "+entry.getKey()+" , value : "+entry.getValue());
        }
        return "success";
    } 
}