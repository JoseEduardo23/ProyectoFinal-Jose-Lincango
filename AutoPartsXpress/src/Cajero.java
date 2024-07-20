import org.bson.Document;

import java.time.Instant;

public class Cajero extends Main {
    String UsuarioCaj;
    String ContraseniaCaj;
    String CedulaCaj;
    String NombreCaj;
    String ApellidoCaj;
    String EdadCaj;
    String CorreoCaj;
    String RolCaj;
    String IngresoCaj;
    String timestamp;

    public Cajero(String ciinText, String text, String apelINText, String edadINText, String correoINText, String rolINText, String fechINText) {}

    public Cajero(String usuarioCaj, String contraseniaCaj, String cedulaCaj, String nombreCaj, String apellidoCaj, String edadCaj, String correoCaj, String rolCaj, String ingresoCaj) {
        UsuarioCaj = usuarioCaj;
        ContraseniaCaj = contraseniaCaj;
        CedulaCaj = cedulaCaj;
        NombreCaj = nombreCaj;
        ApellidoCaj = apellidoCaj;
        EdadCaj = edadCaj;
        CorreoCaj = correoCaj;
        RolCaj = rolCaj;
        IngresoCaj = ingresoCaj;
        timestamp = Instant.now().toString();
    }

    public String getUsuarioCaj() {
        return UsuarioCaj;
    }

    public void setUsuarioCaj(String usuarioCaj) {
        UsuarioCaj = usuarioCaj;
    }

    public String getContraseniaCaj() {
        return ContraseniaCaj;
    }

    public void setContraseniaCaj(String contraseniaCaj) {
        ContraseniaCaj = contraseniaCaj;
    }

    public String getCedulaCaj() {
        return CedulaCaj;
    }

    public void setCedulaCaj(String cedulaCaj) {
        CedulaCaj = cedulaCaj;
    }

    public String getNombreCaj() {
        return NombreCaj;
    }

    public void setNombreCaj(String nombreCaj) {
        NombreCaj = nombreCaj;
    }

    public String getApellidoCaj() {
        return ApellidoCaj;
    }

    public void setApellidoCaj(String apellidoCaj) {
        ApellidoCaj = apellidoCaj;
    }

    public String getEdadCaj() {
        return EdadCaj;
    }

    public void setEdadCaj(String edadCaj) {
        EdadCaj = edadCaj;
    }

    public String getCorreoCaj() {
        return CorreoCaj;
    }

    public void setCorreoCaj(String correoCaj) {
        CorreoCaj = correoCaj;
    }

    public String getRolCaj() {
        return RolCaj;
    }

    public void setRolCaj(String rolCaj) {
        RolCaj = rolCaj;
    }

    public String getIngresoCaj() {
        return IngresoCaj;
    }

    public void setIngresoCaj(String ingresoCaj) {
        IngresoCaj = ingresoCaj;
    }

    @Override
    public Document toDocument(){
        return new Document("Usuario",UsuarioCaj)
                .append("Contrasenia",ContraseniaCaj)
                .append("Cedula",CedulaCaj)
                .append("Nombre",NombreCaj)
                .append("Apellido",ApellidoCaj)
                .append("Edad",EdadCaj)
                .append("Correo",CorreoCaj)
                .append("Rol",RolCaj)
                .append("Ingreso",IngresoCaj)
                .append("Timestamp", timestamp);
    }
}
