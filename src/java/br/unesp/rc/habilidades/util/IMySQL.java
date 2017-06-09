/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.util;

/**
 *
 * @author guilh
 */
public interface IMySQL {
        
    static final String DATABASE = "jdbc:mysql://localhost:3306/mapeamentohabilidade";
    static final String USER = "root";
    static final String PASSWORD = "aluno";
    static final String DRIVER = "org.gjt.mm.mysql.Driver";

}