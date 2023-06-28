package net.guides.springboot2.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.demo.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

}
