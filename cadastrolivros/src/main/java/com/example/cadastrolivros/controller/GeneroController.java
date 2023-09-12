package com.example.cadastroLivros.controller;
import com.example.cadastrolivros.model.Genero;
import com.example.cadastrolivros.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/genero")
public class GeneroController {
 @Autowired
    private GeneroRepository generoRepository;
 @GetMapping
    public List<Genero> listarGenero() {
        return generoRepository.findAll();
    }
   @PostMapping
    public Genero criarGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

}
