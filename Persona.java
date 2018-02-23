
/**
 * Write a description of class Persona here.
 * 
 * @author (Gian Carlo) 
 * @version (2018/02/23)
 */
public class Persona
{
    // instance variables
    private String nombre;
    private boolean hombre; //indica si la persona es un hombre
    private int peso; //expresado en kg
    private int altura; //expresado en cm
    private int edad; //expresado en años
    private int caloriasIngeridas;
    private int calculoBasal;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombre, boolean hombre, int peso, int altura, int edad)
    {
        // initialise instance variables
        this.nombre = nombre;
        this.hombre = hombre;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        metabolismoBasal();
        caloriasIngeridas = 0;
    }

    /**
     * Metodo para dar de comer a la persona.
     * Si la persona ha ingerido menos calorias que las calculadas para su metabolismo
     * basal, el metodo devolvera el numero de calorias ingeridas. En caso de que ya 
     * haya sobrepasado las calorias calculadas para su metabolismo basal, la persona 
     * no comera, y se devolvera -1
     */
    public int comer(Comida comida)
    {
        int caloriasADevolver = comida.getCalorias();
        if(caloriasIngeridas <= metabolismoBasal()){
            caloriasIngeridas += caloriasADevolver;
        }
        else{
            caloriasADevolver = -1;
        }
        return caloriasADevolver;
    }
    
    /**
     * Metodo que permite saber las calorias ingeridas por la persona en ese momento
     */
    public int getCaloriasIngeridas()
    {
        return caloriasIngeridas;
    }

    /**
     * Metodo para calcular el metabolismo basal,
     * calculado según las ecuaciones de Harris-Benedict
     */
    private int metabolismoBasal()
    {
        if(hombre == true){
            calculoBasal = (10 * peso) + (6 * altura) + (5 * edad) + 5;
        }
        else{
            calculoBasal = (10 * peso) + (6 * altura) + (5 * edad) - 161;
        }
        return calculoBasal;
    }
}
