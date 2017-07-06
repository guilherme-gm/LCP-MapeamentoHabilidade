/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.TecnologiaMembro;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class TecnologiaMembroDaoImpl implements TecnologiaMembroDAO {

    @Override
    public boolean insert(TecnologiaMembro tecnologiaMembro) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;
        int idTecnologiaMembro = -1;

        boolean ret = false;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setShort(1, tecnologiaMembro.getNivel());
                pstm.setLong(2, tecnologiaMembro.getMembro().getIdMembro());
                pstm.setInt(3, tecnologiaMembro.getTecnologia().getIdTecnologia());

                pstm.executeUpdate();

                res = pstm.getGeneratedKeys();
                if (res.next()) {
                    idTecnologiaMembro = res.getInt(1);
                    tecnologiaMembro.setIdTecnologiaMembro(idTecnologiaMembro);
                }
                ret = true;
            } catch (SQLException ex) {
                System.out.println("Erro ao adicionar: " + ex.getMessage());
                ret = false;
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
        return ret;
    }

    @Override
    public boolean update(TecnologiaMembro tecnologiaMembro) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        boolean ret = true;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE);
                pstm.setShort(1, tecnologiaMembro.getNivel());
                pstm.setLong(2, tecnologiaMembro.getIdTecnologiaMembro());

                ret = pstm.executeUpdate() > 0;
            } catch (SQLException ex) {
                System.out.println("Erro ao atualizar: " + ex.getMessage());
                ret = false;
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
        return ret;
    }

    @Override
    public boolean delete(long idTecnologiaMembro) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        boolean ret = true;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(DELETE);
                pstm.setLong(1, idTecnologiaMembro);
                pstm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Erro ao deletar: " + ex.getMessage());
                ret = false;
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
        return ret;
    }

    @Override
    public List<TecnologiaMembro> select(Membro membro) {
        Connection con;
        ResultSet res = null;
        PreparedStatement pstm = null;

        List<TecnologiaMembro> ret = new ArrayList<>();

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_ALL_MEMBRO);
                pstm.setLong(1, membro.getIdMembro());
                res = pstm.executeQuery();

                TecnologiaDAO tecnologiaDao = new TecnologiaDAOImpl();
                
                while (res.next()) {
                    TecnologiaMembro tecMembro = new TecnologiaMembro();
                    tecMembro.setIdTecnologiaMembro(res.getLong("idTecnologiaMembro"));
                    tecMembro.setMembro(membro);
                    tecMembro.setNivel(res.getShort("nivel"));
                    tecMembro.setTecnologia(tecnologiaDao.select(res.getInt("Tecnologia_idTecnologia")));
                    
                    ret.add(tecMembro);
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao selecionar: " + ex.getMessage());
                ret = null;
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }
        return ret;
    }
}
