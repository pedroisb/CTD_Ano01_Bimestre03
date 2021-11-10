import java.util.List;

public class Doc {

    private String id;
    private String url;
    private String conteudo;
    private List<String> usuariosAutorizados;

    public Doc(String id, String url, String conteudo, List<String> usuariosAutorizados) {
        this.id = id;
        this.url = url;
        this.conteudo = conteudo;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<String> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public void setUsuariosAutorizados(List<String> usuariosAutorizados) {
        this.usuariosAutorizados = usuariosAutorizados;
    }
}
