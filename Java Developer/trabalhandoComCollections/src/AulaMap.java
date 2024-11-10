import classes.Livro;
import comparators.ComparatorNomeLivro;
import comparators.ComparatorNroPagina;

import java.util.*;

public class AulaMap {
    public static void testeMap() {
        /*Map<String, Double> carros = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carros);

        carros.put("gol", 15.2);
        System.out.println(carros);

        System.out.println(carros.containsKey("tucson"));

        System.out.println(carros.get("uno"));

        System.out.println(carros.keySet());
        System.out.println(carros.values());

        Double consumoEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entries = carros.entrySet();
        for(Map.Entry<String, Double> entry : entries){
            if(entry.getValue().equals(consumoEficiente)){
                String modeloEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: "+modeloEficiente);
            }
        }

        Double consumoNaoEficiente = Collections.min(carros.values());
        Set<Map.Entry<String, Double>> entries2 = carros.entrySet();
        for(Map.Entry<String, Double> entry : entries){
            if(entry.getValue().equals(consumoNaoEficiente)){
                String modeloNaoEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: "+modeloNaoEficiente);
            }
        }

        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println(soma/carros.size());

        Iterator<Double> iterator1 = carros.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6))
                iterator1.remove();
        }
        System.out.println(carros);

        System.out.println("--\tOrdem que foram informados\t--");
        Map<String,Double> carros1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carros1);

        System.out.println("--\tOrdenando pelo modelo\t--");
        Map<String,Double> carros2 = new TreeMap<>(carros1);
        System.out.println(carros2);

        carros.clear();
        System.out.println(carros.isEmpty());*/

        /*ORDENAÇÃO*/
        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> livros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        Set<Map.Entry<String, Livro>> entries = livros.entrySet();
        for(Map.Entry<String, Livro> entry : entries){
            System.out.println("Autor: " + entry.getKey() + " - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livro> livros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> entry : livros1.entrySet()){
            System.out.println("Autor: " + entry.getKey() + " - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabetica\t--");
        Map<String, Livro> livros2 = new TreeMap<>(livros1);
        for(Map.Entry<String, Livro> entry : livros2.entrySet()){
            System.out.println("Autor: " + entry.getKey() + " - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Alfabetica nome dos livros\t--");
        Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNomeLivro());
        livros3.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> entry : livros3){
            System.out.println("Autor: " + entry.getKey() + " - "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Número de Páginas\t--");
        Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorNroPagina());
        livros4.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> entry : livros4){
            System.out.println("Autor: " + entry.getKey() + " - "+entry.getValue().getNome() + " Nro Pag: "+entry.getValue().getPaginas());
        }



    }
}
