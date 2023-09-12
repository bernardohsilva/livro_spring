package com.example.cadastrolivros.repository;
import com.example.cadastrolivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
