/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Tecnologia;
import static br.unesp.rc.habilidades.dao.MembroDAO.DELETE_MEMBRO;
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
                pstm.setBoolean(3, tec.isAtivo());
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
    public boolean remove(int idTecnologia) {

        Connection con;
        ResultSet res = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstmt = con.prepareStatement(DELETE_TECNOLOGIA);
                pstmt.setInt(1, idTecnologia);
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Erro ao remover: " + ex.getMessage());
                ret = false;
            } finally {
                FabricaConexao.close(con, pstmt, res);
            }
        }
        return ret;
    }

    @Override
    public boolean update(Tecnologia tec) {

        Connection con;
        ResultSet res = null;
        PreparedStatement pstm = null;
        boolean ret = false;
        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_TECNOLOGIA);
                pstm.setInt(1, tec.getIdTecnologia());
                pstm.setString(2, tec.getNome());
                ret = pstm.executeUpdate() > 0;

            } catch (SQLException ex) {
                System.out.println("Erro ao atualizar: " + ex.getMessage());
            } finally {
                FabricaConexao.close(con, pstm, res);
            }
        }

        return ret;
    }

    @Override
    public Tecnologia select(int idTecnologia) {

        Connection con = FabricaConexao.getConnection();;
        ResultSet res = null;
        PreparedStatement pstm = null;

        Tecnologia ret = null;

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_TECNOLOGIA);
                pstm.setInt(1, idTecnologia);
                res = pstm.executeQuery();

                if (res.next()) {
                    Tecnologia tec = new Tecnologia();
                    tec.setIdTecnologia(res.getInt(1));
                    tec.setNome(res.getString(2));
                    tec.setAtivo(res.getBoolean("ativo"));
                    ret = tec;
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

    @Override
    public List<Tecnologia> select() {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        List<Tecnologia> ret = new ArrayList<>();

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_ALL);
                res = pstm.executeQuery();

                while (res.next()) {
                    Tecnologia tec = new Tecnologia();
                    tec.setIdTecnologia(res.getInt(1));
                    tec.setNome(res.getString(2));
                    tec.setAtivo(res.getBoolean("ativo"));
                    ret.add(tec);
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

