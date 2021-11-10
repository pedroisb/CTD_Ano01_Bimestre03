import java.util.HashMap;
import java.util.Map;

public class RoupaFactory {

    public static final Map<String, Map<String, Roupa>> LISTA_ROUPAS = new HashMap<>();

    public static Roupa fabricarRoupa(String tamanho, String tipo, boolean nova, boolean importada) {

        Roupa roupa = new Roupa(tamanho, tipo, nova, importada);

        if (!LISTA_ROUPAS.containsKey(tipo)){
            Map<String, Roupa> modelo = new HashMap<>();
            modelo.put(tamanho, roupa);
            LISTA_ROUPAS.put(tipo, modelo);
        } else {
            if(!LISTA_ROUPAS.get(tipo).containsKey(tamanho)){
                LISTA_ROUPAS.get(tipo).put(tamanho, roupa);
            }
        }
        return roupa;
    }

    public static void obterTamanho(){
        System.out.println("O tamanho da fábrica é: "+LISTA_ROUPAS.size()+".");
    }

    public static void listarTamanho(String tipo){
        System.out.println(LISTA_ROUPAS.get(tipo).keySet());
        System.out.println(LISTA_ROUPAS.get(tipo).toString());
    }

}
