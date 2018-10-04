/**
 * La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
 * Dentro de sus características esta que tiene un string como llave (key) y un entero
 * como valor (value)
 * @author Santiago Isaza & Hamilton Gómez- Plantilla de Mauricio Toro, Andres Paez
 * @version 2
 */
public class UnaTablaDeHash
{
    /*
     * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
     * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
     * característica se implementará posteriormente.
     */
    private int[] tabla;

    /**
     * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
     * 
     */
    public UnaTablaDeHash(){
        tabla = new int[10];
        for(int i=0;i<tabla.length;i++){
            tabla[i]=0;
        }

    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
     * se utilicen digitos de 0 a 10.
     */
    private int funcionHash(String k){
        return ((int) k.charAt(0)) % 10;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
     */
    public int get(String k){
        int key=funcionHash(k);
        return tabla[key];
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
     * @param v es el valor asociado a la llave k
     * Este método se utiliza para agregar un nuevo elemento
     */
    public void put(String k, int v){
        int key=funcionHash(k);
        for(int i=0;i<tabla.length;i++){
            if(tabla[key]==0){
                tabla[key]=v;        
            }else if (i==10){
                System.out.println("No hay espacio");

            }else if(tabla[key]==v){
                System.out.println("Ya existe un contacto con este nombre");
            }else {
                for(int j=key; j<tabla.length-1; j++){ 
                    int temp = tabla[j]; 
                    tabla[j]=v; 
                    tabla[j+1]=temp;                                      

                }
                break;

            }
        }

    }
}