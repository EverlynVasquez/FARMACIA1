package CapaDatos;

public class Categoria {

    private int idCategoria;
    private String catNombre;

    public Categoria() {
    }

    public Categoria(int idCategoria, String catNombre) {
        this.idCategoria = idCategoria;
        this.catNombre = catNombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

}
