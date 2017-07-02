/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Cargo;
import br.unesp.rc.habilidades.beans.Permissao;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aluno
 */
public class CargoDAOImpl implements CargoDAO {

    @Override
    public boolean insert(Cargo cargo) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;
        int idCargo = -1;

        boolean ret = false;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
                pstm.setString(1, cargo.getNome());
                pstm.setString(2, Permissao.serialize(cargo.getPermissao()));
                pstm.executeUpdate();

                res = pstm.getGeneratedKeys();
                if (res.next()) {
                    idCargo = res.getInt(1);
                    cargo.setIdCargo(idCargo);
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
    public boolean update(Cargo cargo) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        boolean ret = true;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE);
                pstm.setString(1, cargo.getNome());
                pstm.setString(2, Permissao.serialize(cargo.getPermissao()));
                pstm.setInt(3, cargo.getIdCargo());
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
    public boolean delete(int idCargo) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        boolean ret = true;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(DELETE);
                pstm.setInt(1, idCargo);
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
    public Cargo select(int idCargo) {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        Cargo ret = null;

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT);
                pstm.setInt(1, idCargo);
                res = pstm.executeQuery();
                
                 if (res.next()){
                    Cargo cargo = new Cargo();
                    cargo.setIdCargo(res.getInt(1));
                    cargo.setNome(res.getString(2));
                    cargo.setPermissao(Permissao.deserialize(res.getString(3)));
                    ret = cargo;
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
    public List<Cargo> select() {
        Connection con = null;
        ResultSet res = null;
        PreparedStatement pstm = null;

        List<Cargo> ret = new ArrayList<Cargo>();

        con = FabricaConexao.getConnection();

        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_ALL);                
                res = pstm.executeQuery();
                
                 while(res.next()){
                    Cargo cargo = new Cargo();
                    cargo.setIdCargo(res.getInt(1));
                    cargo.setNome(res.getString(2));
                    cargo.setPermissao(Permissao.deserialize(res.getString(3)));
                    ret.add(cargo);
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
