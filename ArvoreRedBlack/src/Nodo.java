
public class Nodo {
    
    public String chave;
    public int valor;
    public Nodo esq, dir,pai;
    public int n;
    boolean cor; //Preto = TRUE | Vermelho = FALSE
    
    
    public Nodo(String chave,int valor,boolean cor){
        this.chave                  =   chave;
        this.valor                  =   valor; 
        this.cor                    =   cor; 
    }
    
    
}
