package br.edu.unicid.bean;

public class Produto {

	private int codigo;
	private int quantidade;
	private String nome;
	private String descricao;

	public Produto(int codigo, int quantidade, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto() {
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", quantidade=" + quantidade + ", nome=" + nome + ", descricao="
				+ descricao + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}