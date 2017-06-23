/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
import br.unesp.rc.habilidades.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author guilh
 */
public class ProjetoDAOImpl implements ProjetoDAO {

    @Override
    public boolean insert(Projeto projeto) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        boolean ret = true;
        
        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);

            // Adiciona Projeto
            pstmt = con.prepareStatement(INSERT_PROJETO, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, projeto.getNome());
            pstmt.setString(2, projeto.getDescricao());
            pstmt.setDate(3, projeto.getDataInicio());
            pstmt.setDate(4, projeto.getDataFim());
            pstmt.setString(5, projeto.getStatus());
            pstmt.executeQuery();
            rs = pstmt.getGeneratedKeys();
            
            if (!rs.next()) {
                throw new Exception("Nao foi possível inserir Projeto (1).");
            }
            
            long idProjeto = rs.getLong(1);
            projeto.setIdProjeto(idProjeto);
            
            pstmt.close();
            
            // Inserir membro no projeto
            pstmt = con.prepareStatement(INSERT_PROJETO_MEMBRO);
            
            for (Membro membro : projeto.getMembro()) {
                pstmt.setLong(1, membro.getIdMembro());
                pstmt.setLong(2, projeto.getIdProjeto());
                pstmt.executeQuery();
            }
            
            pstmt.close();
            
            // Inserir Tecnologias no Projeto
            pstmt = con.prepareStatement(INSERT_PROJETO_TECNOLOGIA);
            
            for (Tecnologia tecnologia : projeto.getTecnologia()) {
                pstmt.setLong(1, projeto.getIdProjeto());
                pstmt.setLong(2, tecnologia.getIdTecnologia());
                pstmt.executeQuery();
            }
            
            pstmt.close();
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
    public boolean remove(long projetoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Projeto projeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Projeto> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projeto select(long projetoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
