package grafos;

import grafos.No;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Grafo {

    public List<No> vetor;
    public int numeroEstados;

    public Grafo() {

        this.vetor = new ArrayList<>();
        numeroEstados = 0;
    }

    public void addVetorRepresentacao(char c) {
        numeroEstados++;
        this.vetor.add(new No(c));
    }

    int retornaDoVetor(char nomeDoEstado) {

        boolean achouNoVetor = false;
        int i = 0;
        while (!achouNoVetor) {
            if (this.vetor.get(i).nomeDoEstado == nomeDoEstado) {
                achouNoVetor = true;
            } else {
                i++;
            }
            if (i == this.vetor.size()) {
                i = -1;
                break;
            }
        }

        return i;

    }

    boolean InicioFimValidos(char inicio, char fim) {
        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if (indexInicio == -1 || indexInicio == -1) {
            return false;
        }
        return true;

    }

    public void exibeDistancia(char inicio, char fim) {

        StringBuilder str = BuscaEmLargura(inicio, fim);
        if (str == null) {
            System.out.println("Caminho impossivel");
            return;

        }
        System.out.println("Caminho: "+str);
    }

    protected StringBuilder BuscaEmLargura(char inicio, char fim) {

        StringBuilder resultado = new StringBuilder("");

        if (this.vetor == null) {
            return null;
        }

        for (No no : this.vetor) {
            no.cor = 0;
            no.antecessor = null;
        }

        int indexInicio = this.retornaDoVetor(inicio);
        if (indexInicio == -1) {
            return null;
        }
        this.vetor.get(indexInicio).cor = 1;
        Stack<No> Q = new Stack<>();
        Q.push(this.vetor.get(indexInicio));
        No u;
        while (!Q.empty()) {

            u = Q.pop();
            if (u.nomeDoEstado == fim) {
                return new StringBuilder("ja chegou");
            }
            for (No v : u.Adj) {
                if (v.cor == 0) {
                    v.cor = 1;
                    v.antecessor = u;
                    if (v.nomeDoEstado == fim) {

                        while (v.nomeDoEstado != inicio) {

                            resultado.append(v.nomeDoEstado).append(" ");
                            v = v.antecessor;

                        }
                        resultado.append(v.nomeDoEstado).append("");

                        return resultado;
                    }

                    Q.push(v);
                }

            }

            u.cor = 2;
        }
        return null;
    }

    public void addAresta(char inicio, char fim) {

        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if (indexInicio == -1 || indexFim == -1) {
            return;
        }
        this.vetor.get(indexInicio).addNoEmAdj(this.vetor.get(indexFim));
    }

    void exibeListaAdj() {

        for (No no : this.vetor) {
            no.exibeLinhaDaLista();
        }

    }

}
