import org.bson.Document;

public class Cliente {
    String NomCli;
    String DirCli;
    String TelfCli;
    String EmailCli;
    String CICli;

    public Cliente() {}

    public Cliente(String nomCli, String dirCli, String telfCli, String emailCli, String CICli) {
        NomCli = nomCli;
        DirCli = dirCli;
        TelfCli = telfCli;
        EmailCli = emailCli;
        this.CICli = CICli;
    }

    public String getNomCli() {
        return NomCli;
    }

    public void setNomCli(String nomCli) {
        NomCli = nomCli;
    }

    public String getDirCli() {
        return DirCli;
    }

    public void setDirCli(String dirCli) {
        DirCli = dirCli;
    }

    public String getTelfCli() {
        return TelfCli;
    }

    public void setTelfCli(String telfCli) {
        TelfCli = telfCli;
    }

    public String getEmailCli() {
        return EmailCli;
    }

    public void setEmailCli(String emailCli) {
        EmailCli = emailCli;
    }

    public String getCICli() {
        return CICli;
    }

    public void setCICli(String CICli) {
        this.CICli = CICli;
    }

    public Document toDocument(){
        return new Document("Nombre",NomCli)
                .append("Direccion",DirCli)
                .append("Telefono",TelfCli)
                .append("Email",EmailCli)
                .append("Cedula",CICli)
                ;
    }
}
