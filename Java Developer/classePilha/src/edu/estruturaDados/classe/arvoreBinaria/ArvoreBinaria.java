package edu.estruturaDados.classe.arvoreBinaria;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNo<T> noRaiz;

    public ArvoreBinaria(){
        this.noRaiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        this.noRaiz = inserir(noRaiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if(atual == null){
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        }else{
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }



    public void exibirInOrdem(){
        System.out.println("\n Exibindo inOrdem");
        exibirInOrdem(this.noRaiz);
    }

    private void exibirInOrdem(BinNo<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.noRaiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.noRaiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if(atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void remover(T conteudo){
        try{
            BinNo<T> atual = this.noRaiz;
            BinNo<T> noPai = null;
            BinNo<T> noFilho = null;
            BinNo<T> noTemp = null;

            while(atual != null && !atual.getConteudo().equals(conteudo)){
                noPai = atual;
                if(conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                }else{
                    atual = atual.getNoDir();
                }
            }
            if(atual == null){
                System.out.println(conteudo.toString() + " não encontrado (Bloco try)");
            }

            if(noPai == null){
                if(atual.getNoDir() == null){
                    this.noRaiz = atual.getNoEsq();
                }else if(atual.getNoEsq() == null){
                    this.noRaiz = atual.getNoDir();
                }else {
                    for(noTemp = atual, noFilho = atual.getNoEsq();
                        noFilho.getNoDir() != null;
                        noTemp = noFilho, noFilho = noFilho.getNoEsq()
                    ){
                        if(noFilho != atual.getNoEsq()){
                            noTemp.setNoDir(noFilho.getNoEsq());
                            noFilho.setNoEsq(noRaiz.getNoEsq());
                        }
                        noFilho.setNoDir(noRaiz.getNoDir());
                        noRaiz = noFilho;
                    }
                }
            }else if(atual.getNoDir() == null){
                if(noPai.getNoEsq() == atual){
                    noPai.setNoEsq(atual.getNoEsq());
                }else{
                    noPai.setNoDir(atual.getNoEsq());
                }
            }else if(atual.getNoEsq() == null){
                if(noPai.getNoEsq() == atual){
                    noPai.setNoEsq(atual.getNoDir());
                }else{
                    noPai.setNoDir(atual.getNoDir());
                }
            }else{
                for(
                        noTemp = atual, noFilho = atual.getNoEsq();
                        noFilho.getNoDir() != null;
                        noTemp = noFilho, noFilho = noFilho.getNoDir()
                ){
                    if(noFilho != atual.getNoEsq()){
                        noTemp.setNoDir(noFilho.getNoEsq());
                        noFilho.setNoEsq(atual.getNoEsq());
                    }
                    noFilho.setNoDir(atual.getNoDir());
                    if(noPai.getNoEsq() == atual){
                        noPai.setNoEsq(noFilho);
                    }else{
                        noPai.setNoDir(noFilho);
                    }
                }
            }

        }catch(NullPointerException e){
            System.out.println(conteudo.toString() + " não encontrado!");
        }
    }
}
