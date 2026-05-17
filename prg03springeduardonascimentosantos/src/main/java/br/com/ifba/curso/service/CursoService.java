/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infraestructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@Service
public class CursoService implements CursoIService{
    @Autowired
    private CursoIDao cursoDao;

    @Override
    public Curso save(Curso curso) {
        validarCurso(curso); // Chama a validação antes de salvar
        return cursoDao.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        validarCurso(curso);
        return cursoDao.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoDao.findById(id);
    }

    
    private void validarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("O curso nao pode ser nulo");
        }
        // uso da classe StringUtil
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new IllegalArgumentException("O nome do curso e obrigatorio e nao pode estar vazio");
        }
        if (StringUtil.isNullOrEmpty(curso.getDescricao())) {
            throw new IllegalArgumentException("A descricao do curso e obrigatoria");
        }
        if (curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("A carga horaria tem de ser maior que zero");
        }
    }
}
