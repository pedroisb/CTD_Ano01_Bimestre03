import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> FLORESTA = new HashMap<>();

    public Arvore plantarArvore(int altura, int largura, String cor){
        String chave = "key: "+altura+":"+largura+":"+cor;
        System.out.println(chave);

        if (!FLORESTA.containsKey(chave)) {
            FLORESTA.put(chave, new Arvore(altura, largura, cor));
            System.out.println("Plantio realizado");

            return FLORESTA.get(chave);
        }
        System.out.println("Muda já plantada");
        return FLORESTA.get(chave);
    }
}
