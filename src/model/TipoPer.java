package model;

/**
 *
 * @author Maleja Gosman
 */
public class TipoPer {

    private int Id_Tipo_Persona;
    private String Nom_Tipo_Persona;

    public TipoPer(int Id_Tipo_Persona, String Nom_Tipo_Persona) {
        this.Id_Tipo_Persona = Id_Tipo_Persona;
        this.Nom_Tipo_Persona = Nom_Tipo_Persona;
    }

    public int getId_Tipo_Persona() {
        return Id_Tipo_Persona;
    }

    public void setId_Tipo_Persona(int Id_Tipo_Persona) {
        this.Id_Tipo_Persona = Id_Tipo_Persona;
    }

    public String getNom_Tipo_Persona() {
        return Nom_Tipo_Persona;
    }

    public void setNom_Tipo_Persona(String Nom_Tipo_Persona) {
        this.Nom_Tipo_Persona = Nom_Tipo_Persona;
    }

    @Override
    public String toString() {
        return Nom_Tipo_Persona;
    }
    
    

}
