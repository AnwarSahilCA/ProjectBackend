package com.search.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.demo.Entity.User;
import com.search.demo.Repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Controller {
	@Autowired
	UserRepository urepo;
	String s="completed";
	

	//@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@GetMapping("/search")
	public List<User> search(@RequestParam("q") String searchTerm) {
        List<User> result=urepo.findBytitle(searchTerm);
        
        return result;
    }
	@PostMapping()
	@RequestMapping("/create")
	
	public ResponseEntity<User> addProduct(@RequestBody User product){
		return new ResponseEntity<User>(urepo.save(product),HttpStatus.ACCEPTED);
}
	@DeleteMapping()
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		urepo.deleteById(id);
		return "deleted";
	}
	@GetMapping()
	@RequestMapping("retrieve/all")
	public List<User> retrieveall(){
		List<User> l1=urepo.findAll();
		return l1;
	}
	@GetMapping()
	@RequestMapping("retrieve/completed")
	public List<User> retrievec(){
		List<User> l2=new ArrayList<User>();
		List<User> l1=urepo.findAll();
		for(User u:l1) {
			if(u.getStatus().equals(s)) 
				l2.add(u);
			
		}
		return l2;
	}
	@GetMapping()
	@RequestMapping("retrieve/pending")
	public List<User> retrievep(){
		List<User> l2=new ArrayList<User>();
		List<User> l1=urepo.findAll();
		for(User u:l1) {
			if(u.getStatus().equals("pending")) {
				l2.add(u);
			}
		}
		return l2;
	}
	@GetMapping()
	@RequestMapping("/retrieve/{eventId}")
	public User retrieve(@PathVariable long eventId) {
		Optional<User> opt= urepo.findById(eventId);
		return opt.get();
		
	}
	@PutMapping()
	@RequestMapping("/update")
	public User create(@RequestBody User user) {
		Optional<User> opt=urepo.findById(user.getEventId());
		if(opt.isPresent()) {
			User u=opt.get();
			u.setStatus(user.getStatus());
			return urepo.save(u);
		}
		return user;
	
	}
	@GetMapping()
	@RequestMapping("/totaltask")
	public int total() {
		List<User>l1=urepo.findAll();
		return l1.size();
	}
	

}
