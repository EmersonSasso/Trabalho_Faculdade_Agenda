package trabalhoagenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConDB {

    private Connection c;
    private ResultSet rs;

    private boolean connect() {
        if (!Constantes.isConectou()) {
            try {
                Class.forName(Constantes.getDriver());
                this.c = DriverManager.getConnection("jdbc:postgresql://" + Constantes.getHost() + ":" + Constantes.getPortNumber()
                        + "/" + Constantes.getServico(), Constantes.getUser(), Constantes.getPass());
                Constantes.setConectou(true);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Dados para conexao incorretos!");
                Constantes.setConectou(false);
            }
        }
        return Constantes.isConectou();
    }

    private boolean disconnect() {
        try {
            Class.forName(Constantes.getDriver());
            this.c = DriverManager.getConnection("jdbc:postgresql://" + Constantes.getHost() + ":" + Constantes.getPortNumber()
                    + "/" + Constantes.getServico(), Constantes.getUser(), Constantes.getPass());

            this.c.close();
            this.c.close();
            Constantes.setConectou(this.c.isClosed());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problema inesperado ao desconectar do banco, procure o programador!");
            Constantes.setConectou(false);
        }
        return Constantes.isConectou();
    }

    private ResultSet executar(String query) {
        if (connect()) {
            Statement st;
            try {
                st = this.c.createStatement();
                ResultSet rs = st.executeQuery(query);
                return rs;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Problema inesperado ao realizar consulta, procure o programador!");
            }
        }
        return null;
    }

    private void inserir(String query) {
        //  int result = -1;
        if (connect()) {
            Statement st;
            try {
                c.setAutoCommit(false);
                st = this.c.createStatement();
                st.executeUpdate(query);
                c.commit();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Problema inesperado ao realizar inserção, procure o programador!");
            }
        }
        // return result;
    }

    public void Inserir(String slv_sql) {
        inserir(slv_sql);
    }

    public ResultSet Executar(String slv_sql) {
        return executar(slv_sql);
    }

    public boolean Disconnect() {
        return disconnect();
    }

}
