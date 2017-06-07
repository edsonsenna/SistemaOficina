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
            ("insert into produto(idProduto, nomeProduto, valorCompra, valorVenda, qnt, dataCadastro, descricao) values (?, ?, ?, ?, ?, ?, ?)");
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
    
    public ArrayList consultar(){
    PreparedStatement sql; 
    ArrayList produtos = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM produto");
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Produto produto = new Produto();
            produto.setCod(rs.getInt("idCliente"));
            produto.setNome(rs.getString("nomeCliente"));
            produto.setValorCompra(rs.getDouble("valorCompra"));
            produto.setValorVenda(rs.getDouble("valorVenda"));
            produto.setQnt(rs.getInt("qnt"));
            produto.setDataCadastro(rs.getString("dataCadastro"));
            produto.setDescricao(rs.getString("descricao"));
            produtos.add(produto);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return produtos;
    }
}