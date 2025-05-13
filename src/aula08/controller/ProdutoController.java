/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.controller;

import aula08.model.ProdutoModel;
import aula08.util.Conexao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author wander
 */
public class ProdutoController {
    
    public List<ProdutoModel> listar() {
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM produto";
        List<ProdutoModel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
                ProdutoModel produto = new ProdutoModel();
                produto.setId(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
                produto.setEstoque(rs.getInt(3));
                produto.setValor(rs.getFloat(4));
                lista.add(produto);
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
    
    public ProdutoModel selecionar(ProdutoModel produto) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM produto WHERE id = ?";
        ProdutoModel retorno = new ProdutoModel();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, produto.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                retorno.setId(rs.getInt(1));
                retorno.setDescricao(rs.getString(2));
                retorno.setEstoque(rs.getInt(3));
                retorno.setValor(rs.getFloat(4));
            }
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }
    }
    
    public boolean inserir(ProdutoModel produto) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "INSERT INTO produto (descricao, estoque, valor) VALUES (?,?,?)";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getEstoque());
            ps.setFloat(3, produto.getValor());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
           return retorno; 
        }
    }
    
    public boolean atualizar(ProdutoModel produto) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "UPDATE produto SET descricao = ?, estoque = ?, valor = ? WHERE id = ?";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);            
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getEstoque());
            ps.setFloat(3, produto.getValor());
            ps.setInt(4, produto.getId());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }
    }
    
    public boolean excluir(ProdutoModel produto) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "DELETE FROM produto WHERE id = ?";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, produto.getId());
            int resultado = ps.executeUpdate();
            retorno = resultado >= 0;
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }       
    }       
    
}
