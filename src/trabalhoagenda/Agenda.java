/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoagenda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class Agenda extends AgendaUtil {

    public Agenda(ConDB cdb) {
        this.cdb = cdb;
    }

    private final ConDB cdb;
    private ResultSet rs;
    private int aux;
    private String slv_text;

    public void Incluir(Contatos con) {
        slv_text = "insert into contatos (nome, endereco, email, dddres, telres, dddcom, telcom) values ("
                + "'" + con.getNome().toUpperCase() + "', "
                + "'" + con.getEndereco().toUpperCase() + "', "
                + "'" + con.getEmail().toUpperCase() + "', "
                + con.getTelres().split("#")[0] + ", "
                + con.getTelres().split("#")[1] + ", "
                + con.getTelcom().split("#")[0] + ", "
                + con.getTelcom().split("#")[1] + "  )";
        cdb.Inserir(slv_text);
    }

    public void Excluir(Contatos con) {
        slv_text = "DELETE FROM CONTATOS"
                + " WHERE INDICE = " + con.getIndice();
        cdb.Inserir(slv_text);
    }

    public void Editar(Contatos con) {
        slv_text = "UPDATE CONTATOS"
                + " SET NOME = '" + con.getNome().toUpperCase() + "'"
                + " , ENDERECO = '" + con.getEndereco().toUpperCase() + "'"
                + " , EMAIL = '" + con.getEmail().toUpperCase() + "'"
                + " , DDDRES = " + con.getTelres().split("#")[0]
                + " , TELRES = " + con.getTelres().split("#")[1]
                + " , DDDCOM = " + con.getTelcom().split("#")[0]
                + " , TELCOM = " + con.getTelcom().split("#")[1]
                + " WHERE INDICE = " + con.getIndice();
        cdb.Inserir(slv_text);
    }

    public int Load(String nome, Contato c, int tipo) throws SQLException, Exception {

        if (tipo != 1 && nome != null) {
            aux = Indice(nome, c);
            if (aux != 0) {
                c.doScreen(0);
            }
        } else {
            aux = 0;
        }
        switch (tipo) {
            case 0:
                c.setbSEE("Ok");
                c.setbCancel(false);
                return aux;
            case 1:
                c.setbSEE("Incluir");
                c.setbCancel(true);
                return 1;
            case 2:
                c.setbSEE("Editar");
                c.setbCancel(true);
                return aux;
            default:
                c.setbSEE("Excluir");
                c.setbCancel(true);
                return aux;
        }
    }

    private int Indice(String nome, Contato c) throws SQLException, NumberFormatException, Exception {
        aux = 0;
        ArrayList<Contatos> contatos;
        contatos = new ArrayList<>();
        rs = cdb.Executar("SELECT INDICE, NOME, ENDERECO, EMAIL, DDDRES, TELRES, DDDCOM, TELCOM FROM CONTATOS WHERE NOME LIKE '%" + nome.toUpperCase() + "%' ORDER BY NOME ASC, INDICE ASC");
        if (null != rs) {
            while (rs.next()) {
                aux = rs.getInt(1);
                contatos.add(new Contatos(rs.getString(1), rs.getString(2), rs.getString(3), ValidaEmail(rs.getString(4)), ValidaTelefone(rs.getString(5), rs.getString(6), 0), ValidaTelefone(rs.getString(7), rs.getString(8), 1)));
            }
            c.setContatos(contatos);
        }
        rs.close();
        return aux;
    }
}
