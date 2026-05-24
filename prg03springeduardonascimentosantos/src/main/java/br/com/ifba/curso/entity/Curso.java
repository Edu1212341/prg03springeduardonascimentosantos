/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

/**
 *
 * @author eduardo
 */


// izem ao Hibernate como criar a tabela
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author eduardo
 */
/*5 lines*/
@Entity //  vai virar uma tabela 
@Table (name = "cursos")
@Getter // Gera apenas os getters
@Setter // Gera apenas os setters
@NoArgsConstructor//construtor sem nada
@AllArgsConstructor//construtor com tudo

public class Curso extends PersistenceEntity implements Serializable{
        
    @Column (name = "nome", nullable = false)
    private String nome;
    
    @Column (name = "descricao_curso", nullable = false)
    private String descricao;
    
    @Column (name = "carga_horaria", nullable = false)
    private int cargaHoraria;
    
    @Column (name = "ativo", nullable = false)
    private boolean ativo;
}