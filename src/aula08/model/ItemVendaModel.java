/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.model;

/**
 *
 * @author wander
 */
public class ItemVendaModel {
    
    private int id;
    private int idProduto;
    private int idVenda;
    private int quantidade;

    public ItemVendaModel() {
    }

    public ItemVendaModel(int id, int idProduto, int idVenda, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.idVenda = idVenda;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
