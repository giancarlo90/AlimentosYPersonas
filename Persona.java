import java.util.ArrayList;

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
    private ArrayList<Comida> listaComida; //Lista para guardar los alimentos ingeridos

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
        listaComida = new ArrayList<>(); //inicializada el ArrayList
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
            listaComida.add(comida);
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

    /**
     * Metodo para poder preguntarle cosas a la persona basandonos en si ha llegado, 
     * o no, al maximo de su indice basal
     */
    public String contestar(String pregunta)
    {
        String aDevolver = null; //Variable que utilizaremos para devolver la respuesta
        //Comprueba si se ha llegado al limite de calorias en funcion del indice basal o si incluye el nombre en la pregunta
        if(caloriasIngeridas <= metabolismoBasal()  && !pregunta.toLowerCase().contains(nombre.toLowerCase())){
            //Calcula si el numero de caracteres de la pregunta es divisible entre 3
            if(pregunta.length() % 3 == 0){
                aDevolver = "SI";
            }
            else{
                aDevolver = "NO";
            }
        }
        else{
            aDevolver = pregunta.toUpperCase();
            System.out.println(aDevolver);
        }
        return aDevolver;
    }

    /**
     * Metodo que calcula el alimento con mas calorias ingerido hasta el momento
     */
    public String getAlimentoMasCaloricoConsumido()
    {
        String alimentoMasCalorico = null; //Variable donde guardaremos la comida mas calorica
        //Bucle que busca la comida mas calorica y la imprime por pantalla
        if(listaComida.size()>0) {
            int caloriasMaximas = 0;
            for(int i=0; i < listaComida.size(); i++) {
                if(listaComida.get(i).getCalorias() >= caloriasMaximas){
                    alimentoMasCalorico = listaComida.get(i).getNombreComida();
                    caloriasMaximas = listaComida.get(i).getCalorias();
                }
            }
            System.out.println(alimentoMasCalorico);
        }
        return alimentoMasCalorico;
    }
}
