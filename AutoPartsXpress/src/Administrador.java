public class Administrador {
    String UsuarioAdm = "AutopartesLuis1245/";
    String ContraseñaAdm = "UserAuto19072024";

    public Administrador() {}

    public Administrador(String usuarioAdm, String contraseñaAdm) {
        UsuarioAdm = usuarioAdm;
        ContraseñaAdm = contraseñaAdm;
    }

    public String getUsuarioAdm() {
        return UsuarioAdm;
    }

    public void setUsuarioAdm(String usuarioAdm) {
        UsuarioAdm = usuarioAdm;
    }

    public String getContraseñaAdm() {
        return ContraseñaAdm;
    }

    public void setContraseñaAdm(String contraseñaAdm) {
        ContraseñaAdm = contraseñaAdm;
    }
}
