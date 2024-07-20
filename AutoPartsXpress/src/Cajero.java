public class Cajero {
    String UsuarioCaj = "AutopartesCaja01";
    String ContraseñaCaj = "UserCaja0119072024";

    public Cajero() {}

    public Cajero(String usuarioCaj, String contraseñaCaj) {
        UsuarioCaj = usuarioCaj;
        ContraseñaCaj = contraseñaCaj;
    }

    public String getUsuarioCaj() {
        return UsuarioCaj;
    }

    public void setUsuarioCaj(String usuarioCaj) {
        UsuarioCaj = usuarioCaj;
    }

    public String getContraseñaCaj() {
        return ContraseñaCaj;
    }

    public void setContraseñaCaj(String contraseñaCaj) {
        ContraseñaCaj = contraseñaCaj;
    }
}
