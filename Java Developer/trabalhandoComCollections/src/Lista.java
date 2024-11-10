import classes.Gato;
import comparators.ComparatorCor;
import comparators.ComparatorIdade;
import comparators.ComparatorNomeCorIdade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {

    public static void atvList() {
        /*List<Double> notas = new ArrayList<>();
        notas.add(1d);
        notas.add(2d);
        notas.add(3d);
        notas.add(4d);
        notas.add(5d);
        notas.add(6d);
        notas.add(7d);

        System.out.println(notas);

        System.out.println(notas.indexOf(5d));
        notas.add(4, 8d);
        System.out.println(notas);
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);
        System.out.println(notas.contains(5d));
        System.out.println(notas);
        System.out.println(notas.get(2));
        System.out.println(Collections.min(notas));
        System.out.println(Collections.max(notas));
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);
        Double media = soma/notas.size();
        System.out.println(media);
        notas.remove(0d);
        notas.remove(0);
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            if(iterator1.next() < 7d)
                iterator1.remove();
        }
        System.out.println(notas);
        notas.clear();
        System.out.println(notas);
        System.out.println(notas.isEmpty());
        */

        /* Exemplo de Ordenação Listas*/
        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};
        /*Ordem de Inserção*/
        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(gatos);

        /*Ordem Aleatória*/
        System.out.println("--\tOrdem Aleatória\t--");
        Collections.shuffle(gatos);
        System.out.println(gatos);

        /*Ordem Natural*/
        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem Idade\t--");
        Collections.sort(gatos, new ComparatorIdade());
        System.out.println(gatos);

        System.out.println("--\tOrdem Cor\t--");
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t--");
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos);



    }

}







