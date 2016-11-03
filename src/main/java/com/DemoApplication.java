package com.example;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DemoApplication {
    
    @RequestMapping("/calculadora")
    @ResponseBody
    String operacion(@RequestParam Integer a,Integer b, String operacion) {
    	if(a.getClass().getName()=="java.lang.Integer" && b.getClass().getName()=="java.lang.Integer"){
	    	switch(operacion){//Single responsability
	    	case "suma":
	    		return ""+suma(a,b);
	    	case "resta":
	    		return ""+resta(a,b);
	    	case "multiplicacion":
	    		return ""+multiplicacion(a,b);
	    	case "division":
	    		return ""+division(a,b);	
	    	}
			return "operacion no completada " ;
	    }
    	else
    		return "a y b deben ser enteros" ;	
    }

    Integer suma(Integer a,Integer b){
    	return a+b;
    }
    Integer resta(Integer a,Integer b){
    	return a-b;
    }
    Integer multiplicacion(Integer a,Integer b){
    	return a*b;
    }
    Integer division(Integer a,Integer b){
    	return a/b;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}
