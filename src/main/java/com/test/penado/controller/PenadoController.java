package com.test.penado.controller;




//@RequestMapping(value = "/penado")
//@CrossOrigin("*")
//public class PenadoController {
	//@Autowired
	//private PenadoService penadoService;
	
	//@GetMapping(value = "/test")
	//public ResponseEntity<String> test() {
	//	return new ResponseEntity<String>("id", HttpStatus.OK);
	//}
//}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.penado.dto.PenadoDTO;
import com.test.penado.service.PenadoService;

@RestController
@RequestMapping(value = "/penado")
@CrossOrigin("*")
public class PenadoController {
	@Autowired
	private PenadoService penadoService;

	@PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoDTO> create(@RequestBody PenadoDTO body) {
		PenadoDTO response = this.penadoService.create(body);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/buscar",produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<PenadoDTO> read(@RequestParam Integer id) {
		PenadoDTO response = this.penadoService.read(id); 
		return new ResponseEntity<>(response, HttpStatus.OK); 
		} 
	
	@PutMapping(value = "/actualizar",produces = MediaType.APPLICATION_JSON_VALUE) 
	public Boolean update(@RequestBody PenadoDTO body) { 
		Boolean response = this.penadoService.update(body); 
		return response;
	} 
		
	@DeleteMapping(value = "/eliminar",produces = MediaType.APPLICATION_JSON_VALUE) 
	public Boolean delete(@RequestParam Integer id) {
		Boolean response = this.penadoService.delete(id);
		return response;
		}
	
		
}

