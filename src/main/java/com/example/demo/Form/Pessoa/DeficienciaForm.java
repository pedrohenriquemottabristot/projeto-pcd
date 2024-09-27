package com.example.demo.Form.Pessoa;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Enum.Sexo;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;

import com.example.demo.Repository.DeficienciaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class DeficienciaForm {
    @NotBlank(message = "Preencha o campo nome.")
    private String nome;

    @NotNull(message = "Preencha o campo categoria.")
    private Categoria categoria;

    private List<Categoria> listCategorias;

    public DeficienciaForm (Deficiencia deficiencia){
        this.nome = deficiencia.getNome();
        this.categoria = deficiencia.getCategoria();
    }   

   
}
