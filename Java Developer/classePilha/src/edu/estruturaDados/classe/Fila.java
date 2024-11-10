package edu.estruturaDados.classe;

public class Fila<T> {

    private No<T> refNoEntrada;

    public Fila() {
        this.refNoEntrada = null;
    }

    public void enqueue(T obj){
        No novoNo = new No(obj);
        novoNo.setNoRef(this.refNoEntrada);
        refNoEntrada = novoNo;
    }

    public T dequeue(){
        if(this.isEmpty()){
            return null;
        }
        No<T> primeiroNo = refNoEntrada;
        No<T> noAux = primeiroNo.getNoRef();
        while (true) {
            if(primeiroNo.getNoRef() == null) {
                noAux.setNoRef(null);
                break;
            }else{
                noAux = primeiroNo;
                primeiroNo = primeiroNo.getNoRef();
            }
        }
        return (T) primeiroNo.getDado();
    }

    public T first(){
        if(this.isEmpty()){
            return null;
        }
        No<T> primeiroNo = refNoEntrada;
        while (true) {
            if(primeiroNo.getNoRef() == null)
                break;
            else
                primeiroNo = primeiroNo.getNoRef();
        }
        return (T) primeiroNo.getDado();
    }

    public boolean isEmpty(){
        return refNoEntrada == null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAux = refNoEntrada;
        if(refNoEntrada != null){
            while (true){

                stringRetorno += "[No{objeto="+noAux.getDado()+"}]---->";
                if(noAux.getNoRef() != null)
                    noAux = noAux.getNoRef();
                else {
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            return null;
        }

        return stringRetorno;
    }
}
