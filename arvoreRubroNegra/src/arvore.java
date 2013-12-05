public class arvore {
    
    public nodo raiz;
    
    public arvore(){
        this.raiz = null;
    }
    
    public void inserir(String chave,int val){
        if(this.raiz == null){
            this.raiz = new nodo(chave,val,true);
            this.raiz.pai = null;
        }else{
            inserirValor(this.raiz,chave,val);
        }
    }
    
    private void inserirValor(nodo no,String chave,int val){
        if(val < no.valor){
           if(no.esq == null){
               no.esq = new nodo(chave,val,false);
               no.esq.pai = no;
               caso1(no);//               
           }else{
               inserirValor(no.esq,chave,val);
           } 
        }else if(val > no.valor){
            if(no.dir == null){
               no.dir = new nodo(chave,val,false);
               no.dir.pai = no;
               caso1(no);
               System.out.println("inserindo: "+val+" no pai: "+no.valor+" cor do pai: "+no.cor);
           }else{
               inserirValor(no.dir,chave,val);
           }
        }
    }
    
    private nodo getTio(nodo no){
        
        if(no.pai != null && no.pai.pai == null){
            if(no.pai.esq == no){System.out.println("sou filho da direita");
                return no.dir;
            }else{
                return no.esq;
            }
        }else if(no.pai != null && no.pai.pai != null){
            if(no.pai.pai.esq == no.pai){
                return no.pai.pai.dir;
            }else{
                return no.pai.pai.esq;
                
            }
        }else{
            return null;
        }
        
    }
    
    private void caso1(nodo no){
        if(no.pai == null){
            no.cor = true;
        }else{
            caso2(no);
        }
    }
    
    private void caso2(nodo no){
        if(no.pai.cor == true){
        
        }else{
            caso3(no);
        }
    }
    private void caso3(nodo no){
        
        if(getTio(no).cor == false){
            no.pai.cor = true;
            getTio(no).cor = true;
            if(no.pai.pai != null){
                no.pai.pai.cor = false;
                caso1(no.pai.pai);
            } 
        }else{
            caso4(no);
        }
    }
    
    private void caso4(nodo no){
        if(no == no.pai.dir && no.pai == no.pai.pai.esq){
            rotacionaEsq(no.pai);
            no = no.esq;
        }else if(no == no.pai.esq && no.pai == no.pai.pai.dir){
            rotacionaDir(no.pai);
            no = no.dir;
        }
        caso5(no);
    }
    
    private void caso5(nodo no){
        no.pai.cor = true;
        getTio(no).cor = false;
        if(no == no.pai.esq && no.pai ==no.pai.pai.esq){
            rotacionaDir(no.pai.pai);
        }else{
            assert no == no.pai.dir && no.pai == no.pai.pai.dir;
            rotacionaEsq(no.pai.pai);
        }
    }
    
    
    private void rotacionaEsq(nodo no){
        nodo n = no.dir;
        substituiNodo(no, n);
        no.dir = n.esq;
        if(n.esq != null){
            n.esq.pai = no;
        }
        n.esq = no;
        no.pai = n;
    }
    private void rotacionaDir(nodo no){
        nodo n = no.esq;
        substituiNodo(no, n);
        no.esq = n.dir;
        if(n.dir != null){
            n.dir.pai = no;
        }
        n.dir = no;
        no.pai = n;
    }
    
    private void substituiNodo(nodo old,nodo novo){
        if(old.pai == null){
            this.raiz = novo;
        }else{
            if(old == old.pai.esq){
                old.pai.esq = novo;
            }else{
                old.pai.dir = novo;
            }
        }
        if(novo != null){
            novo.pai = old.pai;
        }
    }
    
    public void busca(nodo no,int chave){
        
        if(chave == this.raiz.valor){
            System.out.println("O valor procurado é a raiz.");
        }else{
            if(chave == no.valor){
                System.out.println("Encontrou o valor: "+no.chave+" ;para a chave: "+no.valor);
            }else{
                if(chave > no.valor){
                    busca(no.dir,chave);
                }else if(chave < no.valor){
                    busca(no.esq,chave);
                }
            }
        }
    }
    
     public void caminhaPrefixado(nodo no) {
         if(no != null){
             System.out.print(no.valor+" ");
             caminhaPrefixado(no.esq);
             caminhaPrefixado(no.dir);
             
         }
     }
     public void caminhaPosfixado(nodo no) {
         if(no != null){
             caminhaPosfixado(no.esq);
             caminhaPosfixado(no.dir);
             System.out.print(no.valor + " ");
         }
     }
     public void caminhaOrdenado(nodo no) {
         if(no != null){
             caminhaOrdenado(no.esq);
             System.out.print(no.valor + " ");
             caminhaOrdenado(no.dir);
         }
     }
     
     public nodo removeNo(nodo no,int val){
         
         if(no != null){
             if(val > no.valor){
                 no.dir = removeNo(no.dir, val);
             }else if(val < no.valor){
                 no.esq = removeNo(no.esq, val);
             }else{
                 if(no.dir != null && no.esq != null){
                     no.valor = encontraMin(no.dir).valor;
                     no.dir = removeMin(no.dir);
                 }else{
                     no = (no.esq != null) ? no.esq : no.dir;
                 }
             }
             return no;
         }else{
             return null;
         }
     }
     
     public nodo removeMin(nodo no){
         if(no != null){
             if(no.esq != null){
                 no.esq = removeMin(no.esq);
                 return no;
             }else{
                 return no.dir;
             }
         }
         return null;
     }
     public nodo encontraMin(nodo no){
         if(no != null){
             while(no.esq != null){
                 no = no.esq;
             }
         }
         return no;
     }
     
     private nodo rmCaso1(nodo no){
         return no = null;
     }
     private nodo rmCaso2(nodo no){
         return no = null;
     }
    
}