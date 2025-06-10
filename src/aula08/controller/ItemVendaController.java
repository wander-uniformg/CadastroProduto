/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.controller;

import aula08.model.ItemVendaModel;
import aula08.util.Conexao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author wander
 */
public class ItemVendaController {
    
    public List<ItemVendaModel> listar() {
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM item_venda";
        List<ItemVendaModel> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
                ItemVendaModel itemVenda = new ItemVendaModel();
                itemVenda.setId(rs.getInt(1));
                itemVenda.setIdProduto(rs.getInt(2));
                itemVenda.setIdVenda(rs.getInt(3));
                itemVenda.setQuantidade(rs.getInt(4));
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
    
    public ItemVendaModel selecionar(ItemVendaModel itemVenda) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "SELECT * FROM item_venda WHERE idVenda = ?";
        ItemVendaModel retorno = new ItemVendaModel();
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, itemVenda.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                itemVenda.setId(rs.getInt(1));
                itemVenda.setIdProduto(rs.getInt(2));
                itemVenda.setIdVenda(rs.getInt(3));
                itemVenda.setQuantidade(rs.getInt(4));
            }
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            conexao.encerrar(con);
            return retorno;
        }
    }
    
    public boolean inserir(ItemVendaModel itemVenda) {
        
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        String instrucao = "INSERT INTO item_venda (idProduto, idVenda, quantidade) VALUES (?, ?, ?)";
        boolean retorno = false;
        try {
            PreparedStatement ps = con.prepareStatement(instrucao);
            ps.setInt(1, itemVenda.getIdProduto());
            ps.setInt(2, itemVenda.getIdVenda());
            ps.setInt(3, itemVenda.getQuantidade());
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
