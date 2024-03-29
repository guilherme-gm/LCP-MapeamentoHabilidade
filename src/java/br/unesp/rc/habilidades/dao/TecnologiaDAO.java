/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Tecnologia;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface TecnologiaDAO {

    final String INSERT_TECNOLOGIA
            = "INSERT INTO `Tecnologia`"
            + "("
            + " `nome`,"
            + "`ativo`"
            + ") VALUES (?,1)";

    final String UPDATE_TECNOLOGIA
            = "UPDATE `Tecnologia`"
            + "SET"
            + " `nome` = ?,"
            + " `ativo` = ? "
            + "WHERE"
            + " `idTecnologia` = ?;";
    final String DELETE_TECNOLOGIA
            = "UPDATE `Tecnologia` "
            + "SET `ativo` = 0 "
            + "WHERE `idTecnologia` = ?;";

    final String SELECT_TECNOLOGIA
            = "SELECT `Tecnologia`.`idTecnologia`, "
            + "    `Tecnologia`.`nome`,"
            + "    `Tecnologia`.`ativo` "
            + "FROM `Tecnologia` "
            + "WHERE "
            + " `Tecnologia`.`idTecnologia` = ?;";
    final String SELECT_ALL
             = "SELECT `Tecnologia`.`idTecnologia`, "
            + "    `Tecnologia`.`nome`, "
            + "    `Tecnologia`.`ativo` "
            + "FROM `Tecnologia` "
            + "WHERE "
            + " ativo = 1 ";

    public boolean insert(Tecnologia tec);

    public boolean remove(int idTecnologia);

    public boolean update(Tecnologia tec);

    public Tecnologia select(int idTecnologia);
    
    public List<Tecnologia> select();

}
