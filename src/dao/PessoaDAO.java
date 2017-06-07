/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Pessoa;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 13151000162
 */
public class PessoaDAO {
    public void cadastrar(Pessoa pessoa){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into cliente(idCliente, nomeCliente, sexoCliente, cpfCliente, endCliente, emailCliente, telCliente) values (null, ?, ?, ?, ?, ?, ?)");
            
            sql.setString(1,pessoa.getNome());
            sql.setString(2,pessoa.getSexo());
            sql.setString(3,pessoa.getCpf());
            sql.setString(4,pessoa.getEnd());
            sql.setString(5,pessoa.getEmail());
            sql.setString(6,pessoa.getTel());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
    public void alterar(Pessoa pessoa){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("update cliente set nomeCliente=?, sexoCliente=?, cpfCliente=?, endCliente=?, emailCliente=? where idCliente=?"); 
            sql.setString(1,pessoa.getNome());
            sql.setString(2,pessoa.getSexo());
            sql.setString(3,pessoa.getCpf());
            sql.setString(4,pessoa.getEnd());
            sql.setString(5,pessoa.getEmail());
            sql.setInt(6, pessoa.getCod());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
    public ArrayList consultar(String param){
        PreparedStatement sql; 
        ArrayList pessoas = new ArrayList();
        try{
                sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
                ("SELECT * FROM cliente where nomeCliente like '%"+param+"%' ");
                //sql.setString(1, param);
                ResultSet rs = sql.executeQuery();
                while(rs.next()){
                    Pessoa pessoa = new Pessoa();
                    pessoa.setCod(rs.getInt("idCliente"));
                    pessoa.setNome(rs.getString("nomeCliente"));
                    pessoa.setSexo(rs.getString("sexoCliente"));
                    pessoa.setCpf(rs.getString("cpfCliente"));
                    pessoa.setEnd(rs.getString("endCliente"));
                    pessoa.setEmail(rs.getString("emailCliente"));
                    pessoa.setTel(rs.getString("telCliente"));
                    pessoas.add(pessoa);
                }
        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return pessoas;
    }
    
    public ArrayList consultar(Integer param){
        PreparedStatement sql; 
        ArrayList pessoas = new ArrayList();
        try{
                sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
                ("SELECT * FROM cliente where idCliente like '%"+param+"%' ");
                //sql.setString(1, param);
                ResultSet rs = sql.executeQuery();
                while(rs.next()){
                    Pessoa pessoa = new Pessoa();
                    pessoa.setCod(rs.getInt("idCliente"));
                    pessoa.setNome(rs.getString("nomeCliente"));
                    pessoa.setSexo(rs.getString("sexoCliente"));
                    pessoa.setCpf(rs.getString("cpfCliente"));
                    pessoa.setEnd(rs.getString("endCliente"));
                    pessoa.setEmail(rs.getString("emailCliente"));
                    pessoa.setTel(rs.getString("telCliente"));
                    pessoas.add(pessoa);
                }
        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return pessoas;
    }
    
    public void excluir (Pessoa pessoa){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement 
            ("DELETE from cliente where idCliente=?");
            sql.setInt(1, pessoa.getCod());
            sql.execute();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
