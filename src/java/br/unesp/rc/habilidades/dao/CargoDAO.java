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
    final String UPDATE = "UPDATE `Cargo` "
        + "SET `nome`  = ?, `permissao` = ? WHERE `idCargo` = ?;";
    final String DELETE = "UPDATE `Cargo` SET `ativo` = 0 WHERE `idCargo` = ?;";
    final String SELECT = "SELECT `idCargo`, `nome`, `permissao` FROM `Cargo` WHERE `idCargo` = ?;";
    final String SELECT_ALL = "SELECT `idCargo`, `nome`, `permissao` FROM `Cargo` WHERE `ativo` = 1;";
    
    public boolean insert(Cargo cargo);
    public boolean update(Cargo cargo);
    public boolean delete(int idCargo);
    public Cargo select(int idCargo);
    public List<Cargo> select();
}
