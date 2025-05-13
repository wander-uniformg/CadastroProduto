/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.model;

/**
 *
 * @author wander
 */
public class ProdutoModel {
    
    private int id;
    private String descricao;
    private int estoque;
    private float valor;

    public ProdutoModel() {
    }

    public ProdutoModel(int id, String descricao, int estoque, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.estoque = estoque;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    
}
