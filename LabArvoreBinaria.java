import java.util.Scanner;

public class LabArvoreBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArvoreBinaria arvore = new ArvoreBinaria();

        while (sc.hasNext()) {
            String metodo = sc.next();
            selectMetodo(metodo, sc, arvore);
        }
    }

    public static void selectMetodo(String metodo, Scanner sc, ArvoreBinaria arvore){
        if(metodo.equals("I")){
            int x = sc.nextInt();
            arvore.inserir(x);
        }
        else if(metodo.equals("P")){
            int x = sc.nextInt();
            if (arvore.pesquisar(x)) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
        }
        else if(metodo.equals("PRE")){
            arvore.caminharPre();
        }
        else if(metodo.equals("POS")){
            arvore.caminharPos();
        }
        else if(metodo.equals("EM")){
            arvore.caminharEm();
        }
    }
}

class No {
    public int elemento;
    public No esq, dir;

    public No(int elemento) { // Construtor
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
}

class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() { // Construtor
        raiz = null;
    }

    public void inserir(int x) {
        raiz = inserirRec(raiz, x);
    }

    public No inserirRec(No i, int x) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserirRec(i.esq, x);
        } else if (x > i.elemento) {
            i.dir = inserirRec(i.dir, x);
        }
        return i;
    }

    public boolean pesquisar(int x) {
        return pesquisarRec(raiz, x);
    }

    public boolean pesquisarRec(No i, int x) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (x == i.elemento) {
            resp = true;
            System.out.print(i.elemento + " ");
        } else if (x < i.elemento) {
            System.out.print(i.elemento + " ");
            resp = pesquisarRec(i.esq, x);
        } else {
            System.out.print(i.elemento + " ");
            resp = pesquisarRec(i.dir, x);
        }
        return resp;
    }

    public void caminharPre() {
        caminharPreRec(raiz);
        System.out.println();
    }

    public void caminharPreRec(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPreRec(i.esq);
            caminharPreRec(i.dir);
        }
    }

    public void caminharPos() {
        caminharPosRec(raiz);
        System.out.println();
    }

    public void caminharPosRec(No i) {
        if (i != null) {
            caminharPosRec(i.esq);
            caminharPosRec(i.dir);
            System.out.print(i.elemento + " ");
        }
    }

    public void caminharEm() {
        if(raiz == null){
            System.out.print("V");
            System.out.println();
        }
        else{
            caminharEmRec(raiz);
            System.out.println();
        }
    }

    public void caminharEmRec(No i) {
        if (i != null) {
            caminharEmRec(i.esq);
            System.out.print(i.elemento + " ");
            caminharEmRec(i.dir);
        }
    }
}