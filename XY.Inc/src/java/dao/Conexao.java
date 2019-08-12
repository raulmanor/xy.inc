/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
     * Nome: Conexao <br/>
     * Propósito: metodo responsavel por estabelecer a conexao com o banco de dados PostgresSQL <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */

public class Conexao {
    private static final String banco = 
            "jdbc:postgresql://localhost:5432/xy.Inc";
    /**
     * O atributo driver representa a classe do Driver JDBC que será usada na 
     * conexão. Quando se utiliza outros bancos usa-se a classe apropriada a 
     * cada banco
     */
    private static final String driver = 
            "org.postgresql.Driver";
    /**
     * Os atributos usuario e senha representam usuario e senha do 
     * SGBD a ser usado na conexão
     */
    private static final String usuario = "postgres";
    private static final String senha = "123";  
    /**
     * O atributo con representa um objeto que 
     * contém a conexão com o banco de dados em si
     */
    private static Connection con = null;
    
    /**
     * Metodo que retorna uma conexão com o banco de dados
     * @return objeto java.sql.Connection
     */
    public static Connection getConexao(){
        // primeiro testo se o objeto con não foi inicializado
        if (con == null){
            try {
                // defino a classe do driver a ser usado
                Class.forName(driver);
                // criação da conexão com o BD
                con = 
                DriverManager.getConnection(
                        banco, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "+
                        ex.getMessage());
            }
        }
        System.out.println("Conexao executada com sucesso");
        
        return con;
    }
   /**
     * Nome: PrepareStatment <br/>
     * Propósito: metodo responsavel por preparar querry SQL<br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */
    public static PreparedStatement getPreparedStatement(String sql){
        // testo se a conexão já foi criada
        if (con == null){
            // cria a conexão
            con = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+
                    e.getMessage());
        }
        return null;
    }
    
}
