package grafos;


import grafos.No;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
            if(i==this.vetor.size()){
                i=-1;
                break;
                
            }
                
        }
       
        return i;

    }

    public void addAresta(char inicio, char fim) {

        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if(indexInicio == -1 || indexFim == -1)
            return;
        this.vetor.get(indexInicio).addNoEmAdj(this.vetor.get(indexFim));
    
    
    
    }

    void exibeListaAdj() {

        for (No no : this.vetor) {
            no.exibeLinhaDaLista();
        }

    }

}
