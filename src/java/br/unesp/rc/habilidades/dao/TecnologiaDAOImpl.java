/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aluno
 */
public class TecnologiaDAOImpl implements TecnologiaDAO {

    @Override
    public boolean insert(Tecnologia tec) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;
       
        int idTecnologia = -1;
        boolean aux = false;
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_TECNOLOGIA, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setInt(1, tec.getIdTecnologia());
                pstm.setString(2, tec.getNome());
                pstm.executeUpdate();

                res = pstm.getGeneratedKeys();
                if (res.next()) {
                    idTecnologia = res.getInt(1);
                }
                tec.setIdTecnologia(idTecnologia);
                aux = true;
            } catch (SQLException ex) {
                System.out.println("Erro ao adicionar: " + ex.getMessage());
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
        return aux;
    }

    @Override
    public boolean remove(Tecnologia tec) {
        return false;
    }

    @Override
    public boolean update(Tecnologia tec) {

        Connection con;
        ResultSet res = null;
        PreparedStatement pstm = null;
        boolean aux = false;
        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_TECNOLOGIA);
                pstm.setInt(1, tec.getIdTecnologia());
                pstm.setString(2, tec.getNome());
                aux = pstm.executeUpdate() > 0;

            } catch (SQLException ex) {
                System.out.println("Erro ao atualizar: " + ex.getMessage());
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
    }

    @Override
    public Tecnologia select(int idTecnologia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<Tecnologia> select() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
