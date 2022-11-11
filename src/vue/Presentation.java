package vue;

import metier.CatalogueImp;
import metier.Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.System.in;


public class Presentation {
    public static void main(String[] args) throws IOException {


        CatalogueImp metier = new CatalogueImp();

        System.out.print("Veuillez choisir entre ajouter un client et rechercher par clé \n(1 pour l'ajout et 2 pour la recherche) : ");
        saisie(metier);

    }

    public static void saisie(CatalogueImp metier) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String temp = br.readLine();
        int saisie = 0;

        try{
            saisie = Integer.parseInt(temp);
            if (saisie == 1) AddClient(br, metier);
            else if (saisie == 2) {
                List<Clients> clients = ByKeyboard(br, metier);
                for (Clients c: clients) {
                    System.out.println(c.getIdClient() + "\t" +c.getNomClient() + "\t" + c.getPrenomClient());
                }
            }
        } catch (NumberFormatException | IOException e){
            while (!temp.matches("[1-2]")){
                System.out.print("Veuillez tapez que 1 ou 2 : ");
                temp = br.readLine();
            }

        }
    }

    private static void AddClient(BufferedReader br, CatalogueImp metier) throws IOException {
        System.out.println("Ajouter un client ");
        System.out.print("Tapez le nom du client : ");
        String nam   = br.readLine().toUpperCase();

        System.out.print("Tapez le prenom du client : ");
        String firstName = br.readLine().toUpperCase();

        Clients customer = new Clients(nam, firstName);

        metier.addClient(customer);
    }

    private static List<Clients> ByKeyboard(BufferedReader br, CatalogueImp metier) throws IOException {
        System.out.print("Tapez le mot clé : ");
        String kw = br.readLine();
        List<Clients> clients = metier.clientByKeyword(kw);
        return clients;
    }
}

