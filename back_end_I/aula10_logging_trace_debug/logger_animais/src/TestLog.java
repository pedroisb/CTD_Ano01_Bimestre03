import org.apache.log4j.Logger;

public class TestLog {

    private static final Logger logger = Logger.getLogger(TestLog.class);

    public static void main(String[] args) {

        Tigre tigrao = new Tigre("Tigrão", 12);
        Tigre tchutchuca = new Tigre("Tchutchuca", -4);

        logger.info(tigrao.correr());
        logger.info(tchutchuca.correr());

        try {
            tigrao.verificarAtributos();
            tchutchuca.verificarAtributos();
        } catch (Exception e) {
            logger.error("A idade não pode ser negativa", e);
        }
    }
}
