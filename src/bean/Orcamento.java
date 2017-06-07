package bean;

public class Orcamento {
	private int codCliente;
	private int codFuncionario;
	private double valor;
	private int cod;
	private String dataCadastro;
	private String descricao;
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
	
	
}
