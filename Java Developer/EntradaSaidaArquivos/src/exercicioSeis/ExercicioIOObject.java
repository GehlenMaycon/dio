package exercicioSeis;

import java.io.*;

public class ExercicioIOObject {
    public static String serializacao() throws IOException {
        Gato gato = new Gato("Simba", "preto", 3, true);

        File file = new File("IOObjectOutput/gato");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getPath()));

        oos.writeObject(gato);
        oos.flush();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso!", file.getName());

        oos.close();
        ps.close();

        return file.getPath();
    }

    public static void deserializacao(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Gato gato = (Gato) ois.readObject();
        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        ps.printf("\nNome:..............: %s", gato.getNome());
        ps.printf("\nIdade:.............: %d", gato.getIdade());
        ps.printf("\nCor:...............: %s", gato.getCor());
        ps.printf("\nCastrado:..........: %s", gato.isCastrado());
        ois.close();
    }
}
