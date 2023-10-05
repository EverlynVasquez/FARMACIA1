
package CapaDatos;

public class Composicion {
    private int idComposicion;
    private String coNombre;
    private String pSerie;

    public Composicion() {
    }

    public Composicion(int idComposicion, String coNombre, String pSerie) {
        this.idComposicion = idComposicion;
        this.coNombre = coNombre;
        this.pSerie = pSerie;
    }

    public int getIdComposicion() {
        return idComposicion;
    }

    public void setIdComposicion(int idComposicion) {
        this.idComposicion = idComposicion;
    }

    public String getCoNombre() {
        return coNombre;
    }

    public void setCoNombre(String coNombre) {
        this.coNombre = coNombre;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }
    
    
}
