package model;

/**
 *
 * @author Maleja Gosman
 */
public class TipoDoc {

    private int Id_Tipo_Doc;
    private String Nom_Tipo_Doc;

    public TipoDoc(int Id_Tipo_Doc, String Nom_Tipo_Doc) {
        this.Id_Tipo_Doc = Id_Tipo_Doc;
        this.Nom_Tipo_Doc = Nom_Tipo_Doc;
    }

    public int getId_Tipo_Doc() {
        return Id_Tipo_Doc;
    }

    public void setId_Tipo_Doc(int Id_Tipo_Doc) {
        this.Id_Tipo_Doc = Id_Tipo_Doc;
    }

    public String getNom_Tipo_Doc() {
        return Nom_Tipo_Doc;
    }

    public void setNom_Tipo_Doc(String Nom_Tipo_Doc) {
        this.Nom_Tipo_Doc = Nom_Tipo_Doc;
    }

    @Override
    public String toString() {
        return Nom_Tipo_Doc;
    }

}
