/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoagenda;

/**
 *
 * @author Usuário
 */
public class Contatos {

    public Contatos(String indice, String nome, String endereco, String email, String telres, String telcom) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telres = telres;
        this.telcom = telcom;
        this.indice = indice;
    }

    private final String nome, endereco, email, telres, telcom, indice;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelres() {
        return telres;
    }

    public String getTelcom() {
        return telcom;
    }

    public String getIndice() {
        return indice;
    }
}
