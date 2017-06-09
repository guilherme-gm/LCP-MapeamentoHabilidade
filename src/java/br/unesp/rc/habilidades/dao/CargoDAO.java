/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Cargo;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface CargoDAO {
    final String INSERT = "insert into Cargo (nome,permissao)"
            + "values (?,?);";
    final String UPDATE = "update Cargo "
        + "set nome  = ?, set permissao = ? where idCargo = ?;";
    final String DELETE = "delete from Cargo where idCargo = ?;";
    final String SELECT = "select (idCargo, nome, permissao) from Cargo where idCargo = ?;";
    final String SELECT_ALL = "select (idCargo, nome, permissao) from Cargo;";
    
    public boolean insert(Cargo cargo);
    public boolean update(Cargo cargo);
    public boolean delete(int idCargo);
    public Cargo select(int idCargo);
    public List<Cargo> select();
}
