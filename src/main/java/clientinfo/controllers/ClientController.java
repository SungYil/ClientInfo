package ClientInfo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/clientinfo")
public class ClientController{
    
    @RequestMapping(value = "/getip", method = RequestMethod.GET)
    public String home(Model model){

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = req.getHeader("X-FORWARDED-FOR");

        System.out.println(req.getHeader("user-agent"));
        if (ip == null)
            ip = req.getRemoteAddr();

        model.addAttribute("clientIP", ip);
        return ""+ip;
    }
    //clever2-test.vsmart00.com/clientinfo -> virtualservice prefix: clientinfo
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String text(Model model){
        return "home domain";
    }

    @GetMapping("/redirect")
    public void redirect(HttpServletResponse response) throws IOException {
    	String redirect_uri="http://intro.clever2-test.vsmart00.com";
    	response.sendRedirect(redirect_uri);
    }

    @RequestMapping(value = "/getheader")
    public String gethead(@RequestHeader Map<String, String> headers){
        
        for(Map.Entry<String, String> entry : headers.entrySet()){
            System.out.println("key : "+entry.getKey()+" , value : "+entry.getValue());
        }
        return "success";
    } 
}