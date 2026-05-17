/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author eduardo
 */
@Controller
public class CursoController {
    // O Controller só conhece o Service
    @Autowired
    private CursoIService cursoService;

    public Curso save(Curso curso) {
        return cursoService.save(curso);
    }

    public Curso update(Curso curso) {
        return cursoService.update(curso);
    }

    public void delete(Curso curso) {
        cursoService.delete(curso);
    }

    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    public Curso findById(Long id) {
        return cursoService.findById(id);
    }
    
}
