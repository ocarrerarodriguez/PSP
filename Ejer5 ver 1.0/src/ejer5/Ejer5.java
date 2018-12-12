/*
 Escribe unha clase que cree dous fíos e force que a escritura do segundo sexa sempre anterior á 
escritura por pantalla do primeiro.
Exemplo de ejecución:
Ola,son o fío número 2
Ola, son o fío número 1
a)faino con join
b)faino con prioridade
 */
package ejer5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lacuatoris
 */
public class Ejer5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo1 = new hilo5("1Pepe",10);
        Thread hilo2 = new hilo5("2Juan",10);
        Thread hilo3 = new hilo5("3Oscar",10);
        Thread hilo4 = new hilo5("4Ramiro",10);
        try {
        hilo2.start();
        hilo2.join();
        hilo1.start();
        hilo1.join();
        hilo3.setPriority(1);
        hilo4.setPriority(10);
        hilo3.start();
        hilo4.start();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejer5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
