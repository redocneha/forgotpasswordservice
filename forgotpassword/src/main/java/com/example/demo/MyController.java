package com.example.demo;



import java.util.HashMap;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/forgotpassword")
public class MyController {
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/uic")
	
	ResponseEntity<?> getValidation( @RequestBody Person p) {
		
		String p1=p.getEmail();
		ObjectNode jsonObject = mapper.createObjectNode();
		
		// don't forget to change return type to support this
		if(p1.equals("shaikneha823@gmail.com"))
		{
			
			jsonObject.put("status", "true");
			
		}
		else
			jsonObject.put("status", "false");
		return new ResponseEntity<>(jsonObject, HttpStatus.OK);
   
     
                   }
	@RequestMapping("/")
	public String demo()
	{
		return "hi";
	}
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/otp")
	ResponseEntity<?> validateOTP( @RequestBody Person p) {
		ObjectNode jsonObject = mapper.createObjectNode();
	if(p.getOtp().equals("1620"))
	{
		jsonObject.put("status", "true");
	}
	else
		jsonObject.put("status", "false");
	return new ResponseEntity<>(jsonObject, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/mts")
	ResponseEntity<?> methodToSet( @RequestBody Person p) {
	
	ObjectNode jsonObject = mapper.createObjectNode();
	String  c=p.getChoice();
	if(c.equals("2")) {
		jsonObject.put("otp", "1620");
		  return new ResponseEntity<>(jsonObject, HttpStatus.OK);
	}
	
   if(c.equals("3")) {
	  
	   jsonObject.put("question1", "who is ur fav hero");
	   jsonObject.put("question2", "who is ur inspiration");
	  
	   return new ResponseEntity<>(jsonObject, HttpStatus.OK);

    
	        
	}
   return new ResponseEntity<>(jsonObject, HttpStatus.OK);

	}
	
 
	private String sendOTP(String p ) {
		// TODO Auto-generated method stub
		
		return "hi";
		
	}
	private boolean sendEmail(String p) {
		// TODO Auto-generated method stub
		return false;
	}
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/sec")
	ResponseEntity<?> security( @RequestBody Person p) {
		
		System.out.println("hi");
			ObjectNode jsonObject = mapper.createObjectNode();
	    if(securityQuestionsCheck(p))
	    {
	    	
	    	  jsonObject.put("status", "true");
	    	  return new ResponseEntity<>(jsonObject, HttpStatus.OK);
	    }
		
		else
		{
			 jsonObject.put("status", "false");
		      
	    	  return new ResponseEntity<>(jsonObject, HttpStatus.OK);
		}
		}
		
	
	private boolean securityQuestionsCheck(Person p) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		HashMap<String,String>hm=new HashMap<String, String>(); 
		hm=(HashMap<String, String>) getSecurityQuestions(p.getEmail());
		System.out.println(hm.get("who is ur fav hero"));
	if(hm.get("who is ur fav hero").equals(p.getAns1())&&hm.get("who is ur inspiration").equals(p.getAns2()))
		
		return true;
	else
		return false;
	}
	private HashMap<String, String> getSecurityQuestions(String email) {
		// TODO Auto-generated method stub
		
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("who is ur fav hero","mahesh");
		hm.put("who is ur inspiration","abdulkalam");
		
		return hm;
	}
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/set")
	ResponseEntity<?> setPassword( @RequestBody Person p) {
		ObjectNode jsonObject = mapper.createObjectNode();
		String confpass=p.getConfpass();
		String pass=p.getPassword();
	      if(pass.equals(confpass))
	      {
	    	  jsonObject.put("status", "true");
	    	  return new ResponseEntity<>(jsonObject, HttpStatus.OK);
	      }
	      else {
	    	  jsonObject.put("status", "false");
	      
	    	  return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
	      }
	    }
}
