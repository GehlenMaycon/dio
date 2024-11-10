import exercicioCinco.ExercicioIOData;
import exercicioDois.ExDoisIO;
import exercicioQuatro.ExercioIOBytes;
import exercicioSeis.ExercicioIOObject;
import exercicioTres.ExTresIO;
import exercicioUm.IOCaracter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            //String arquivo = ExercicioIOObject.serializacao();

            ExercicioIOObject.deserializacao("IOObjectOutput/gato");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}