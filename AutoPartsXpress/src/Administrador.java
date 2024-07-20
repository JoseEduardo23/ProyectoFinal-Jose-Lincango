import org.bson.Document;

public class Administrador extends Main {
    String UsuarioAdm;
    String ContraseniaAdm;

    public Administrador() {}

    public Administrador(String usuarioAdm, String contraseniaAdm) {
        UsuarioAdm = usuarioAdm;
        ContraseniaAdm = contraseniaAdm;
    }

    public String getUsuarioAdm() {
        return UsuarioAdm;
    }

    public void setUsuarioAdm(String usuarioAdm) {
        UsuarioAdm = usuarioAdm;
    }

    public String getContraseniaAdm() {
        return ContraseniaAdm;
    }

    public void setContraseniaAdm(String contraseniaAdm) {
        ContraseniaAdm = contraseniaAdm;
    }

    @Override
    public Document toDocument() {
        return new Document("Usuario",UsuarioAdm).append("Contrasenia",ContraseniaAdm);
    }
}
