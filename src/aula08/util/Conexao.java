/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula08.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wander
 */

public class Conexao {    
    
    public Connection conectar() {
        
        try {
            System.out.println("Carregando Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            String cs = "jdbc:mysql://localhost:3306/empresa";
            String user = "root";
            String pass = "root";
            System.out.println("Conexão realizada com Sucesso");
            return DriverManager.getConnection(cs, user, pass);
        } catch(Exception ex) {            
            System.err.println("Erro ao conectar no banco");
        }
        return null;
    }
    
    public void encerrar(Connection con) {
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
