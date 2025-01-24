package _07POO_Zoo;

import java.util.Random;

/*
    Nombre de clase: Mono
    Tipo de clase..: Regular
    Hereda de......: Animal
 */

public class Mono extends Animal {
    // ***************************************
    // Atributos propios de la clase
    // ***************************************
    private String tipo;


    // ***************************************
    // Constructores
    // ***************************************
    public Mono() {
        // primero se invoca al constructor de la clase padre, luego actualizo
        // los atributos propios
        super();

        // Usaré este objeto para generar valores
        Random rnd = new Random();

        this.tipo = tipoMono();
    }

    public Mono(String nombre, int edad, float peso, boolean esHembra, float kilosComidaSemanales, String cuidador,
                String tipo) {
        // primero se invoca al constructor de la clase padre,
        // luego actualizo los atributos propios
        super(nombre, edad, peso, esHembra, kilosComidaSemanales, cuidador);

        this.tipo = tipo;
    }


    // ***************************************
    // Setters
    // ***************************************
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    // ***************************************
    // Getters
    // ***************************************
    public String getTipo() {
        return this.tipo;
    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método abstracto lo redefino para cada clase hija
    public String comer() {
        return ("Soy un " + this.getClass().getSimpleName() + " comiendo como en la selva...");
    };

    // Este método puede ser estático porque no influye su ejecución entre
    // diferentes instancias de esta clase. Además es de uso interno, sólo
    // se usa desde dentro de esta clase
    private static String tipoMono() {
        // Usaré este objeto para generar valores
        Random rnd = new Random();

        // Array con nombres para rellenar datos aleatorios
        final String[] tipos_mono = {"Chimpancé", "Gorila", "Mandril", "Orangután"};

        return (tipos_mono[rnd.nextInt(0,tipos_mono.length)]);
    }

    // Redefinición de toString
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Partimos de la clase base
        sb.append(super.toString());

        // Añado los valores propios
        // En vez de llamar a "tipo" o "this.tipo"
        // llamo a this.getTipo(). Cualquiera de
        // todas ellas es correcta.
        sb.append("Tipo...........: ").append(this.getTipo()).append("\n");

        return sb.toString();
    }
}
