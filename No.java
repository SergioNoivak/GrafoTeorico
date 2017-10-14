package grafos;


import java.util.LinkedList;
import java.util.List;

public class No {

    public List<No> Adj;
    public char nomeDoEstado;
    public int cor;

    public No(char nomeDoEstado) {
        this.Adj = new LinkedList<>();
        this.nomeDoEstado = nomeDoEstado;
        this.cor = 0;
    }

    public void addNoEmAdj(No no) {

        this.Adj.add(no);

    }

    void exibeLinhaDaLista() {

        System.out.printf("%c | ", this.nomeDoEstado);
        for (No no : this.Adj) {

            System.out.printf("%c -> ", no.nomeDoEstado);
        }
        System.out.printf("null\n");
    }

}
