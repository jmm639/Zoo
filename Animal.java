package _07POO_Zoo;

import java.util.Random;

/*
    Nombre de clase: Animal
    Tipo de clase..: Abstracta
    Hereda de......: Nadie. Es clase base para que hereden de ella todos los demás animales
*/

public abstract class Animal {
    // ***************************************
    // Atributos que tendrán todas las clases hijas
    // ***************************************
    private String nombre;
    private int edad;
    private float peso;
    private boolean esHembra; //hembra->true varón->false
    private float kilosComidaSemanales;
    private String cuidador;


    // ***************************************
    // Constructores
    // ***************************************
    public Animal() {
        Random rnd = new Random();

        this.nombre = nombreAnimal();
        this.edad = rnd.nextInt(0, 30);
        this.peso = rnd.nextFloat(0, 90);
        this.esHembra = rnd.nextBoolean();
        this.kilosComidaSemanales = rnd.nextFloat(15, 45);
        this.cuidador = nombreCuidador();
    }

    public Animal(String nombre, int edad, float peso, boolean esHembra, float kilosComidaSemanales, String cuidador) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.esHembra = esHembra;
        this.kilosComidaSemanales = kilosComidaSemanales;
        this.cuidador = cuidador;
    }


    // ***************************************
    // Setters
    // ***************************************
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEsHembra(boolean esHembra) {
        this.esHembra = esHembra;
    }

    public void setCuidador(String cuidador) {
        this.cuidador = cuidador;
    }

    public void setKilosComidaSemanales(float kilosComidaSemanales) {
        this.kilosComidaSemanales = kilosComidaSemanales;
    }


    // ***************************************
    // Getters
    // ***************************************
    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public float getPeso() {
        return this.peso;
    }

    public boolean getEsHembra() {
        return this.esHembra;
    }

    public String getCuidador() {
        return this.cuidador;
    }

    public float getKilosComidaSemanales() {
        return this.kilosComidaSemanales;
    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método abstracto hay que implementarlo en cada uno de los hijos
    public abstract String comer();

    // Este método puede ser estático porque no influye su ejecución entre
    // diferentes instancias de esta clase. Además es de uso interno, sólo
    // se usa desde dentro de esta clase
    private static String nombreAnimal() {
        // Usaré este objeto para generar valores
        Random rnd = new Random();

        // Array con nombres para rellenar datos aleatorios
        final String[] nombres = {"Mico", "Noa", "Chispa", "Nina", "Rayo", "Toby", "Chiqui", "Rocky", "Plutón", "Thor", "Chico", "Simba", "Bruno", "Lola", "Nico", "Coco", "Bimba", "Linda", "Max"};

        return (nombres[rnd.nextInt(0,nombres.length)]);
    }

    // Este método puede ser estático porque no influye su ejecución entre
    // diferentes instancias de esta clase. Además es de uso interno, sólo
    // se usa desde dentro de esta clase
    private static String nombreCuidador() {
        // Usaré este objeto para generar valores
        Random rnd = new Random();

        // Array con nombres para rellenar datos aleatorios
        final String[] nombres_cuidadores = {"Juan", "Pedro", "Manuel", "Sonia", "Ana"};

        return (nombres_cuidadores[rnd.nextInt(0,nombres_cuidadores.length)]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Genero la salida
        // En vez de acceder al atributo directamente, uso el getter
        // asociado. Se puede hacer de ambas formas, en otras clases lo
        // haré de otro modo
        sb.append("Nombre.........: ").append(this.getNombre()).append("\n");
        sb.append("Edad...........: ").append(this.getEdad()).append("\n");
        sb.append("Peso...........: ").append(this.getPeso()).append("\n");
        sb.append("Hembra.........: ").append(this.getEsHembra()).append("\n");
        sb.append("Kilos..........: ").append(this.getKilosComidaSemanales()).append("\n");
        sb.append("Cuidador.......: ").append(this.getCuidador()).append("\n");
        sb.append("Comer..........: ").append(this.comer()).append("\n");
        sb.append("---------------- ").append("\n");

        // Devuelvo el resultado
        return sb.toString();
    }
}
