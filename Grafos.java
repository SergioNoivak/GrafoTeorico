/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author sergi
 */
public class Grafos {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.addVetorRepresentacao("1");
        g.addVetorRepresentacao("2");
        g.addVetorRepresentacao("3");
        g.addVetorRepresentacao("4");
        g.addVetorRepresentacao("5");
        g.addVetorRepresentacao("6");

        g.addAresta("1", "2",0.0);
        g.addAresta("1", "2",0.0);
        g.addAresta("1", "4",0.0);
        g.addAresta("2", "5",0.0);
        g.addAresta("3", "6",0.0);
        g.addAresta("6", "6",0.0);
        g.addAresta("3", "5",0.0);
        g.addAresta("5", "4",0.0);
        g.addAresta("4", "2",0.0);
        g.exibeListaAdj();
        g.exibeDistancia("3", "4");
    }
}
