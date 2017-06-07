/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Produto;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 13151000162
 */
public class ProdutoDAO {
     public void cadastrar(Produto produto){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("insert into produto(idProduto, nomeProduto, valorCompraProduto, valorVendaProduto, qtdProduto, dataCadastro, descProduto) values (?, ?, ?, ?, ?, ?, ?)");
            sql.setInt(1,produto.getCod());
            sql.setString(2,produto.getNome());
            sql.setDouble(3,produto.getValorCompra());
            sql.setDouble(4,produto.getValorVenda());
            sql.setInt(5,produto.getQnt());
            sql.setString(6,produto.getDataCadastro());
            sql.setString(7,produto.getDescricao());
            sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
    public ArrayList consultarN(String nome){
    PreparedStatement sql; 
    ArrayList produtos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM produto WHERE nomeProduto like '%"+nome+"%' ");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Produto produto = new Produto();
            produto.setCod(rs.getInt("idProduto"));
            produto.setNome(rs.getString("nomeProduto"));
            produto.setValorCompra(rs.getDouble("valorCompraProduto"));
            produto.setValorVenda(rs.getDouble("valorVendaProduto"));
            produto.setQnt(rs.getInt("qtdProduto"));
            produto.setDataCadastro(rs.getString("dataCadastro"));
            produto.setDescricao(rs.getString("descProduto"));
            produtos.add(produto);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return produtos;
    }
    
    public ArrayList consultarC(Integer cod){
    PreparedStatement sql; 
    ArrayList produtos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM produto WHERE idProduto like '%"+cod+"%'");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Produto produto = new Produto();
            produto.setCod(rs.getInt("idProduto"));
            produto.setNome(rs.getString("nomeProduto"));
            produto.setValorCompra(rs.getDouble("valorCompraProduto"));
            produto.setValorVenda(rs.getDouble("valorVendaProduto"));
            produto.setQnt(rs.getInt("qtdProduto"));
            produto.setDataCadastro(rs.getString("dataCadastro"));
            produto.setDescricao(rs.getString("descProduto"));
            produtos.add(produto);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return produtos;
    }
    
    public void excluir (Produto produto){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement 
            ("DELETE from produto where idProduto=?");
            sql.setInt(1, produto.getCod());
            sql.execute();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}