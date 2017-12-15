/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereader;

/**
 *
 * @author david.ambros
 */
public class Contatto {
	private String nome, cognome, numero, email;
	
	public Contatto(String nome,String cognome,String numero, String email){
			this.nome=nome;
			this.cognome=cognome;
			this.numero=numero;
			this.email=email;
	}
	public Contatto(){
			
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contatto:" + "nome:" + nome + ", cognome:" + cognome + ", numero:" + numero +", email" + email;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNumero() {
		return numero;
	}
	
	
	
}
