package grafos;

import grafos.No;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Grafo {

    public List<No> vetor;
    public int numeroEstados;

    public Grafo() {

        this.vetor = new ArrayList<>();
        numeroEstados = 0;
    }

    public void addVetorRepresentacao(String c) {
        numeroEstados++;
        this.vetor.add(new No(c));
    }

    int retornaDoVetor(String nomeDoEstado) {

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

    boolean InicioFimValidos(String inicio, String fim) {
        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if (indexInicio == -1 || indexInicio == -1) {
            return false;
        }
        return true;

    }

    public void exibeDistancia(String inicio, String fim) {

        StringBuilder str = BuscaEmLargura(inicio, fim);
        if (str == null) {
            System.out.println("Caminho impossivel");
            return;

        }
        System.out.println("Caminho: " + str);
    }

    protected StringBuilder BuscaEmLargura(String inicio, String fim) {

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
            for (Aresta v : u.Adj) {
                if (v.fim.cor == 0) {
                    v.fim.cor = 1;
                    v.fim.antecessor = u;
                    if (v.fim.nomeDoEstado == fim) {

                        while (v.fim.nomeDoEstado != inicio) {

                            resultado.append(v.fim.nomeDoEstado).append(" ");
                            v.fim = v.fim.antecessor;

                        }
                        resultado.append(v.fim.nomeDoEstado).append("");

                        return resultado;
                    }

                    Q.push(v.fim);
                }

            }

            u.cor = 2;
        }
        return null;
    }

    public void addAresta(String inicio, String fim, double custo) {

        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if (indexInicio == -1 || indexFim == -1) {
            return;
        }
        this.vetor.get(indexInicio).addNoEmAdj(this.vetor.get(indexFim),custo);
    }

    void exibeListaAdj() {

        for (No no : this.vetor) {
            no.exibeLinhaDaLista();
        }
    }
}
