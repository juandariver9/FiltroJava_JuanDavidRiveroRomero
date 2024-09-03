
package Model;


public class Ninja {
    private int ID_Ninja;
    private String Nombre;
    private String Rango;
    private String Aldea;
    
    public Ninja() {}
    
    public Ninja (int ID_Ninja, String Nombre, String Rango, String Aldea){
        this.ID_Ninja = ID_Ninja;
        this.Nombre = Nombre;
        this.Rango = Rango;
        this.Aldea = Aldea;
    }
    public int getID_Ninja() {
        return ID_Ninja;
    }

    public void setId(int ID_Ninja) {
        this.ID_Ninja = ID_Ninja;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getRango() {
        return Rango;
    }

    public void setRango(String Rango) {
        this.Rango = Rango;
    }

    public String getAldea() {
        return Aldea;
    }

    public void setAldea(String Aldea) {
        this.Aldea = Aldea;
    }
}
