import classes.Serie;
import comparators.ComparatorNomeGeneroTempoEp;

import java.util.*;

public class AulaSet {

    public static void testes() {
        /*Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        System.out.println(notas);

        System.out.println(notas.contains(5d));

        System.out.println(Collections.min(notas));

        System.out.println(Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println(soma/notas.size());

        notas.remove(0d);
        System.out.println(notas);

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7d)
                iterator1.remove();
        }
        System.out.println(notas);

        /*Exibir na ordem em que foi inserido*/
        /*Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        /*Exibir em ordem crescente*/
        /*Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        notas.clear();
        System.out.println(notas.isEmpty());*/

        /*Exemplo de Ordenação*/
        System.out.println("--\tOrdem Aleatória\t--");
        Set<Serie> series = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie : series){
            System.out.println(serie.getNome() + " - "+ serie.getGenero()+ " - " + serie.getTempoEp());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Set<Serie> series1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie : series1){
            System.out.println(serie.getNome() + " - "+ serie.getGenero()+ " - " + serie.getTempoEp());
        }

        System.out.println("--\tOrdem Natural (TempoEp)\t--");
        Set<Serie> series3 = new TreeSet<>(series1);
        System.out.println(series3);

        System.out.println("--\tOrdem Nome/Genero/TempoEp\t--");
        Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroTempoEp());
        series4.addAll(series3);
        System.out.println(series4);



    }
}
