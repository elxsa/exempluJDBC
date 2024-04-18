package ex4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class MainEx4 {
    public static void afisare_tabela(ResultSet rs, String mesaj) {
        System.out.println("\n---"+mesaj+"---");
        try {
            rs.beforeFirst();
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta=" + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void adaugare(ResultSet rs, int id, String nume, int varsta) {
        try {
            rs.moveToInsertRow();
            rs.updateInt("id", id);
            rs.updateString("nume", nume);
            rs.updateInt("varsta",varsta);
            rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void actualizare(ResultSet rs,int id,int varsta){
        boolean modificat=false;
        try {
            rs.beforeFirst();
            while (rs.next())
                if(rs.getInt("id")==id) {
                    rs.updateInt("varsta", varsta);
                    rs.updateRow();
                    modificat=true;
                    break;
                }
            if(modificat)
                System.out.println("\nVarsta persoanei "+rs.getString("nume") +" a fost actualizata cu succes!");
            else
                System.out.println("Nu se gaseste nici o persoana cu id-ul specificat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void stergere(ResultSet rs,int id){
        boolean sters=true;
        try {
            rs.beforeFirst();
            while (rs.next())
                if(rs.getInt("id")==id) {
                    rs.deleteRow();
                    sters=true;
                    break;
                }
            if(sters)
                System.out.println("\nPersoana cu id-ul "+id+" a fost stearsa cu succes!");
            else
                System.out.println("Nu se gaseste nici o persoana cu id-ul specificat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test";
        String sql="select * from persoane";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "pisica");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=statement.executeQuery(sql);
            afisare_tabela(rs,"Continut initial");
            adaugare(rs,4,"Dana",23);
            afisare_tabela(rs,"Dupa adaugare");
            actualizare(rs,4,24);
            afisare_tabela(rs,"Dupa modificare");
            stergere(rs,4);
            afisare_tabela(rs,"Dupa stergere");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


