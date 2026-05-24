/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infraestructure.util.StringUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardo
 */
@RequiredArgsConstructor //Assim nao vamos mais precisar dos Autowired
@Service
public class CursoService implements CursoIService{
    
    private final CursoRepository cursoRepository; //final para o required funcionar
    
    private static final Logger log = LoggerFactory.getLogger(CursoService.class);

    @Override
    public Curso save(Curso curso) {
        validarCurso(curso); // Chama a validação antes de salvar
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        validarCurso(curso);
        log.info("Salvando o curso");
        return cursoRepository.save(curso);//O bixo e inteligente, o save funciona como um UPDATE
    }

    @Override
    public void delete(Curso curso) {
        log.info("Apagando o curso");
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        log.info("Buscando todos os cursos");
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        log.info("Buscando o curso por ID");
        return cursoRepository.findById(id).orElse(null);//ele tenta pegar por ID, se nao tiver vai null. nao é bom usar o .get
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
