import java.util.Scanner;

public class Hash{

    public static void main(String[] args){
    
    }
}

class TabelaHashComReserva{
    String[] tabela;
    int m;
    int r;
    int nItensReserva;
    
    public TabelaHashComReserva(int m, int r){
        this.m = m;
        this.r = r;
        tabela = new String[m+r];
        nItensReserva = 0;
    }

    int hash(String chave){
        char c;
        int i = 0;
        int soma = 0;
        while(i < chave.length()){
            c = chave.charAt(i);
            soma = soma + c;
        }
        return soma % m;
    }

    boolean isLivre(int pos){
        boolean resp = false;
        if(tabela[pos] == null){
            resp = true;
        }
        return resp;
    }

    void inserir(String pais)throws Exception{
        int chave = hash(pais);

        if(isLivre(chave)){
            tabela[chave] = pais;
        }
        else{
            if(nItensReserva == r){
                throw new Exception("Area de reserva cheia!");
            }
            for(int i = m; i < m + nItensReserva; i++){
                if(tabela[i] == null){
                    if(tabela[i].equals(pais)){
                       throw new Exception("Duplicado!"); 
                    }
                }
            }
            tabela[m + nItensReserva] = chave;
            nItensReserva ++;
        }
    }
}
