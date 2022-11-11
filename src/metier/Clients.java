package metier;

public class Clients {
    private int idClient;
    private String nomClient;
    private String prenomClient;

    public Clients() {}

    public Clients(String nomClient, String prenomClient) {
        super();
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {

        return "Client [idClient= " + idClient + ", nomClient=" + nomClient + ", prenomClient=" +prenomClient + "]";
    }
}
