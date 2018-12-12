
package ejer4;

/**
 *
 * @author lacuatoris
 */
public class hijo4 extends Thread
{ 
    String nombre;
    int parametro1;
    int parametro2;
    int parametro3;
    int parametro;
    hijo4(String nome,int parametro)
    {   
        super(nome);
        this.nombre=nome;
        this.parametro1=0;
        this.parametro2=0;
        this.parametro3=0;
        this.parametro=parametro;
        System.out.println("Creado fío:"+nome);
          
    }
    int funcion1(int x)
    {
        if(x%2==0)
        {
            this.parametro1+=x;
        }
        
        return this.parametro1;
    }
    int funcion2(int x)
    {
       if(x%2==1)
        {
            this.parametro2+=x;
        }
       return this.parametro2;
    }
    int funcion3(int x)
    {
        if(x%2==0||x%3==0)
        {
            this.parametro3+=x;
        }
        return this.parametro3;
    }
    public void run()   
    {
        
        for(int i=1;i<this.parametro;i++)
        {
            funcion1(i);
            funcion2(i);
            funcion3(i);
            System.out.println(i+" "+this.nombre+" par : "+this.parametro1+" impar : "+this.parametro2+"multiplo 2/3 : "+this.parametro3);
            
        }
        System.out.println("termina el thread "+this.nombre);
     }
} 