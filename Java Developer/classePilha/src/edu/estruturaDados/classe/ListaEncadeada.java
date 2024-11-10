package edu.estruturaDados.classe;

public class ListaEncadeada<T> {

    private No<T> noReferencia;

    public ListaEncadeada() {
        this.noReferencia = null;
    }

    public void add(T dado){
        No<T> novoNo = new No<>(dado);
        if(this.isEmpty()) {
            noReferencia = novoNo;
            return;
        }

        No<T> noAux = noReferencia;
        for (int i = 0; i < this.size() -1; i++){
            noAux = noAux.getNoRef();
        }
        noAux.setNoRef(novoNo);
    }

    public T remove(int index){
        validaIndice(index);
        No<T> noAux = getNo(index);
        if(index == 0){
            noReferencia = noAux.getNoRef();
            return noAux.getDado();
        }

        No<T> noAnterior = getNo(index-1);
        noAnterior.setNoRef(noAux.getNoRef());
        return noAux.getDado();
    }

    public T get(int index){
        return getNo(index).getDado();
    }

    private No<T> getNo(int pos){
        validaIndice(pos);
        No<T> noAux = noReferencia;
        No<T> noReturn = null;

        for (int i = 0; i <= pos; i++){
            noReturn = noAux;
            noAux = noAux.getNoRef();
        }
        return noReturn;
    }

    public boolean isEmpty(){
        return noReferencia == null;
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = noReferencia;
        while(true){
            if(referenciaAux == null)
                break;
            tamanhoLista++;
            if(referenciaAux.getNoRef() != null)
                referenciaAux = referenciaAux.getNoRef();
            else
                break;
        }

        return tamanhoLista;
    }

    @Override
    public String toString(){
        String strRetorno = "";
        No<T> noAux = noReferencia;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo="+ noAux.getDado() + "}] --->";
            noAux = noAux.getNoRef();
        }
        strRetorno += "null";
        return strRetorno;
    }

    private void validaIndice(int index){
        if(index >= size())
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice "+index);
    }
}
