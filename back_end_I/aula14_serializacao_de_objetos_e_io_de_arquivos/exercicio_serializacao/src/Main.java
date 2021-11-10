import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //      Steps to Serialize
        //      ---------------------------------------------------------------------------------
        //      1. Object class should implement Serializable interface
        //      2. add import java.io.Serializable
        //      3. FileOutputStream fileOut = new FileOutputStream(file path);
        //      4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
        //      5. out.writeObject(objectName);
        //      6. out.close(); fileOut.close();
        //      ---------------------------------------------------------------------------------


        User userP = new User ("Pedro", "123456");


        //Ao criar, o bloco de código abaixo vai apontar que existem exceções não tratadas. Pode dar um throw para IO ou envolver em bloco de try/catch (ideal)

        FileOutputStream fileOut = new FileOutputStream("userP_info.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(userP);
        out.close();
        fileOut.close();


        //      Steps to Deserialize
        //      ---------------------------------------------------------------------------------
        //      1. Declare your object (don't instantiate)
        //      2. Class should implement Serializable interface
        //      3. add import java.io.Serializable
        //      4. FileInputStream fileIn = new FileInputStream(file path);
        //      5. ObjectInputStream in = new ObjectInputStream(fileIn);
        //      6. objectName = (Class) in.readObject(); (Vamos usar casting com o objeto aqui)
        //      7. in.close(); fileIn.close();
        //      ---------------------------------------------------------------------------------


        //userX será declarado, mas não instanciado. irá receber valores desserializados do arquivo .ser obtido em etapa anterior
        User userX = null;

        FileInputStream fileIn = new FileInputStream("C:\\Users\\Pedro Brito\\Desktop\\CTD\\ano01\\bimestre03\\back_end\\modulo02_testes_unitarios_logging_e_acesso_a_dados\\aula14_serializacao_de_objetos_e_io_de_arquivos\\exercicio_serializacao\\userP_info.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        userX = (User) in.readObject();
        in.close();
        fileIn.close();

        //Demonstrando que a desserialização funcionou
        System.out.println(userX.getName());
        System.out.println(userX.getPassword());


    //      Notes
    //      ---------------------------------------------------------------------------------
    //      1. children classes of a parent class that implements Serializable will do so as well
    //      2. static fields are not serialized (they belong to the class, not an individual object)
    //      3. the class' definition ("class file") itself is not recorded, cast it as the object type -> see line 47
    //      4. fields declared as "transient" aren't serialized, they're ignored
    //      5. serialVersionUID is a unique version ID for a class that is serializable
    //          = serialVersionUID is a unique ID that functions like a version hash;
    //          = Verifies that the sender a and receiver of a serialized object have loaded classes for that object that match;
    //          = Ensures object will be compatible between machines;
    //          = Number must match, otherwise this will cause a InvalidClassException;
    //          = A SerialVersionUID will be calculated based on class properties, members etc;
    //          = A serializable class can declare it's own serialVersionUID explicitly (recommended);
    //      ---------------------------------------------------------------------------------

        //demonstração com o serialVersionUID
    long serialVersionUID = ObjectStreamClass.lookup(userX.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
