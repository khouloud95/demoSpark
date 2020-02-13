package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;
@CrossOrigin("*")

@RestController
public class ContactRestService {
	@Autowired
     private ContactRepository contactRepository;
    
	@GetMapping(value="/contacts")
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}
	@GetMapping(value="/contacts/{id}")
	public Optional<Contact> getContact(@PathVariable Long id ) {
		return contactRepository.findById(id);
	}
	@GetMapping(value="/chercherContacts")
	public Page<Contact> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size
			) { return contactRepository.chercher("%"+mc+"%", PageRequest.of(page,size));
		
	}
	@PostMapping(value="/contacts")
	public Contact saveContact(@RequestBody Contact c) {
		return contactRepository.save(c);
	}
	@DeleteMapping(value="/contacts/{id}")
	public boolean supprimer(@PathVariable Long id)
	{
		contactRepository.deleteById(id);
		return true ;
	}
	@PutMapping(value="/contacts/{id}")
	public Contact save(@RequestBody Contact c,@PathVariable Long id)
	{ c.setId(id);
		return contactRepository.save(c);
		
	}
	//hello
	
	
	
	
	
	
}
