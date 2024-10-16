public class MetodoBusBin {
    //Metodo para ordenar
    public int[] sortbyInsercion(int[] arreglo){
        int tam = arreglo.length;
        for (int i = 1; i < tam; i++ ){          
            int aux = arreglo[i];
            int j = i - 1;    
            while (j >= 0  && arreglo[j] > aux) {         
                arreglo[j + 1] = arreglo[j];
                j = j - 1; 
                arreglo[j + 1] = aux;           
            }             
        }
        return arreglo;
    }
    public void printArreglo(int[]arreglo){
        for (int elemento : arreglo){ 
            System.out.print(elemento + " | ");
        }
    }

    //Metodo de Busqueda Binaria
    public int busquedaBinaria(int[] arr, int value){
        int inicio = 0;
        int fin = arr.length -1;
        int contador = 1;

        while(inicio <= fin){
            int medio = inicio + (fin - inicio)/2;

            if(arr[medio] == value){
                //elemento encontrado
                return medio;
            }

            if(arr[medio] < value){
                inicio = medio + 1; // buscar en la mitad de la derecha
            }else{
                fin = medio - 1; // buscar en la mitad de la derecha
            }
            contador++;
        }
        System.out.println("El numero de iteraciones es: " + contador); 
        return -1;

    }
    public void printArreglo2(int[] arr){
        for (int elemento : arr){
            System.out.print(elemento + " ");
        }
    }
}

