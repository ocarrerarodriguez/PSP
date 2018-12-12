/*
 * Simular a caixa dunha empresa con dous fíos. Un simulará o ingreso, ca compra de
artigos por parte de clientes e o outro a extracción de cartos da 
caixa co pago a proveedores. A conta terá
un capital inicial. Realizar 10 ingresos e 5 extraccións.
 */
package ejer6;

/**
 *
 * @author lacuatoris
 */
public class Ejer6 {

    /**
     * @param args the command line arguments
     */
    private static Conta contenedor;
    private static cliente productor1;
    private static cliente productor2;
    private static proveedor consumidor1;
    private static proveedor consumidor2;
    
    public static void main(String[] args) {
        contenedor = new Conta();
        productor1 = new cliente(contenedor,1);
        productor2 = new cliente(contenedor,2);
        consumidor1 = new proveedor(contenedor, 1);
        consumidor2 = new proveedor(contenedor, 2);
        System.out.println("Productor " + 1 + " activado");
        System.out.println("Productor " + 2 + " activado");
        System.out.println("Consumidor " + 1 + " activado");
	System.out.println("Consumidor " + 2 + " activado");
        new Thread(productor1).start();
        new Thread(productor2).start();
        new Thread(consumidor1).start();
        new Thread(consumidor2).start();
        
        
        
    }
    
}
