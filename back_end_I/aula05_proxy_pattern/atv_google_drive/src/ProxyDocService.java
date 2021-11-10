import java.util.List;

public class ProxyDocService implements IAcessarDoc{

    private List<Doc> listaDocs;

    public ProxyDocService(List<Doc> listaDocs) {
        this.listaDocs = listaDocs;
    }

    @Override
    public Doc acessarDoc(String url, String email) {
        return listaDocs.stream().filter(doc -> doc.getUrl().equals(url) && doc.getUsuariosAutorizados().contains(email)).findFirst().orElse(null);
    }
}
