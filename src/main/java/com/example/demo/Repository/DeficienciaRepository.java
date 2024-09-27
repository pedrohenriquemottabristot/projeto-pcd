package com.example.demo.Repository;

import com.example.demo.Model.Deficiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeficienciaRepository extends JpaRepository<Deficiencia, Long> {
    List<Deficiencia> findAllByAtivo(boolean ativo);
}

