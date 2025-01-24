package _07POO_Zoo;

/*
    Nombre de clase: ZooES
    Tipo de clase..: Regular
    Hereda de......: Ninguna. Esta clase encapsula menús y otras E/S.
 */

import java.util.Scanner;

public class ZooES {

    // ***************************************
    // Constructores
    // ***************************************
    public ZooES() {

    }


    // ***************************************
    // Métodos
    // ***************************************
    // Este método gestiona el menú y determina la opción elegida
    // llamando a otros métodos que resuelven las opciones
    public static void gestionMenu(Zoo zoo) {
        Scanner lector = new Scanner(System.in);
        int opcion;
        int aux;
        String nuevo_cuidador;
        Animal nuevo_animal;

        do {
            System.out.println();
            System.out.println("Menú de opciones");
            System.out.println("****************");
            System.out.println("1. Mostrar el array");
            System.out.println("2. Buscar la posición del primer mono");
            System.out.println("3. Contar el número de Elefantes");
            System.out.println("4. Modificar el cuidador del elemento que digamos");
            System.out.println("5. Eliminar animal");
            System.out.println("6. Añadir animal");
            System.out.println("7. Modificar el estado de rotura de pico de un ornitorrinco");
            System.out.println("0. Salir");

            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    // Aquí delego en un método directamente
                    System.out.println(zoo.toString());
                    break;

                case 2:
                    // Aquí delego en un método para obtener la posición
                    // y el resto de la lógica la hago en local
                    aux = zoo.buscarPrimerMono();
                    if (aux > 0)
                        System.out.println("El primero mono está en la posición " + aux);
                    else
                        System.out.println("No hay monos en la lista");
                    break;

                case 3:
                    // Aquí delego en un método para obtener la posición
                    // y el resto de la lógica la hago en local
                    aux = zoo.contarElefantes();
                    System.out.println("En la lista de animales hay " + aux + " elefantes");
                    break;

                case 4:
                    // Este proceso lo voy a hacer "a la antigua", sin
                    // llamar a un procedimiento
                    System.out.println("Indique la posición del animal (0-" + (zoo.getAnimales().length - 1) + "): ");
                    aux = lector.nextInt();
                    lector.nextLine();

                    System.out.println("Indique el nombre del nuevo cuidador: ");
                    nuevo_cuidador = lector.nextLine();

                    if ((aux >= 0) && (aux <= zoo.getAnimales().length - 1)) {
                        zoo.getAnimales()[aux].setCuidador(nuevo_cuidador);
                        System.out.println("Cambiado!");
                    } else
                        System.out.println("No se puede cambiar el cuidador porque no ha indicado una posición correcta");
                    break;

                case 5:
                    System.out.println("Indique el animal a dar de baja (0-" + (zoo.getAnimales().length - 1) + "): ");
                    aux = lector.nextInt();
                    lector.nextLine();

                    zoo.eliminarAnimal( aux);
                    break;

                case 6:
                    System.out.println("Indique que tipo de animal quiere dar de alta\n(0-> Mono; 1-> Ornitorrinco; 2-> Elefante)");
                    aux = lector.nextInt();
                    lector.nextLine();

                    nuevo_animal=null;
                    switch (aux) {
                        case 0:
                            // Uso el constructor sin parámetros para que
                            // los datos sean aleatorios
                            nuevo_animal = new Mono();
                            break;

                        case 1:
                            // Uso el constructor sin parámetros para que
                            // los datos sean aleatorios
                            nuevo_animal = new Ornitorrinco();
                            break;

                        case 2:
                            // Uso el constructor sin parámetros para que
                            // los datos sean aleatorios
                            nuevo_animal = new Elefante();
                            break;

                    }
                    if (nuevo_animal != null) {
                        aux = zoo.agregarAnimal(nuevo_animal);
                        switch (aux) {
                            case -1:
                                System.out.println("No se pudo añadir el elemento por falta de espacio");
                                break;

                            default:
                                System.out.println("Elemento añadido correctamente en la posición " + aux);
                                break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Indique la posición que ocupa en el array el ornitorrinco que quiere cambiar (0-" + (zoo.getAnimales().length - 1) + ")");
                    aux = lector.nextInt();
                    lector.nextLine();

                    if (aux >= 0 && aux <= zoo.getAnimales().length - 1)
                        if (zoo.getAnimales()[aux] instanceof Ornitorrinco) {
                            // Intercambio el valor booleano que tenga el atributo
                            ((Ornitorrinco) zoo.getAnimales()[aux]).setPicoRoto(!((Ornitorrinco) zoo.getAnimales()[aux]).getPicoRoto());

                            System.out.println("Cambiado el valor a: " + ((Ornitorrinco) zoo.getAnimales()[aux]).getPicoRoto());
                        }
                        else
                            System.out.println("El animal de la posición indicada no es un Ornitorrinco");
                    else
                        System.out.println("Debe indicar una posición correcta");
                    break;

                case 0:
                    // La opción de salida se contempla sin código para
                    // que no se de un mensaje de opción incorrecta
                    break;

                default:
                    // Por defecto la opción es incorrecta si no es
                    // ninguna de las elegidas antes
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
    }

}
