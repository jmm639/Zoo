package _07POO_Zoo;


/* NUEVO COMENTARIO PARA CAMBIAR EL ARCHIVO LOCAL Y VER COMO SE CLONA */


/*
    Nombre de clase: Zoo
    Tipo de clase..: Regular
    Hereda de......: Ninguna. Esta clase implementa las estructuras y operaciones
                     que requiere el zoo encapsulando todo lo que tiene que ver con él.
 */

public class Zoo {
    // Me creo un array de animales
    // Al hacer el array de una clase abstracta, utilizo
    // polimorfismo, ya que los animales serán de otras clases y no sabremos
    // de que clases son inicialmente
    private Animal[] animales;


    // ***************************************
    // Constructores
    // ***************************************
    Zoo() {
        this(15);
    }

    Zoo(int tamagno) {
        this.animales = new Animal[tamagno];

        // Inicializo los valores a null para que no haya problemas
        // con el generador de animales
        for (int i = 0; i <= this.animales.length - 1; i++)
            this.animales[i] = null;

        // Genero los animales
        for (int i = 0; i <= this.animales.length - 1; i++)
            switch ((int)(Math.random()*3)) {
                case 0:
                    // Uso el constructor sin parámetros para que
                    // los datos sean aleatorios
                    this.agregarAnimal(new Mono());
                    break;

                case 1:
                    // Uso el constructor sin parámetros para que
                    // los datos sean aleatorios
                    this.agregarAnimal(new Ornitorrinco());
                    break;

                case 2:
                    // Uso el constructor sin parámetros para que
                    // los datos sean aleatorios
                    this.agregarAnimal(new Elefante());
                    break;
            }
    }


    // ***************************************
    // Setters
    // ***************************************
    public void setAnimales(Animal[] animales) {
        this.animales = animales;
    }


    // ***************************************
    // Getters
    // ***************************************
    public Animal[] getAnimales() {
        return this.animales;
    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método busca el primer mono
    public int buscarPrimerMono() {
        int pos;

        pos = -1;
        for (int i = 0; (i <= this.getAnimales().length - 1) && (pos < 0); i++)
            // Para que el código funcione en cualquier caso comparo
            // el nombre de la clase del objeto del array con el nombre
            // de la clase que me interesa, así si cambia en algún momento
            // el nombre de la clase, el código seguirá funcionando.
            if (this.getAnimales()[i] instanceof Mono)
                pos = i;

        return (pos);
    }

    // Este método cuenta el número de elefantes
    public int contarElefantes() {
        int num;

        num = 0;
        for (int i = 0; i <= this.getAnimales().length - 1; i++)
            // Para que el código funcione en cualquier caso comparo
            // el nombre de la clase del objeto del array con el nombre
            // de la clase que me interesa, así si cambia en algún momento
            // el nombre de la clase, el código seguirá funcionando
            if (this.getAnimales()[i] instanceof Elefante)
                num++;

        return (num);
    }

    // Este método elimina un animal
    public void eliminarAnimal(int id) {
        this.getAnimales()[id] = null;
    }

    // Este método añade un nuevo animal y devuelve la posición donde se
    // ha añadido. Devuelve lo siguiente:
    // -1 -> Si no se puede añadir porque no hay posiciones libres
    public int agregarAnimal(Animal animal) {
        int num;
        int pos_libre;

        // Busco una posición libre
        pos_libre = -1;
        for (int i = 0; (i <= this.getAnimales().length - 1) && (pos_libre < 0); i++)
            if (this.getAnimales()[i] == null)
                pos_libre = i;

        // Doy de alta el tipo de animal
        if (pos_libre >= 0)
            this.getAnimales()[pos_libre] = animal;

        return (pos_libre);
    }

    // Este método muestra el array de animales
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= this.getAnimales().length - 1; i++) {
            if (this.getAnimales()[i] != null) {
                sb.append("POSICION ANIMAL: " + i).append("\n");
                sb.append("CLASE..........: " + this.getAnimales()[i].getClass().getSimpleName()).append("\n");
                sb.append(this.getAnimales()[i].toString()).append("\n");
            } else
                sb.append("POSICION ANIMAL: " + i + " -> LIBRE (Animal eliminado)").append("\n\n");
        }

        return sb.toString();
    }
}
