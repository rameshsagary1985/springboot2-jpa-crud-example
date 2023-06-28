package net.guides.springboot2.demo.model.dvdrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.demo.exception.ResourceNotFoundException;

import net.guides.springboot2.demo.model.Film;



@Service
public class FilmService {
	
	
	@Autowired
    private net.guides.springboot2.demo.repository.FilmRepository FilmRepository;
  // return ResponseEntity.ok().body(employee);

	
	
	public Film FetchFilm(Long filmid) throws ResourceNotFoundException {
		return FilmRepository.findById(filmid)
		 .orElseThrow(() -> new ResourceNotFoundException("Film not found for this id :: " + filmid));
	}
	
	

}
