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
    boolean entero(String a){
    	int foo = Integer.parseInt(a);
    	if (foo.getClass().getName()=="java.lang.Integer")
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
