/*
 * Programa que simule un buzón de correo (recurso compartido),
 * de xeito que se poida leer unha mensaje ou envialo. O buzón soamente pode almacear unha mensaxe,
 * de xeito que para poder escribir débese atopar baleiro e para poder leer debe de estar cheo. 
 * Crear varios fíos lectores e escritores que manexen o buzón de xeito sincronizado.
 */
package ejer7;

/**
 *
 * @author lacuatoris
 */
public class Ejer7 {

   private static Buzon buzon;
    private static Cliente productor1;
    private static Cliente productor2;
    private static Proveedor consumidor1;
    private static Proveedor consumidor2;
    
    public static void main(String[] args) {
        buzon = new Buzon();
        productor1 = new Cliente(buzon,1,"manzana");
        productor2 = new Cliente(buzon,2,"pera");
        consumidor1 = new Proveedor(buzon, 1);
        consumidor2 = new Proveedor(buzon, 2);
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
