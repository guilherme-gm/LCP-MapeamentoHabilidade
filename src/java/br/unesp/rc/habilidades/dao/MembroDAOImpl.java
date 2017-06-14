/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        long idAcesso = -1;

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
            
            idAcesso = rs.getInt(1);
            membro.getAcesso().setIdAcesso(idAcesso);
            
            pstmt.close();
            pstmt = con.prepareStatement(INSERT_MEMBRO, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, membro.getNome());
            pstmt.setString(2, membro.getTelefone());
            pstmt.setString(3, membro.getEmail());
            pstmt.setDate(4, (Date) membro.getDataContratacao());
            pstmt.setLong(5, idAcesso);
            //pstmt.setInt(6, membro.getCargo().get);
        } catch (Exception ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return true;
    }

    @Override
    public boolean remove(Membro login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Membro login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Membro select(String usuario, String senha) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Membro membro = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_LOGIN);
            pstmt.setString(1, usuario);
            pstmt.setString(2, senha);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                membro = new Membro();
                //membro.setCargo(cargo);
                membro.setDataContratacao(rs.getDate("dataContratacao"));
                membro.setEmail(rs.getString("email"));
                membro.setIdMembro(rs.getLong("idMembro"));
                membro.setNome(rs.getString("nome"));
                //membro.setProjeto(projeto);
                //membro.setTecnologiaMembro(tecnologiaMembro);
                membro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return membro;
    }

}
