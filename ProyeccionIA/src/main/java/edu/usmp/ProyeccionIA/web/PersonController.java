package edu.usmp.ProyeccionIA.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.usmp.ProyeccionIA.model.Person;
import edu.usmp.ProyeccionIA.repository.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/person/new")
	public String initCreationForm(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}
	
	@PostMapping
	public String submitForm(@Valid Person person, BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "personForm";
		}
		 if(person.getIngresoDependiente()>0)
		 {person.setIngresoAnual(person.getIngresoDependiente() + person.getIngresoIndependiente());}
		
		 if (person.getIngresoAnual()<7*4050) {
             person.setRentaGravable(person.getIngresoAnual());}
             else {                 
            	 person.setRentaGravable(person.getIngresoAnual() - 7 * 4050);
             }
		
		 if(person.getRentaGravable()<=20250){
			 person.setImpuestoTotal(person.getRentaGravable()*0.08);
			 person.setIngresoTotal(person.getIngresoAnual()-person.getImpuestoTotal());
		 }
         
		 if(person.getRentaGravable()<=81000 && person.getRentaGravable()>20250){
			 person.setImpuestoTotal(20250*0.08+((person.getRentaGravable()-20250)*0.14));
			 person.setIngresoTotal(person.getIngresoAnual()-person.getImpuestoTotal());
		 }
		 
		 if(person.getRentaGravable()<=141750 && person.getRentaGravable()>81000){
			 person.setImpuestoTotal(20250*0.08 + 60750*0.14 + ((person.getRentaGravable()-81000)*0.17));
			 person.setIngresoTotal(person.getIngresoAnual()-person.getImpuestoTotal());
		 }
		 
		 if(person.getRentaGravable()<=182250 && person.getRentaGravable()>141750){
			 person.setImpuestoTotal(20250*0.08 + 60750*0.14 + 60750*0.17 + ((person.getRentaGravable()-141750)*0.2));
			 person.setIngresoTotal(person.getIngresoAnual()-person.getImpuestoTotal());
		 }
		 
		 if(person.getRentaGravable()>182250){
			 person.setImpuestoTotal( 20250*0.08 + 60750*0.14 + 60750*0.17 + 40500*0.2 + ((person.getRentaGravable()-182250)*0.3));
			 person.setIngresoTotal(person.getIngresoAnual()-person.getImpuestoTotal());
		 }
		 
		 		
		personRepository.save(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("/person/list")
	public String list(Map<String, Object> model) {
		List<Person> persons = personRepository.findAll();
		model.put("persons", persons);
		return "listPerson";
	}
	
	
	
}
