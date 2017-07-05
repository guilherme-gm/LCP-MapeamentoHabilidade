/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.dao;

import br.unesp.rc.habilidades.beans.Membro;
import br.unesp.rc.habilidades.beans.Projeto;
import br.unesp.rc.habilidades.beans.StatusProjeto;
import br.unesp.rc.habilidades.beans.Tecnologia;
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
            pstmt.setString(5, projeto.getStatus().toString());
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

            con.commit();
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
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        boolean ret = true;

        if (con == null) {
            return false;
        }

        try {
            con.setAutoCommit(false);

            // Atualiza Projeto
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setString(1, projeto.getNome());
            pstmt.setString(2, projeto.getDescricao());
            pstmt.setDate(3, projeto.getDataInicio());
            pstmt.setDate(4, projeto.getDataFim());
            pstmt.setString(5, projeto.getStatus().toString());
            pstmt.setLong(6, projeto.getIdProjeto());
            pstmt.executeQuery();
            pstmt.close();

            // Atualiza membros no projeto
            pstmt = con.prepareStatement(DELETE_PROJETO_MEMBRO);
            pstmt.setLong(1, projeto.getIdProjeto());
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = con.prepareStatement(INSERT_PROJETO_MEMBRO);

            for (Membro membro : projeto.getMembro()) {
                pstmt.setLong(1, membro.getIdMembro());
                pstmt.setLong(2, projeto.getIdProjeto());
                pstmt.executeQuery();
            }

            pstmt.close();

            // Atualiza Tecnologias no Projeto
            pstmt = con.prepareStatement(DELETE_PROJETO_TECNOLOGIA);
            pstmt.setLong(1, projeto.getIdProjeto());
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = con.prepareStatement(INSERT_PROJETO_TECNOLOGIA);

            for (Tecnologia tecnologia : projeto.getTecnologia()) {
                pstmt.setLong(1, projeto.getIdProjeto());
                pstmt.setLong(2, tecnologia.getIdTecnologia());
                pstmt.executeQuery();
            }

            pstmt.close();

            con.commit();
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
    public List<Projeto> select() {
        List<Projeto> projetos = new ArrayList<>();
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Projeto projeto = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                projeto = new Projeto();
                projeto.setIdProjeto(rs.getLong("idProjeto"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataInicio(rs.getDate("dataInicio"));
                projeto.setDataFim(rs.getDate("projetoFim"));
                projeto.setStatus(StatusProjeto.valueOf(rs.getString("status")));
                projeto.setMembro(this.selectMembros(projeto.getIdProjeto()));
                projeto.setTecnologia(this.selectTecnologias(projeto.getIdProjeto()));
                
                projetos.add(projeto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return projetos;
    }

    private List<Membro> selectMembros(long projetoId) {
        List<Membro> membros = new ArrayList<>();
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_ID);
            pstmt.setLong(1, projetoId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                MembroDAO membroDao = new MembroDAOImpl();
                membros.add(membroDao.select(rs.getLong("Membro_idMembro")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return membros;
    }
    
    private List<Tecnologia> selectTecnologias(long projetoId) {
        List<Tecnologia> tecnologias = new ArrayList<>();
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_ID);
            pstmt.setLong(1, projetoId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                TecnologiaDAO tecnologiaDao = new TecnologiaDAOImpl();
                tecnologias.add(tecnologiaDao.select(rs.getInt("Tecnologia_idTecnologia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return tecnologias;
    }
    
    @Override
    public Projeto select(long projetoId) {
        Connection con = FabricaConexao.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Projeto projeto = null;

        if (con == null) {
            return null;
        }

        try {
            pstmt = con.prepareStatement(SELECT_BY_ID);
            pstmt.setLong(1, projetoId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                projeto = new Projeto();
                projeto.setIdProjeto(rs.getLong("idProjeto"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataInicio(rs.getDate("dataInicio"));
                projeto.setDataFim(rs.getDate("projetoFim"));
                projeto.setStatus(StatusProjeto.valueOf(rs.getString("status")));
                projeto.setMembro(this.selectMembros(projetoId));
                projeto.setTecnologia(this.selectTecnologias(projetoId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.close(con, pstmt, rs);
        }

        return projeto;
    }

}
