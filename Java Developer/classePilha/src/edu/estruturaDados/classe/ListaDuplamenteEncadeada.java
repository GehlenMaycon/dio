package edu.estruturaDados.classe;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setNoSeguinte(null);
        novoNo.setNoAnterior(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setNoSeguinte(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(T conteudo, int index){
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        NoDuplo<T> noAuxiliar = getNo(index);
        novoNo.setNoSeguinte(noAuxiliar);

        if(novoNo.getNoSeguinte() != null){
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getNoSeguinte().setNoAnterior(novoNo);
        }else{
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo;
        }else{
            novoNo.getNoAnterior().setNoSeguinte(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int index){
        validaIndex(index);
        if(index == 0){
            primeiroNo = primeiroNo.getNoSeguinte();
            if(primeiroNo != null){
                primeiroNo.setNoAnterior(null);
            }
        }else {
            NoDuplo<T> noAux = getNo(index);
            noAux.getNoAnterior().setNoSeguinte(noAux.getNoSeguinte());
            if(noAux != ultimoNo){
                noAux.getNoSeguinte().setNoAnterior(noAux.getNoAnterior());
            }else {
                ultimoNo = noAux;
            }
        }

        this.tamanhoLista--;

    }

    public int size(){
        return tamanhoLista;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    @Override
    public String toString(){
        NoDuplo<T> noAux = primeiroNo;
        String stringRetorno = "";
        for(int i =0; i < size(); i++){
            stringRetorno += "[No{conteudo: "+ noAux.getConteudo()+"}] --->";
            noAux = noAux.getNoSeguinte();
        }
        stringRetorno += "null";
        return stringRetorno;
    }

    private NoDuplo<T> getNo(int index){
        validaIndex(index);
        NoDuplo<T> noAux = primeiroNo;
        for(int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getNoSeguinte();
        }
        return noAux;
    }

    private void validaIndex(int index) throws IndexOutOfBoundsException{
        if (index > this.size())
            throw new IndexOutOfBoundsException("Indíce fora do limite da lista ["+this.size()+"]");
    }

}
