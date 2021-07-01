package univ.ensam.iagi.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import univ.ensam.iagi.entities.*;
import univ.ensam.iagi.services.*;

@RestController
public class ArbitreControleur {

	@Autowired
	ArbitreService arbitreservice;
	
	@GetMapping("/arbitres")
	public Collection<Arbitre> getAllArbitres(){
		return arbitreservice.getAllArbitres();
	}
	
	@PostMapping("/arbitres")
	public void addArbitre(@RequestBody Arbitre a) {
		arbitreservice.addArbitre(a);
	}
	
	@GetMapping("/arbitres/{idArbitre}")
	public Arbitre getArbitre(@PathVariable(value="idArbitre") Long id) {
		return arbitreservice.getArbitreById(id);
	}
	
	@PutMapping("/arbitres/{idArbitre}")
	public Arbitre updateArbitre(@PathVariable(value="idArbitre") Long id,@RequestBody Arbitre a) {
		return arbitreservice.updateArbitre(id, a);
	}
	
	@DeleteMapping("/arbitres/{idArbitre}")
	public Arbitre deleteArbitre(@PathVariable(value="idArbitre") Long id) {
		return arbitreservice.deleteArbitre(id);
	}
}
