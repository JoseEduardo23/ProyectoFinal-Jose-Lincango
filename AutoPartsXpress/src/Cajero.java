import org.bson.Document;

public class Cajero extends Main {
    String UsuarioCaj;
    String ContraseniaCaj;

    public Cajero() {}

    public Cajero(String usuarioCaj, String contraseniaCaj) {
        UsuarioCaj = usuarioCaj;
        ContraseniaCaj = contraseniaCaj;
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
    @Override
    public Document toDocument(){
        return new Document("Usuario",UsuarioCaj).append("Contrasenia",ContraseniaCaj);
    }
}
