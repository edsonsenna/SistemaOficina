/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Orcamento;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 13151000162
 */
public class OrcamentoDAO {
     public void cadastrar(Orcamento orcamento){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into orcamento(idOrcamento, codCliente, codFuncionario, valorOrcamento, dataCadastro, descOrcamento) values (?, ?, ?, ?, ?, ?)");
            sql.setInt(1,orcamento.getCod());
            sql.setInt(2,orcamento.getCodCliente());
            sql.setInt(3,orcamento.getCodFuncionario());
            sql.setDouble(4,orcamento.getValor());
            sql.setString(5,orcamento.getDataCadastro());
            sql.setString(6,orcamento.getDescricao());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
    public ArrayList consultar(){
    PreparedStatement sql; 
    ArrayList orcamentos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM orcamento");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Orcamento orcamento = new Orcamento();
            orcamento.setCod(rs.getInt("codCliente"));
            orcamento.setCodFuncionario(rs.getInt("codFuncionario"));
            orcamento.setDataCadastro(rs.getString("dataCadastro"));
            orcamento.setDescricao(rs.getString("descOrcamento"));
            orcamento.setCodCliente(rs.getInt("nomeCliente"));
            orcamento.setValor(rs.getDouble("valorOrcamento"));
            orcamentos.add(orcamento);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return orcamentos;
    }
    
     public ArrayList consultarC(String nomeCliente){
    PreparedStatement sql; 
    ArrayList orcamentos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM orcamento, cliente WHERE codCliente = cliente.idCliente AND cliente.nomeCliente like '%"+nomeCliente+"%';");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Orcamento orcamento = new Orcamento();
            orcamento.setCod(rs.getInt("idOrcamento"));
            orcamento.setCodCliente(rs.getInt("codCliente"));
            orcamento.setCodFuncionario(rs.getInt("codFuncionario"));
            orcamento.setDataCadastro(rs.getString("dataCadastro"));
            orcamento.setDescricao(rs.getString("descOrcamento"));
            orcamento.setValor(rs.getDouble("valorOrcamento"));
            orcamentos.add(orcamento);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return orcamentos;
    }
     
      public ArrayList consultarF(String nomeFuncionario){
    PreparedStatement sql; 
    ArrayList orcamentos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM orcamento, funcionario WHERE codFuncionario = funcionario.idFuncionario AND funcionario.nomeFuncionario like '%"+nomeFuncionario+"%';");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Orcamento orcamento = new Orcamento();
            orcamento.setCod(rs.getInt("idOrcamento"));
            orcamento.setCodFuncionario(rs.getInt("codFuncionario"));
            orcamento.setDataCadastro(rs.getString("dataCadastro"));
            orcamento.setDescricao(rs.getString("descOrcamento"));
            orcamento.setCodCliente(rs.getInt("codCliente"));
            orcamento.setValor(rs.getDouble("valorOrcamento"));
            orcamentos.add(orcamento);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return orcamentos;
    }
    
       public void alterar(Orcamento orcamento){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("update orcamento set codCliente=?, codFuncionario=?, valorOrcamento=?, dataCadastro=?, descOrcamento=? where idOrcamento=?"); 
            sql.setInt(1,orcamento.getCodCliente());
            sql.setInt(2,orcamento.getCodFuncionario());
            sql.setDouble(3,orcamento.getValor());
            sql.setString(4,orcamento.getDataCadastro());
            sql.setString(5,orcamento.getDescricao());
            sql.setInt(6, orcamento.getCod());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    public void excluir (Orcamento orcamento){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement 
            ("DELETE from orcamento where idOrcamento=?");
            sql.setInt(1, orcamento.getCod());
            sql.execute();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}