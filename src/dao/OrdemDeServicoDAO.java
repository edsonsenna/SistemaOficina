/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Orcamento;
import bean.OrdemDeServico;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class OrdemDeServicoDAO {
    public void cadastrar(Orcamento orcamento) throws SQLException{
        PreparedStatement sql;
        int code = 0;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into ordemdeservico(idordemdeservico, codCliente, codFuncionario, valorOS, dataCadastro, descOS, statusOS) values (null, ?, ?, ?, ?, ?, 1)");
            sql.setInt(1,orcamento.getCodCliente());
            sql.setInt(2,orcamento.getCodFuncionario());
            sql.setDouble(3,orcamento.getValor());
            sql.setString(4,orcamento.getDataCadastro());
            sql.setString(5,orcamento.getDescricao());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("select idordemdeservico from ordemdeservico where codCliente="+orcamento.getCodCliente() + 
                    " and codFuncionario="+ orcamento.getCodFuncionario() + " and valorOS="+orcamento.getValor());
        ResultSet rs = sql.executeQuery();
        if(rs.next()){
            code=rs.getInt("idordemdeservico");
        }
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("select * from orcamento_has_produto where orcamento_idOrcamento="+orcamento.getCod());
        rs = sql.executeQuery();
        ArrayList<Integer> listaProdutosCod = new ArrayList();
        while(rs.next()){
            listaProdutosCod.add(rs.getInt("produto_idProduto"));
        }
        for(Integer i: listaProdutosCod){
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into ordemdeservico_has_produto (idOrdemdeservico_Produto, produto_idProduto, ordemdeservico_idordemdeservico) values (null, ?, ?)");
            sql.setInt(1, i);
            sql.setInt(2, code);
            sql.execute();
        }
    }
    public ArrayList consultar(){
    PreparedStatement sql; 
    ArrayList ordemdeservicos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM ordemdeservico");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            OrdemDeServico ordemdeservico = new OrdemDeServico();
            ordemdeservico.setCod(rs.getInt("idordemdeservico"));
            ordemdeservico.setCodFuncionario(rs.getInt("codFuncionario"));
            ordemdeservico.setDataCadastro(rs.getString("dataCadastro"));
            ordemdeservico.setDescricao(rs.getString("descOS"));
            ordemdeservico.setCodCliente(rs.getInt("codCliente"));
            ordemdeservico.setValor(rs.getDouble("valorOS"));
            ordemdeservico.setStatusOS(rs.getBoolean("statusOS"));
            ordemdeservicos.add(ordemdeservico);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return ordemdeservicos;
    }
    public ArrayList consultarC(String nomeCliente){
    PreparedStatement sql; 
    ArrayList ordemdeservicos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM ordemdeservico, cliente WHERE codCliente = cliente.idCliente AND cliente.nomeCliente like '%"+nomeCliente+"%';");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            OrdemDeServico ordemdeservico = new OrdemDeServico();
            ordemdeservico.setCod(rs.getInt("idordemdeservico"));
            ordemdeservico.setCodCliente(rs.getInt("codCliente"));
            ordemdeservico.setCodFuncionario(rs.getInt("codFuncionario"));
            ordemdeservico.setDataCadastro(rs.getString("dataCadastro"));
            ordemdeservico.setDescricao(rs.getString("descOS"));
            ordemdeservico.setValor(rs.getDouble("valorOS"));
            ordemdeservicos.add(ordemdeservico);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return ordemdeservicos;
    }
     
      public ArrayList consultarF(String nomeFuncionario){
    PreparedStatement sql; 
    ArrayList ordemdeservicos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM ordemdeservico, funcionario WHERE codFuncionario = funcionario.idFuncionario AND funcionario.nomeFuncionario like '%"+nomeFuncionario+"%';");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            OrdemDeServico ordemdeservico = new OrdemDeServico();
            ordemdeservico.setCod(rs.getInt("idordemdeservico"));
            ordemdeservico.setCodFuncionario(rs.getInt("codFuncionario"));
            ordemdeservico.setDataCadastro(rs.getString("dataCadastro"));
            ordemdeservico.setDescricao(rs.getString("descOS"));
            ordemdeservico.setCodCliente(rs.getInt("codCliente"));
            ordemdeservico.setValor(rs.getDouble("valorOS"));
            ordemdeservicos.add(ordemdeservico);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return ordemdeservicos;
    }
    public void alterar(OrdemDeServico ordemdeservico){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("update ordemdeservico set codCliente=?, codFuncionario=?, valorOS=?, dataCadastro=?, descOS=? where idordemdeservico=?"); 
            sql.setInt(1,ordemdeservico.getCodCliente());
            sql.setInt(2,ordemdeservico.getCodFuncionario());
            sql.setDouble(3,ordemdeservico.getValor());
            sql.setString(4,ordemdeservico.getDataCadastro());
            sql.setString(5,ordemdeservico.getDescricao());
            sql.setInt(6, ordemdeservico.getCod());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    public void finalizar (OrdemDeServico ordemdeservico){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement 
            ("update ordemdeservico set statusOS=0 where idordemdeservico=?");
            sql.setInt(1, ordemdeservico.getCod());
            sql.execute();
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
