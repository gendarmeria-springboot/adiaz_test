package com.test.region.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.regiones.service.RegionesService;





@RestController
@RequestMapping(value = "/regiones")
@CrossOrigin("*")
public class RegionesController {
	@Autowired
	private RegionesService regionService;

	
	//@GetMapping(value = "/busca/{id}",produces = MediaType.APPLICATION_JSON_VALUE) 
	//public ResponseEntity<RegionesDTO> read(@PathVariable(required = false) int id) {
	//	RegionesDTO response = this.regionesService.read(id); 
	//	return new ResponseEntity<RegionesDTO>(response, HttpStatus.OK); 
	//	} 
			
	@GetMapping(value = "/listaregiones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegionesDTO>> read() {
        List<RegionesDTO> RegionesDTO = this.regionesService.read();
        return new ResponseEntity<List<RegionesDTO>>(response, HttpStatus.OK);
    }
   
 
}

