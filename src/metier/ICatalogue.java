package metier;

import java.util.List;

public interface ICatalogue {
    public List<Clients> clientByKeyword(String kw);
    public void addClient(Clients c);
}
