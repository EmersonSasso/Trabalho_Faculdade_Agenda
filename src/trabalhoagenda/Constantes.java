/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoagenda;

/**
 *
 * @author MDA
 */
public class Constantes {

    private final static String version = "Agenda 1.0", pass = "eC2vgJPvHou43n6P_RoriGtY_VtkJvUU", user = "yubdrxpi", driver = "org.postgresql.Driver", host = "stampy.db.elephantsql.com", servico = "yubdrxpi", portNumber = "5432";
    private static boolean conectou = false;

    public static String getVersion() {
        return version;
    }

    public static String getHost() {
        return host;
    }

    public static String getServico() {
        return servico;
    }

    public static String getPortNumber() {
        return portNumber;
    }

    public static String getPass() {
        return pass;
    }

    public static String getUser() {
        return user;
    }

    public static boolean isConectou() {
        return conectou;
    }

    public static void setConectou(boolean aConectou) {
        conectou = aConectou;
    }

    public static String getDriver() {
        return driver;
    }

}
