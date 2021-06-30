package com.example.mongodbdemo.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mongodbdemo.model.Information;
import com.example.mongodbdemo.repository.InformationRepository;

@Service
public class InformationService {
	
	private final InformationRepository informationRepository;
	
	public InformationService(InformationRepository informationRepository)
	{
		this.informationRepository=informationRepository;
	}
	
	public void addInformation(Information information)
	{
		informationRepository.insert(information);
	}
	public void updateInformation(Information information)
	{
		Information savedInfo=informationRepository.findById(information.getId())
				.orElseThrow(()-> new RuntimeException(
						String.format("Cannot find Information by ID %s", information.getId())));
		savedInfo.setName(information.getName());
		savedInfo.setMobile(information.getMobile());
		savedInfo.setEmail(information.getEmail());
		
		informationRepository.save(information);
	}
	public List<Information> getAllInformation()
	{
		return informationRepository.findAll();
	}
	public Information getInformationByName(String name)
	{
		return informationRepository.findByName(name).orElseThrow(()-> new RuntimeException(
				String.format("Cannot find information by name %s", name)));
	}
	public void deleteInformation(String id)
	{
		informationRepository.deleteById(id);
	}

}
