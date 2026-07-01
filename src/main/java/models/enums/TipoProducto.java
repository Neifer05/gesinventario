package models.enums;

public enum TipoProducto {
    TECNOLOGIA("Tecnología"),
    HERRAMIENTA("Herramientas"),
    MUEBLE("Muebles"),
    UTENSILIO("Utensilios"),
    PERSONAL("Personales");

    private final String tituloTipoProducto;

    TipoProducto(String tituloTipoProducto) {
        this.tituloTipoProducto = tituloTipoProducto;
    }
    public String getTituloTipoProducto() {
        return tituloTipoProducto;
    }
}