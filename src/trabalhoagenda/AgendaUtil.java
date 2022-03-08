/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoagenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuário
 */
public abstract class AgendaUtil {

    public String ValidaEmail(String Email) throws Exception {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Email);
        if (matcher.matches()) {
            return Email;
        } else {
            throw new Exception();
        }
    }

    public String ValidaTelefone(String DDD, String Telefone, int tipo) throws NumberFormatException {

        Integer.parseInt(DDD);
        if (DDD.length() != 2) {
            throw new NumberFormatException();
        };
        Integer.parseInt(Telefone);
        if (!(Telefone.length() == 9 || Telefone.length() == 8)) {
            throw new NumberFormatException();
        };
        return DDD + "#" + Telefone;
    }

}
