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
    
   final String INSERT_TECNOLOGIA = 
           "INSET INTO `Tecnologia`"
           + "("
           + " `idTecnologia`,"
           + " `nome`,"
           + ") VALUES (?,?,?)";    
   
   final String UPDATE_TECNOLOGIA =
           "UPDATE `Tecnologia`"
            + "SET"
            + " `idTecnologia` = ?,"
            + " `nome` = ?,"
            + "WHERE"
            + " `idAtendimento` = ?";
   
       
    public boolean insert(Tecnologia tec);
    public boolean remove(Tecnologia tec);
    public boolean update(Tecnologia tec);
    public Tecnologia select(int idTecnologia);
    public List<Tecnologia> select();
    
    
    
}
