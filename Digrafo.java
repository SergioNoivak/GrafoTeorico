

package grafos;

import java.util.ArrayList;

public class Digrafo extends Grafo {

    public Digrafo() {

        super.vetor = new ArrayList<>();
        numeroEstados = 0;
    }
    @Override
    public void addAresta(char inicio, char fim) {

        int indexInicio = this.retornaDoVetor(inicio);
        int indexFim = this.retornaDoVetor(fim);
        if (indexInicio == -1 || indexFim == -1) {
            return;
        }
        this.vetor.get(indexInicio).addNoEmAdj(this.vetor.get(indexFim));
        this.vetor.get(indexFim).addNoEmAdj(this.vetor.get(indexInicio));

    }
    
}
