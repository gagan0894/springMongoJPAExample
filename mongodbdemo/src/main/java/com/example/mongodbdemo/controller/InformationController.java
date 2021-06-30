package com.example.mongodbdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbdemo.model.Information;
import com.example.mongodbdemo.service.InformationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/information")
public class InformationController {
	
	private final InformationService informationService;
	
	public InformationController(InformationService informationService)
	{
		this.informationService=informationService;
	}
	@PostMapping
	public ResponseEntity addInformation(@RequestBody Information information)
	{
		informationService.addInformation(information);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping
	public ResponseEntity updateInformation(@RequestBody Information information)
	{
		informationService.updateInformation(information);
		return ResponseEntity.ok().build();
	}
	@GetMapping
	public ResponseEntity getAllInformation()
	{
		return ResponseEntity.ok(informationService.getAllInformation());
	}
	@GetMapping("/{name}")
	@ApiOperation(value="Find information by name",
	notes="Provide a name to lookup into mongo db to find information about that person",
	response=ResponseEntity.class)
	public ResponseEntity getInformationByName(@ApiParam(value="name for the person whose information is needed",required=true)
			@PathVariable String name)
	{
		return ResponseEntity.ok(informationService.getInformationByName(name));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteInformation(@PathVariable String id)
	{
		informationService.deleteInformation(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
