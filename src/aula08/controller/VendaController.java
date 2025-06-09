/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.controller;

import aula08.model.ProdutoModel;
import aula08.model.VendaModel;
import aula08.util.Conexao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author wander
 */
public class VendaController {
    
    public List<VendaModel> listar() {
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM venda";
        List<VendaModel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
                VendaModel venda = new VendaModel();
                venda.setId(rs.getInt(1));
                venda.setDescricao(rs.getString(2));
                lista.add(venda);
            }
            return lista;
        } catch(Exception ex) {
            System.err.println(ex);
            lista = null;
        } finally {
            conexao.encerrar(con);
            return lista;
        }                
    }
    
    public VendaModel selecionar(VendaModel produto) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM produto WHERE id = ?";
        VendaModel retorno = new VendaModel();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, produto.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retorno.setId(rs.getInt(1));
                retorno.setDescricao(rs.getString(instrucao));
            }
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }
    }
    
    public boolean inserir(VendaModel venda) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "INSERT INTO venda (descricao) VALUES (?)";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setString(1, venda.getDescricao());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
           return retorno; 
        }
    }
    
    public boolean atualizar(VendaModel venda) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "UPDATE venda SET descricao = ? WHERE id = ?";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);            
            ps.setString(1, venda.getDescricao());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }
    }
    
    public boolean excluir(VendaModel venda) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "DELETE FROM venda WHERE id = ?";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, venda.getId());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }       
    }     
    
    public int ultimaVenda() {
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT max(id) id FROM venda";       
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch(Exception ex) {
            System.err.println(ex);          
        } finally {
            conexao.encerrar(con);
            return id;
        }                
    }
    
}
