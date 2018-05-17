package model;

/**
 *
 * @author Maleja Gosman
 */
public class Estado {

    private int Id_Estado;
    private String Nom_Estado;

    public Estado(int Id_Estado, String Nom_Estado) {
        this.Id_Estado = Id_Estado;
        this.Nom_Estado = Nom_Estado;
    }

    public int getId_Estado() {
        return Id_Estado;
    }

    public void setId_Estado(int Id_Estado) {
        this.Id_Estado = Id_Estado;
    }

    public String getNom_Estado() {
        return Nom_Estado;
    }

    public void setNom_Estado(String Nom_Estado) {
        this.Nom_Estado = Nom_Estado;
    }

    @Override
    public String toString() {
        return Nom_Estado;
    }

}
