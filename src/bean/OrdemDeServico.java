/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class OrdemDeServico {
    private int codCliente;
    private int codFuncionario;
    private double valor;
    private int cod;
    private boolean statusOS;
    private String dataCadastro;
    private String descricao;
    private ArrayList<Integer> prods;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Integer> getProds() {
        return prods;
    }

    public void setProds(ArrayList<Integer> prods) {
        this.prods = prods;
    }

    public boolean isStatusOS() {
        return statusOS;
    }

    public void setStatusOS(boolean statusOS) {
        this.statusOS = statusOS;
    }
    
    
}
