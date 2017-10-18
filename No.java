package grafos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No {

    public HashSet<Aresta> Adj;
    public String nomeDoEstado;
    public int cor;
    public No antecessor;

    public No(String nomeDoEstado) {
        this.Adj = new HashSet<>();
        this.nomeDoEstado = nomeDoEstado;
        this.cor = 0;
        this.antecessor=null;
    }

    public void addNoEmAdj(No no, double custo) {
        Aresta nova = new Aresta(this, no, custo);
        this.Adj.add(nova);
        
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
        System.out.printf("%s | ", this.nomeDoEstado);
        for (Aresta a : this.Adj) {
                System.out.printf("%s -> ",a.fim.nomeDoEstado);
        }
        System.out.printf("null\n");
    }
    
   
    
}
