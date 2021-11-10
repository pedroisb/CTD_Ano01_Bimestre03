public class Main {
    public static void main(String[] args) {
        ArvoreFactory floresta = new ArvoreFactory();

        for (int i = 0; i < 500000; i++) {
            Arvore ornamental = floresta.plantarArvore(200,400,"verde");
        }

        for (int i = 0; i < 500000; i++) {
            Arvore frutifera = floresta.plantarArvore(500,300,"vermelho");
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: "+(runtime.totalMemory() - runtime.freeMemory() / (1024 * 1024)));

    }
}
