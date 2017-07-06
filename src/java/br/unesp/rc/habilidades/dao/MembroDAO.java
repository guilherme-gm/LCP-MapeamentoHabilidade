/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface MembroDAO {

    final String INSERT_MEMBRO
            = "INSERT INTO `Membro`"
            + "("
            + "`nome`,"
            + "`telefone`,"
            + "`email`,"
            + "`dataContratacao`,"
            + "`ativo`,"
            + "`Acesso_idAcesso`,"
            + "`Cargo_idCargo`"
            + ")"
            + "VALUES"
            + "("
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?,"
            + "?"
            + ");";

    final String INSERT_ACESSO
            = "INSERT INTO `Acesso`"
            + "(`idAcesso`,"
            + "`usuario`,"
            + "`senha`)"
            + "VALUES"
            + "(?,"
            + "?,"
            + "?);";

    final String SELECT_BY_LOGIN
            = "SELECT `Membro`.`idMembro`, "
            + "    `Membro`.`nome`,"
            + "    `Membro`.`telefone`, "
            + "    `Membro`.`email`, "
            + "    `Membro`.`dataContratacao`, "
            + "    `Membro`.`ativo`, "
            + "    `Membro`.`Acesso_idAcesso`, "
            + "    `Membro`.`Cargo_idCargo`, "
            + "    `Acesso`.`idAcesso`, "
            + "    `Acesso`.`usuario`, "
            + "    `Acesso`.`senha` "
            + "FROM `Membro` "
            + "INNER JOIN `Acesso` "
            + "   ON `Acesso`.`idAcesso` = `Membro`.`Acesso_idAcesso` "
            + "WHERE "
            + "   `Acesso`.`usuario` = ? AND `Acesso`.`senha` = ? AND `Membro`.`ativo` = 1;";

    final String SELECT_BY_ID
            = "SELECT `Membro`.`idMembro`, "
            + "    `Membro`.`nome`,"
            + "    `Membro`.`telefone`, "
            + "    `Membro`.`email`, "
            + "    `Membro`.`dataContratacao`, "
            + "    `Membro`.`ativo`, "
            + "    `Membro`.`Acesso_idAcesso`, "
            + "    `Membro`.`Cargo_idCargo`, "
            + "    `Acesso`.`idAcesso`, "
            + "    `Acesso`.`usuario`, "
            + "    `Acesso`.`senha` "
            + "FROM `Membro` "
            + "INNER JOIN `Acesso` "
            + "   ON `Acesso`.`idAcesso` = `Membro`.`Acesso_idAcesso` "
            + "WHERE "
            + "   `Membro`.`idMembro` = ?;";

    final String SELECT_ALL
            = "SELECT `Membro`.`idMembro`, "
            + "    `Membro`.`nome`,"
            + "    `Membro`.`telefone`, "
            + "    `Membro`.`email`, "
            + "    `Membro`.`dataContratacao`, "
            + "    `Membro`.`ativo`, "
            + "    `Membro`.`Acesso_idAcesso`, "
            + "    `Membro`.`Cargo_idCargo`, "
            + "    `Acesso`.`idAcesso`, "
            + "    `Acesso`.`usuario`, "
            + "    `Acesso`.`senha` "
            + "FROM `Membro` "
            + "INNER JOIN `Acesso` "
            + "   ON `Acesso`.`idAcesso` = `Membro`.`Acesso_idAcesso` "
            + "WHERE "
            + "   `Membro`.`ativo` = 1;";

    final String DELETE_MEMBRO
            = "UPDATE `Membro` SET `ativo` = 0 WHERE `idMembro` = ?;";

    final String UPDATE_MEMBRO
            = "UPDATE `Membro`, `Acesso` "
            + "SET `Membro`.`nome` = ?, "
            + "    `Membro`.`telefone` = ?, "
            + "    `Membro`.`email` = ?, "
            + "    `Membro`.`dataContratacao` = ?, "
            + "    `Membro`.`ativo` = ?, "
            + "    `Membro`.`Cargo_idCargo` = ?, "
            + "    `Acesso`.`senha` = ? "
            + "WHERE "
            + "   `Membro`.`idAcesso` = `Acesso`.`idAcesso` AND "
            + "   `Membro`.`idMembro` = ?;";

    public boolean insert(Membro membro);

    public boolean remove(long idMembro);

    public boolean update(Membro membro);

    public Membro select(String usuario, String senha);

    public Membro select(long idMembro);

    public List<Membro> select();

}
