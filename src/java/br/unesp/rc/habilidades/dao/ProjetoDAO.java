/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
import java.util.List;

/**
 *
 * @author guilh
 */
public interface ProjetoDAO {

    public final String INSERT_PROJETO
            = "INSERT INTO `Projeto`"
            + "(`nome`, `descricao`, `dataInicio`, `dataFim`, `status`)"
            + "VALUES"
            + "(?, ?, ?, ?, ?);";

    public final String INSERT_PROJETO_MEMBRO
            = "INSERT INTO `Membro_has_Projeto`"
            + "(`Membro_idMembro`, `Projeto_idProjeto`)"
            + "VALUES"
            + "(?, ?);";

    public final String INSERT_PROJETO_TECNOLOGIA
            = "INSERT INTO `Projeto_has_Tecnologia`"
            + "(`Projeto_idProjeto`, `Tecnologia_idTecnologia`)"
            + "VALUES"
            + "(?, ?);";

    public final String DELETE_PROJETO_MEMBRO
            = "DELETE FROM `Membro_has_Projeto` WHERE `Projeto_idProjeto` = ?;";

    public final String DELETE_PROJETO_TECNOLOGIA
            = "DELETE FROM `Projeto_has_Tecnologia` WHERE `Projeto_idProjeto` = ?;";

    public final String DELETE
            = "UPDATE `Projeto` SET `status` = 'CANCELADO'";

    public final String UPDATE
            = "UPDATE `Projeto` "
            + "SET "
            + "`nome` = ?, `descricao` = ?, `dataInicio` = ?, `dataFim` = ?, `status` = ? "
            + "WHERE `idProjeto` = ?;";

    public final String SELECT
            = "SELECT `Projeto`.`idProjeto`,`Projeto`.`nome`, `Projeto`.`descricao`, "
            + "`Projeto`.`dataInicio`, `Projeto`.`dataFim`, `Projeto`.`status` "
            + "FROM `Projeto`";

    public final String SELECT_MEMBROS
            = "SELECT `Membro_idMembro`, `Projeto_idProjeto` FROM `Membro_has_Projeto` WHERE `Projeto_idProjeto` = ?";

    public final String SELECT_BY_ID
            = "SELECT `Projeto`.`idProjeto`,`Projeto`.`nome`, `Projeto`.`descricao`, "
            + "`Projeto`.`dataInicio`, `Projeto`.`dataFim`, `Projeto`.`status` "
            + "FROM `Projeto` "
            + "WHERE `Projeto`.`idProjeto` = ?";

    public final String SELECT_MEMBRO_RANK
            = "SELECT a.Membro_idMembro "
            + "FROM tecnologiamembro a "
            + "LEFT JOIN membro b "
            + "ON a.Membro_idMembro = b.idMembro "
            + "LEFT JOIN tecnologia c "
            + "ON a.Tecnologia_idTecnologia = c.idTecnologia "
            + "WHERE ("
            + "    SELECT count(d.Membro_idMembro) as total"
            + "    FROM tecnologiamembro d"
            + "    WHERE d.Membro_idMembro = a.Membro_idMembro"
            + "    AND d.Tecnologia_idTecnologia IN (?,?,?,?,?,?,?,?,?,?)"
            + "    GROUP BY Membro_idMembro"
            + ") = ? "
            + "AND a.Tecnologia_idTecnologia IN (?,?,?,?,?,?,?,?,?,?) "
            + "GROUP BY a.Membro_idMembro "
            + "ORDER BY a.Membro_idMembro ASC;";

    public boolean insert(Projeto projeto);

    public boolean remove(long projetoId);

    public boolean update(Projeto projeto);

    public List<Projeto> select();

    public Projeto select(long projetoId);
    
    public List<Membro> select_membros(List<Tecnologia> tecnologias);

}
