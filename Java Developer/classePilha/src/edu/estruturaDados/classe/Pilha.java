package edu.estruturaDados.classe;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No refAux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setNoRef(refAux);
    }

    public No pop() {
        if(this.isEmpty()){
            return null;
        }
        No noPopped = refNoEntradaPilha;
        refNoEntradaPilha = refNoEntradaPilha.getNoRef();
        return noPopped;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        return this.refNoEntradaPilha == null;
    }

    @Override
    public String toString() {
        String stringRetorno = "------------------\n";
        stringRetorno += "      Pilha\n";
        stringRetorno += "------------------\n";

        No noAux = refNoEntradaPilha;
        while (true){
            if(noAux != null){
                stringRetorno += "[No{dado="+noAux.getDado()+"}]\n";
                noAux = noAux.getNoRef();
            }else
                break;
        }

        stringRetorno += "------------------\n";
        return stringRetorno;
    }
}
