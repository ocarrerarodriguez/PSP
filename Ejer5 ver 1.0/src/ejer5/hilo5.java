/*

 */
package ejer5;

/**
 *
 * @author lacuatoris
 */
public class hilo5 extends Thread{
    String nombre;
    int parametro1;
    int parametro2;
    int parametro3;
    int parametro;
    hilo5(String nome,int parametro)
    {   
        super(nome);
        this.nombre=nome;
        this.parametro1=0;
        this.parametro2=0;
        this.parametro3=0;
        this.parametro=parametro;
        System.out.println("Creado fío:"+nome);
          
    }
    
    public void run()   
    {
        
       // for(int i=1;i<this.parametro;i++)
        //{
            
            //System.out.println(i+" "+this.nombre);
            
        //}
        System.out.println("termina el thread "+this.nombre);
     }
    
    
}
