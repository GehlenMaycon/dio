package edu.estruturaDados.classe;

public class ListaCircular<T> {
    private No<T> noCabeca;
    private No<T> noCauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.noCauda = null;
        this.noCabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(isEmpty()){
            this.noCabeca = novoNo;
            this.noCauda = this.noCabeca;
            this.noCabeca.setNoRef(noCauda);
        }else{
            novoNo.setNoRef(this.noCauda);
            this.noCabeca.setNoRef(novoNo);
            this.noCauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){
        validaIndex(index);
        No<T> noAux = this.noCauda;
        if(index == 0){
            this.noCauda = this.noCauda.getNoRef();
            this.noCabeca.setNoRef(this.noCauda);
        }else if(index == 1){
            this.noCauda.setNoRef(this.noCauda.getNoRef().getNoRef());
        }else{
            for(int i = 0; i < index-1; i++){
                noAux = noAux.getNoRef();
            }
            noAux.setNoRef(noAux.getNoRef().getNoRef());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return getNo(index).getDado();
    }

    private No<T> getNo(int index){
        if(index == 0)
            return noCauda;

        No<T> noAux = noCauda;
        for (int i = 0; i < index; i++){
            noAux = noAux.getNoRef();
        }
        return noAux;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return tamanhoLista;
    }

    @Override
    public String toString(){
        String strRetorno = "";
        No<T> noAux = this.noCauda;
        for(int i =0; i < this.size(); i++){
            strRetorno += "[No{conteudo= "+noAux.getDado()+"}] --->";
            noAux = noAux.getNoRef();
        }
        strRetorno += isEmpty() ? "[]" : "(Retorna ao início)";
        return strRetorno;
    }

    private void validaIndex(int index){
        if (this.size() < index)
            throw new IndexOutOfBoundsException("Índice não existente");
    }

}
