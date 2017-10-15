package grafos;

import java.util.LinkedList;
import java.util.List;

public class No {

    public List<No> Adj;
    public char nomeDoEstado;
    public int cor;
    public No antecessor;

    public No(char nomeDoEstado) {
        this.Adj = new LinkedList<>();
        this.nomeDoEstado = nomeDoEstado;
        this.cor = 0;
        this.antecessor=null;
    }

    public void addNoEmAdj(No no) {

        this.Adj.add(no);

    }

    void exibeLinhaDaLista() {
        switch (this.cor) {
            case 0:
                System.out.printf("b | ");
                break;
            case 1:
                System.out.printf("c | ");
                break;
            case 2:
                System.out.printf("p | ");
                break;
            default:
                System.out.printf("e | ");
                break;
        }
        System.out.printf("%c | ", this.nomeDoEstado);
        for (No no : this.Adj) {

            System.out.printf("%c -> ", no.nomeDoEstado);
        }
        System.out.printf("null\n");
    }
    
   
    
}
