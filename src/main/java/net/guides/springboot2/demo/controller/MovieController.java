package net.guides.springboot2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.demo.exception.ResourceNotFoundException;

import net.guides.springboot2.demo.model.Employee;
import net.guides.springboot2.demo.model.Film;
import net.guides.springboot2.demo.model.dvdrental.service.FilmService;
import net.guides.springboot2.demo.repository.FilmRepository;



@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MovieController {
	
	

	@Autowired private FilmRepository filmRepository;
	
	
	@Autowired
    private FilmService filmService;

    @GetMapping("/films/{id}")
    public Film getAllFilms(@PathVariable(value = "id") Long filmId) throws ResourceNotFoundException {
        return filmService.FetchFilm(filmId);
    }

    
    @GetMapping("/films")
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    
    
    @PostMapping("/films")
    public Film createFilm(@RequestBody Film film) {
    	System.out.println("film="+film);
        return filmRepository.save(film);
    }
}
