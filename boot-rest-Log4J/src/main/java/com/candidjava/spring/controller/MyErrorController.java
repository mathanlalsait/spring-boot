package com.candidjava.spring.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.candidjava.spring.config.ErrorConfig;
@Controller
public class MyErrorController implements ErrorController {
	public MyErrorController() {}
	
	// inject via application.properties
		//@Value("${error.message}")
		//private String error_message = "Not Found";

	@Autowired
	public ErrorConfig errorconfig;

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request,Map<String, Object> model) {
    	
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
        
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	model.put("error_message", errorconfig._404);
                return "error";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            	model.put("error_message", errorconfig._500);
                return "error";
            }
        }
        
        model.put("error_message", errorconfig.DEFAULT_ERROR);
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}



