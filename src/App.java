import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        MetodoBusBin metodo = new MetodoBusBin();
        Scanner scanner = new  Scanner(System.in);

        System.out.println("Cuantas personas desea ingresar: ");
        int cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        Persona[] personas = new Persona[cantidadPersonas];
        int[] personasInt = new int[cantidadPersonas];

        personasInt[0] = 1;
        personas[0] = new Persona(null, cantidadPersonas);
        int[] edades = new int[cantidadPersonas];

        // Pedir al usuario los datos de la persona
        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i + 1));
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la edad de la persona " + (i + 1));
            int edad = scanner.nextInt();
            scanner.nextLine();
            personas[i] = new Persona(nombre, edad);
            edades[i] = edad; 

        }
        // Edades sin ordenar 
        System.out.println("Edades sin ordenar: ");
        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.print(personas[i].getEdad() + " | " );
        }

        //Ordenar edades
        System.out.println("");
        System.out.println("Edades Ordenadas: ");
        edades = metodo.sortbyInsercion(edades);
        metodo.printArreglo(edades);
        System.out.println("");
        // edad a buscar
        System.out.println("Ingrese la edad a buscar: ");
        int edadABuscar = scanner.nextInt();
        int indice = metodo.busquedaBinaria(edades, edadABuscar);

        if (indice != -1) {
            System.out.println("La persona con la edad de " + edadABuscar + " es " + personas[indice].getNombre());
        } else {
            System.out.println("La edad " + edadABuscar + " no fue encontrada.");
        }
    }
    public void sortByEdad(Persona[] personas){
        for (int i = 0; i < personas.length; i++) {
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[i].getEdad() > personas[j].getEdad()) {
                    Persona aux = personas[i];
                    personas[i] = personas[j];
                    personas[j] = aux;
                }     
            }
        }
    }
    public int findByEdad(Persona[] personas, int edad){
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getEdad() == edad) {
                return i;
            }
        }
        return -1;
    }
    /*public static int leerEnteroValido(Scanner scanner,String mensaje,boolean permitirNegativos){
        int numero = 0;

        do{
            System.out.println(mensaje);
            while(!scanner.hasNextInt()){
                System.out.println("Te pedi un entero");
                System.out.println(mensaje);
                scanner.next();
            }
            numero = scanner.nextInt();
            if(!permitirNegativos && numero < 0){
                System.out.println("El tamaño debe ser mayor a 0");
            }
        }while(!permitirNegativos && numero < 0);
        return numero;
    }*/
}
