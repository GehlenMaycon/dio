import edu.estruturaDados.classe.*;
import edu.estruturaDados.classe.arvoreBinaria.ArvoreBinaria;
import edu.estruturaDados.classe.arvoreBinaria.model.Obj;

public class Main {

    public static void main(String[] args) {
        testarArvoreBinaria();
    }

    public static void testarArvoreBinaria(){
        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        minhaArvore.inserir(new Obj(13));
        minhaArvore.inserir(new Obj(10));
        minhaArvore.inserir(new Obj(25));
        minhaArvore.inserir(new Obj(2));
        minhaArvore.inserir(new Obj(12));
        minhaArvore.inserir(new Obj(20));
        minhaArvore.inserir(new Obj(31));
        minhaArvore.inserir(new Obj(29));
        minhaArvore.inserir(new Obj(1));

        minhaArvore.exibirInOrdem();
        minhaArvore.exibirPreOrdem();
        minhaArvore.exibirPosOrdem();

        minhaArvore.remover(new Obj(20));

        minhaArvore.exibirInOrdem();

    }

    public static void testarListaCircular(){
        ListaCircular<String> minhaLista = new ListaCircular<>();
        minhaLista.add("p4");
        minhaLista.add("p3");
        minhaLista.add("p2");
        minhaLista.add("p1");

        System.out.println(minhaLista);

        minhaLista.remove(3);

        System.out.println(minhaLista);
        System.out.println(minhaLista.get(2));
        System.out.println(minhaLista.get(4));

        for(int i = 0; i <20; i++){
            System.out.println(minhaLista.get(i));
        }
    }

    public static void testarListaDuplamenteEncadeada(){
        ListaDuplamenteEncadeada<String> minhaLista = new ListaDuplamenteEncadeada<>();
        minhaLista.add("1");
        minhaLista.add("2");
        minhaLista.add("3");
        minhaLista.add("4");

        System.out.println(minhaLista);

        minhaLista.remove(2);

        System.out.println(minhaLista);

        minhaLista.add("5", 3);

        System.out.println(minhaLista);

        minhaLista.add("6");

        System.out.println(minhaLista);

        minhaLista.add("3", 2);

        System.out.println(minhaLista);
        System.out.println(minhaLista.get(4));

    }

    public static void testarListaEncadeada(){
        ListaEncadeada<String> minhaLista = new ListaEncadeada<>();
        minhaLista.add("Primeiro");
        minhaLista.add("Segundo");
        minhaLista.add("Terceiro");
        minhaLista.add("Quarto");
        minhaLista.add("Quinto");

        System.out.println(minhaLista.get(0));
        System.out.println(minhaLista.get(1));
        System.out.println(minhaLista.get(2));
        System.out.println(minhaLista.get(3));

        System.out.println(minhaLista);

        System.out.println(minhaLista.remove(3));

        System.out.println(minhaLista);


    }

    public static void testarFila(){
        Fila<Integer> minhaFila = new Fila<>();
        minhaFila.enqueue(1);
        minhaFila.enqueue(2);
        minhaFila.enqueue(3);
        minhaFila.enqueue(4);
        minhaFila.enqueue(5);

        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
    }

    public static void testarPilha(){
        Pilha minhaPilha = new Pilha();
        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        System.out.println(minhaPilha);

        System.out.println(minhaPilha.pop());

        System.out.println(minhaPilha);
    }

}
