package com.example.cadastrolivros.controller;
import com.example.cadastrolivros.model.Livro;
import com.example.cadastrolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarVeiculos() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @DeleteMapping("/{titulo}")
    public ResponseEntity<String> deletarLivro(@PathVariable String placa) {
        try {
            livroRepository.deleteById(placa);
            return ResponseEntity.ok("livro deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{titulo}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String placa, @RequestBody Livro livroAtualizado) {
        if (livroRepository.existsById(placa)) {
            Livro livro = livroRepository.findById(placa).get();
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setAno(livroAtualizado.getAno());
            Livro livroAtualizadoBD = livroRepository.save(livro);
            return ResponseEntity.ok(livroAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
