package com.example;

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
    String operacion(@RequestParam String a,String b, String operacion) {
    	if(entero(a)&&entero(b)){
    		int aa = Integer.parseInt(a);
    		int bb = Integer.parseInt(b);
	    	switch(operacion){
	    	case "suma":
	    		return ""+suma(aa,bb);
	    	case "resta":
	    		return ""+resta(aa,bb);
	    	case "multiplicacion":
	    		return ""+multiplicacion(aa,bb);
	    	case "division":
	    		return ""+division(aa,bb);	
	    	}
			return "operacion no contemplada " ;
	    }
    	else
    		return "a y b deben ser enteros" ;	
    }
    boolean entero(String a){
    	try {
    		Float.parseFloat(a);}
    		catch(NumberFormatException ex)
    		{
    		return false;	
    		}
    	return true;
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
