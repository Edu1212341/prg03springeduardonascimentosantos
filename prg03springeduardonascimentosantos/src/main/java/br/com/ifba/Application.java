/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author eduardo
 */
@SpringBootApplication
public class Application {//Essa apliccation foi feita com Auxilio de IA, nao tava conseguindo iniciar...

    public static void main(String[] args) {
        
        // 1. DESLIGA O MODO SERVIDOR (
        System.setProperty("java.awt.headless", "false");
        
        // 2. LIGA O SPRING 
        ApplicationContext context = SpringApplication.run(Application.class, args);
        
        // 3. PUXA A TELA
        CursoListar telaPrincipal = context.getBean(CursoListar.class);
        
        // 4. MOSTRA A TELA PARA O USUÁRIO
        telaPrincipal.setVisible(true);
    }
}