package _07POO_Zoo;

import java.util.Random;

/*
    Nombre de clase: Elefante
    Tipo de clase..: Regular
    Hereda de......: Animal
 */

public class Elefante extends Animal {
    // ***************************************
    // Atributos propios de la clase
    // ***************************************
    private int longitudTrompa;
    private int criasActualmenteASuCargo;


    // ***************************************
    // Constructores
    // ***************************************
    public Elefante() {
        // primero se invoca al constructor de la clase padre,
        // luego actualizo los atributos propios
        super();

        // Usaré este objeto para generar valores
        Random rnd = new Random();

        this.longitudTrompa = rnd.nextInt(0, 60);
        this.criasActualmenteASuCargo = rnd.nextInt(0, 5);
    }

    public Elefante(String nombre, int edad, float peso, boolean esHembra, float kilosComidaSemanales, String cuidador,
                    int longitudTrompa, int criasActualmenteASuCargo) {
        // primero se invoca al constructor de la clase padre,
        // pasando los atributos comunes y luego actualizo los
        // atributos propios
        super(nombre, edad, peso, esHembra, kilosComidaSemanales, cuidador);
        this.longitudTrompa = longitudTrompa;
        this.criasActualmenteASuCargo = criasActualmenteASuCargo;
    }


    // ***************************************
    // Setters
    // ***************************************
    public void setLongitudTrompa(int longitudTrompa) {
        this.longitudTrompa = longitudTrompa;
    }

    public void setCriasActualmenteASuCargo(int criasActualmenteASuCargo) {
        this.criasActualmenteASuCargo = criasActualmenteASuCargo;
    }


    // ***************************************
    // Getters
    // ***************************************
    public int getLongitudTrompa() {
        return this.longitudTrompa;
    }

    public int getCriasActualmenteASuCargo() {
        return this.criasActualmenteASuCargo;
    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método abstracto lo redefino para cada clase hija
    public String comer() {
       return ("Soy un " + this.getClass().getSimpleName() + " comiendo como en la sabana...");
    };

    // Redefinición de toString
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Partimos de la clase base heredada
        sb.append(super.toString());

        // Añado los valores propios
        // Aquí uso las variables directamente en vez de los getters
        sb.append("Longitud trompa: ").append(this.getLongitudTrompa()).append("\n");
        sb.append("Crias a cargo..: ").append(this.getCriasActualmenteASuCargo()).append("\n");

        return sb.toString();
    }
}
