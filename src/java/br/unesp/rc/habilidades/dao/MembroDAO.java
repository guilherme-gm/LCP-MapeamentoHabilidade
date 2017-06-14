/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;

/**
 *
 * @author guilh
 */
public interface MembroDAO {
    
    final String INSERT_MEMBRO = 
        "INSERT INTO `Membro`" +
        "("+
            "`nome`," +
            "`telefone`," +
            "`email`," +
            "`dataContratacao`," +
            "`Acesso_idAcesso`," +
            "`Cargo_idCargo`" +
        ")"+
        "VALUES" +
        "(" +
            "?," +
            "?," +
            "?," +
            "?," +
            "?," +
            "?" +
        ");";
    
    final String INSERT_ACESSO =
        "INSERT INTO `Acesso`" +
        "(`idAcesso`," +
        "`usuario`," +
        "`senha`)" +
        "VALUES" +
        "(?," +
        "?," +
        "?);";

    
    final String SELECT_BY_LOGIN = 
            "SELECT `Membro`.`idMembro`, " +
            "    `Membro`.`nome`," +
            "    `Membro`.`telefone`, " +
            "    `Membro`.`email`, " +
            "    `Membro`.`dataContratacao`, " +
            "    `Membro`.`Acesso_idAcesso`, " +
            "    `Membro`.`Cargo_idCargo` " +
            "FROM `Membro` " +
            "INNER JOIN `Acesso` " +
            "   ON `Acesso`.`idAcesso` = `Membro`.`Acesso_idAcesso` " +
            "WHERE " +
            "   `Acesso`.`usuario` = ? AND `Acesso`.`senha` = ?";
    
    
    public boolean insert(Membro login);
    public boolean remove(Membro login);
    public boolean update(Membro login);
    public Membro select(String usuario, String senha);
    
}
