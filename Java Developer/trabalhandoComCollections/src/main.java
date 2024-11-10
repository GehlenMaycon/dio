import classes.Contato;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        /*System.out.println("--\tOrdem Aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jhon", 2222));
        }};
        for(Map.Entry<Integer, Contato> entry : agenda.entrySet()){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jhon", 2222));
        }};
        for(Map.Entry<Integer, Contato> entry : agenda1.entrySet()){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        for(Map.Entry<Integer, Contato> entry : agenda2.entrySet()){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Número telefone\t--");*/
        /*Set<Map.Entry<Integer, Contato>> setAgenda = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return c1.getValue().getNumero().compareTo(c2.getValue().getNumero());
            }
        });*/
        /*Set<Map.Entry<Integer, Contato>> setAgenda = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/
        //Set<Map.Entry<Integer, Contato>> setAgenda = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        /*Set<Map.Entry<Integer, Contato>> setAgenda = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        setAgenda.addAll(agenda2.entrySet());
        for(Map.Entry<Integer, Contato> entry : setAgenda){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + " - " + entry.getValue().getNome());
        }*/
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6","5");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("--\tPrimeiros 5 numeros para dentro de um Set\t--");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("--\tTransformar em uma lista de números inteiros\t--");
        List<Integer> numerosAleatoriosInt = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .toList();
        System.out.println(numerosAleatoriosInt);

        System.out.println("--\tPegar números pares maiores que dois e colocar em uma lista\t--");
        List<Integer> numerosParesMaiorQueDois = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .toList();
        System.out.println(numerosParesMaiorQueDois);

        System.out.println("--\tMostrar a média dos números:\t--");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("--\tRemover números ímpares\t--");
        List<Integer> numerosSemImpar = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0)
                .toList();
        System.out.println(numerosSemImpar);

    }
}
