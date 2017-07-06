/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.TecnologiaMembro;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface TecnologiaMembroDAO {

    final String INSERT = "insert into TecnologiaMembro (nivel, Membro_idMembro, Tecnologia_idTecnologia) "
            + "values (?,?,?);";
    final String UPDATE = "update TecnologiaMembro "
            + "set nivel  = ? where idTecnologiaMembro = ?;";
    final String DELETE = "delete from TecnologiaMembro where idTecnologiaMembro = ?;";
    final String SELECT_ALL_MEMBRO
            = "SELECT "
            + "`idTecnologiaMembro`,"
            + "`nivel`,"
            + "`Membro_idMembro`,"
            + "`Tecnologia_idTecnologia` "
            + "FROM `TecnologiaMembro` "
            + "WHERE `Membro_idMembro` = ?;";

    public boolean insert(TecnologiaMembro tecnologiaMembro);

    public boolean update(TecnologiaMembro tecnologiaMembro);

    public boolean delete(long idTecnologiaMembro);
    
    public List<TecnologiaMembro> select(Membro membro);
}
