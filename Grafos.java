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
        g.addVetorRepresentacao('k');
        g.addVetorRepresentacao('x');
        g.addAresta('k', 'x');
        g.addAresta('k', 'w');
        g.addAresta('x', 'k');


        g.exibeListaAdj();
        
        
        
    }
    
}
