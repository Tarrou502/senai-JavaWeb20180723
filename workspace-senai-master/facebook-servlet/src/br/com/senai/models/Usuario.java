package br.com.senai.models;

public class Usuario {
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String senha;
	private String genero;
	private String dataNascimento;
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, String sobrenome, String email, String telefone, String senha, String genero,
			String dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone=" + telefone
				+ ", senha=" + senha + ", genero=" + genero + ", dataNascimento=" + dataNascimento + "]";
	}

}
