import java.io.Serializable;

public class Filme implements Serializable {

    private String nome;
    private String url;

    public Filme(String nome) {
        this.nome = nome;
        this.url = "www."+this.nome.replaceAll("\\s","").toLowerCase()+".com";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                '}'+"\n";
    }
}
