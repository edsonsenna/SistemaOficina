/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Funcionario;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 13151000162
 */
public class FuncionarioDAO {
     public void cadastrar(Funcionario funcionario){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into funcionario(idFuncionario, nomeFuncionario, sexoFuncionario, cpfFuncionario, endFuncionario, emailFuncionario, "
                    + "setorFuncionario, salFuncionario, telFuncionario) values (null, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            sql.setString(1,funcionario.getNome());
            sql.setString(2,funcionario.getSexo());
            sql.setString(3,funcionario.getCpf());
            sql.setString(4,funcionario.getEnd());
            sql.setString(5,funcionario.getEmail());
            sql.setString(6,funcionario.getSetor());
            sql.setDouble(7,funcionario.getSalario());
            sql.setString(8,funcionario.getTel());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
    public ArrayList consultar(String param){
        PreparedStatement sql; 
        ArrayList funcionarios = new ArrayList();
        try{
                sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
                ("SELECT * FROM funcionario where nomeFuncionario like '%"+param+"%' ");
                //sql.setString(1, param);
                ResultSet rs = sql.executeQuery();
                while(rs.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCod(rs.getInt("idFuncionario"));
                    funcionario.setNome(rs.getString("nomeFuncionario"));
                    funcionario.setSexo(rs.getString("sexoFuncionario"));
                    funcionario.setCpf(rs.getString("cpfFuncionario"));
                    funcionario.setEnd(rs.getString("endFuncionario"));
                    funcionario.setEmail(rs.getString("emailFuncionario"));
                    funcionario.setSalario(rs.getDouble("salFuncionario"));
                    funcionario.setSetor(rs.getString("setorFuncionario"));
                    funcionario.setTel(rs.getString("telFuncionario"));
                    funcionarios.add(funcionario);
                }// fim do while
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return funcionarios;
    }
    
    public void excluir (Funcionario funcionario){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement 
            ("DELETE from funcionario where idFuncionario=?");
            sql.setInt(1, funcionario.getCod());
            sql.execute();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}

