
/**
 * Write a description of class Comida here.
 * 
 * @author (Gian Carlo) 
 * @version (2018/02/23)
 */
public class Comida
{
    // instance variables
    private String nombreComida;
    private int calorias;

    /**
     * Constructor de objetos de la clase Comida
     */
    public Comida(String nombreComida, int calorias)
    {
        // initialise instance variables
        this.nombreComida = nombreComida;
        this.calorias = calorias;
    }

    /**
     * Metodo que devuelve el nombre de la comida
     * 
     */
    public String getNombreComida()
    {
        return nombreComida;
    }
    
    /**
     * Metodo que devuelve el numero de calorias de la comida
     */
    public int getCalorias()
    {
        return calorias; 
    }
}
