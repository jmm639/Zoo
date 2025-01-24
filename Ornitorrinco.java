package _07POO_Zoo;

import java.util.Random;

/*
    Nombre de clase: Ornitorrinco
    Tipo de clase..: Regular
    Hereda de......: Animal
 */

public class Ornitorrinco extends Animal {
    // ***************************************
    // Atributos propios de la clase
    // ***************************************
    private boolean tienePelo;
    private boolean picoRoto;


    // ***************************************
    // Constructores
    // ***************************************
    public Ornitorrinco() {
        // primero se invoca al constructor de la clase padre,
        // luego actualizo los atributos propios
        super();

        // Usaré este objeto para generar valores
        Random rnd = new Random();

        this.tienePelo = rnd.nextBoolean();
        this.picoRoto = rnd.nextBoolean();
    }

    public Ornitorrinco(String nombre, int edad, float peso, boolean esHembra, float kilosComidaSemanales, String cuidador,
                        boolean tienePelo, boolean picoRoto) {
        // primero se invoca al constructor de la clase padre, luego actualizo
        // los atributos propios. Paso los atributos a la clase base
        super(nombre, edad, peso, esHembra, kilosComidaSemanales, cuidador);

        this.tienePelo = tienePelo;
        this.picoRoto = picoRoto;
    }


    // ***************************************
    // Setters
    // ***************************************
    public void setTienePelo(boolean tienePelo) {
        this.tienePelo = tienePelo;
    }

    public void setPicoRoto(boolean picoRoto) {
        this.picoRoto = picoRoto;
    }


    // ***************************************
    // Getters
    // ***************************************
    public boolean getTienePelo() {
        return this.tienePelo;
    }

    public boolean getPicoRoto() {
        return this.picoRoto;
    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método abstracto lo redefino para cada clase hija
    public String comer() {
        return ("Soy un " + this.getClass().getSimpleName() + " comiendo como en la charca...");
    };

    // Redefinición de toString
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Partimos de la clase base
        sb.append(super.toString());

        // Añado los valores propios usando los getters
        sb.append("Tiene pelo.....: ").append(this.getTienePelo()).append("\n");
        sb.append("Pico roto......: ").append(this.getPicoRoto()).append("\n");

        return sb.toString();
    }
}
