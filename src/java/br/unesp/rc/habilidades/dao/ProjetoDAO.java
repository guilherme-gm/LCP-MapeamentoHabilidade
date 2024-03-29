/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.StatusProjeto;
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
            = "DELETE FROM `Projeto` WHERE `idProjeto` = ?";

    public final String UPDATE
            = "UPDATE `Projeto` "
            + "SET "
            + "`nome` = ?, `descricao` = ?, `dataInicio` = ?, `dataFim` = ?, `status` = ? "
            + "WHERE `idProjeto` = ?;";

    public final String UPDATE_STATUS
            = "UPDATE `Projeto` "
            + "SET "
            + "`status` = ?, `dataFim` = ? "
            + "WHERE `idProjeto` = ?;";

    public final String SELECT
            = "SELECT `Projeto`.`idProjeto`,`Projeto`.`nome`, `Projeto`.`descricao`, "
            + "`Projeto`.`dataInicio`, `Projeto`.`dataFim`, `Projeto`.`status` "
            + "FROM `Projeto` "
            + "ORDER BY `Projeto`.`status` DESC";
    
    public final String SELECT_BY_MEMBRO
            = "SELECT `Projeto`.`idProjeto`,`Projeto`.`nome`, `Projeto`.`descricao`, "
            + "`Projeto`.`dataInicio`, `Projeto`.`dataFim`, `Projeto`.`status` "
            + "FROM `Projeto` "
            + "INNER JOIN `Membro_has_Projeto` "
            + "ON `Membro_has_Projeto`.`Projeto_idProjeto` = `Projeto`.`idProjeto` "
            + "WHERE `Membro_has_Projeto`.`Membro_idMembro` = ? "
            + "ORDER BY `Projeto`.`status` DESC";

    public final String SELECT_MEMBROS
            = "SELECT `Membro_idMembro`, `Projeto_idProjeto` FROM `Membro_has_Projeto` WHERE `Projeto_idProjeto` = ?";

    public final String SELECT_TECNOLOGIAS_BY_ID
            = "SELECT `Projeto_has_Tecnologia`.`Tecnologia_idTecnologia` "
            + "FROM `Projeto_has_Tecnologia` "
            + "WHERE `Projeto_has_Tecnologia`.`Projeto_idProjeto` = ?";
    
    public final String SELECT_MEMBROS_BY_ID
            = "SELECT `Membro_has_Projeto`.`Membro_idMembro` "
            + "FROM `Membro_has_Projeto` "
            + "WHERE `Membro_has_Projeto`.`Projeto_idProjeto` = ?";
    
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
    
    public void finaliza(long projetoId);
    
    public void cancela(long projetoId);
    
    public List<Projeto> selectProjetoMembro(Membro membro);

}
