/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class MembroDAOImpl implements MembroDAO {

    @Override
    public boolean insert(Membro membro) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        boolean ret = true;

        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(INSERT_ACESSO, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, membro.getAcesso().getUsuario());
            pstmt.setString(2, membro.getAcesso().getSenha());
            pstmt.executeQuery();
            rs = pstmt.getGeneratedKeys();

            if (!rs.next()) {
                throw new Exception("Nao foi possível inserir Acesso.");
            }

            long idAcesso = rs.getLong(1);
            membro.getAcesso().setIdAcesso(idAcesso);

            pstmt.close();
            pstmt = con.prepareStatement(INSERT_MEMBRO, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, membro.getNome());
            pstmt.setString(2, membro.getTelefone());
            pstmt.setString(3, membro.getEmail());
            pstmt.setDate(4, membro.getDataContratacao());
            pstmt.setBoolean(5, membro.isAtivo());
            pstmt.setLong(6, idAcesso);
            pstmt.setInt(7, membro.getCargo().getIdCargo());

            pstmt.executeQuery();
            rs = pstmt.getGeneratedKeys();

            if (!rs.next()) {
                throw new Exception("Nao foi possível inserir Acesso.");
            }

            long idMembro = rs.getInt(1);
            membro.setIdMembro(idMembro);
        } catch (Exception ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                System.out.println("Nao foi possível fazer rollback.");
            }
            ret = false;
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return ret;
    }

    @Override
    public boolean remove(long idMembro) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        boolean ret = true;

        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(DELETE_MEMBRO);
            pstmt.setLong(1, idMembro);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ret = false;
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return ret;
    }

    @Override
    public boolean update(Membro membro) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        boolean ret = true;

        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(UPDATE_MEMBRO);
            pstmt.setString(1, membro.getNome());
            pstmt.setString(2, membro.getTelefone());
            pstmt.setString(3, membro.getEmail());
            pstmt.setDate(4, membro.getDataContratacao());
            pstmt.setBoolean(5, membro.isAtivo());
            pstmt.setInt(6, membro.getCargo().getIdCargo());
            pstmt.setString(7, membro.getAcesso().getSenha());
            pstmt.setLong(8, membro.getIdMembro());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ret = false;
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return ret;
    }

    @Override
    public Membro select(String usuario, String senha) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Membro membro = null;
        TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_LOGIN);
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                CargoDAO cargoDao = new CargoDAOImpl();

                membro = new Membro();
                membro.setCargo(cargoDao.select(rs.getInt("Cargo_idCargo")));
                membro.setDataContratacao(rs.getDate("dataContratacao"));
                membro.setEmail(rs.getString("email"));
                membro.setIdMembro(rs.getLong("idMembro"));
                membro.setNome(rs.getString("nome"));
                membro.setAtivo(rs.getBoolean("ativo"));
                //membro.setProjeto(projeto);
                membro.setTecnologiaMembro(tecMembroDao.select(membro));
                membro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return membro;
    }

    @Override
    public Membro select(long idMembro) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Membro membro = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_ID);
            pstmt.setLong(1, idMembro);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                CargoDAO cargoDao = new CargoDAOImpl();
                TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();

                membro = new Membro();
                membro.setCargo(cargoDao.select(rs.getInt("Cargo_idCargo")));
                membro.setDataContratacao(rs.getDate("dataContratacao"));
                membro.setEmail(rs.getString("email"));
                membro.setIdMembro(rs.getLong("idMembro"));
                membro.setNome(rs.getString("nome"));
                membro.setAtivo(rs.getBoolean("ativo"));
                membro.setTecnologiaMembro(tecMembroDao.select(membro));
                membro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return membro;
    }

    @Override
    public List<Membro> select() {
        List<Membro> membros = new ArrayList<>();
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_ALL);

            rs = pstmt.executeQuery();
            TecnologiaMembroDAO tecMembroDao = new TecnologiaMembroDaoImpl();
            while (rs.next()) {
                CargoDAO cargoDao = new CargoDAOImpl();

                Membro membro = new Membro();
                membro.setCargo(cargoDao.select(rs.getInt("Cargo_idCargo")));
                membro.setDataContratacao(rs.getDate("dataContratacao"));
                membro.setEmail(rs.getString("email"));
                membro.setIdMembro(rs.getLong("idMembro"));
                membro.setNome(rs.getString("nome"));
                membro.setAtivo(rs.getBoolean("ativo"));
                //membro.setProjeto(projeto);
                membro.setTecnologiaMembro(tecMembroDao.select(membro));
                membro.setTelefone(rs.getString("telefone"));

                membros.add(membro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return membros;
    }

}
