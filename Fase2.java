import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Fase2 {
    private Fase2(){

    }
    public static LinkedList<Integer>[] crearListas(){
        LinkedList<Integer> digitos[];
        digitos = new LinkedList[10];
        for(int i = 0; i<10; i++){
            digitos[i] = new LinkedList();
        }
        return digitos;
    }
    public static void imprimirListas(LinkedList<Integer> digitos[]){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<10; i++){
            System.out.print("\nF"+i+": ");
            for(Integer numero : digitos[i]){
                str.append(numero);
                str.append(",");
            }
            System.out.println(str);
            str.delete(0, str.length());

        }
    }
    public static void EscrituraArchivos(LinkedList<Integer> digitos[], String nombre){
        StringBuilder str = new StringBuilder();
        PrintWriter fileOut;
        try{
            for(int i = 0; i<10; i++){
                fileOut = new PrintWriter(nombre+"_F"+i+".txt");
                for(Integer numero : digitos[i]){
                    str.append(numero);
                    str.append(",");
                }fileOut.println(str);
            fileOut.close();
            str.delete(0, str.length());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
    public static void imprimirArchivos(String nombre){
        Scanner fileIn;
        String line;
        try {
            for(int i = 0; i<10; i++){
            fileIn = new Scanner(new FileReader(nombre+"_F"+i+".txt"));
            System.out.println("\nF"+i+": ");
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                System.out.println(line);
            }
            fileIn.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void ImprimirArchivosAux(String nombre){
        Scanner fileIn;
        String line;
        try {
            fileIn = new Scanner(new FileReader(nombre+".txt"));
            System.out.println(nombre+": ");
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                System.out.println(line);
            }
            fileIn.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    static List<Integer> leerArchivos(String nombre) { //Clase que retornará una lista de enteros
        FileReader fr;
        BufferedReader br;
        List<Integer> numeros = new LinkedList<>();
            try {
                
                for(int i=0; i<10; i++){
                fr = new FileReader(nombre+"_F"+i+".txt");
                br = new BufferedReader(fr);
                String linea;

                if((linea = br.readLine()) != null){
                    String [] datos = linea.split(","); //Leemos los datos que ya sabemos, estan separados por comas y los agregamos a un arreglo
                    if(linea.isEmpty()){
                        continue;
                    }
                    for(String dato: datos)
                        numeros.add(Integer.parseInt(dato)); //Agregamos los datos obtenidos a una lista convirtiendolos en enteros
                    }
                }
            }catch (FileNotFoundException e){
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            } catch (Exception e) {
                //TODO: handle exception
            }
        return numeros;
    }


    public static void EscrituraArchivosAux(LinkedList<Integer> digitos[], String nombre){
        StringBuilder str = new StringBuilder();
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter(nombre+".txt");
            for(int i = 0; i<10; i++){
                for(Integer numero : digitos[i]){
                    str.append(numero);
                    str.append(",");
                }
            }
            fileOut.println(str);
                str.delete(0, str.length());
            fileOut.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void Ascendente(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList();
        LinkedList<Integer> unidades[];
        LinkedList<Integer> decenas[];
        LinkedList<Integer> centenas[];
        unidades = crearListas();
        System.out.println("Archivo original: " + numeros);
        unidades = ordenarA(numeros, unidades, u);
        EscrituraArchivos(unidades, "Unidades");
        imprimirArchivos("Unidades");
        EscrituraArchivosAux(unidades, "AuxiliarUnidades");
        aux = leerArchivos("Unidades");
        ImprimirArchivosAux("AuxiliarUnidades");
        decenas = crearListas();
        decenas = ordenarA(aux, decenas, d);
        EscrituraArchivos(decenas, "Decenas");
        imprimirArchivos("Decenas");
        aux.clear();
        aux = leerArchivos("Decenas");
        EscrituraArchivosAux(decenas, "AuxiliarDecenas");
        ImprimirArchivosAux("AuxiliarDecenas");
        centenas = crearListas();
        centenas = ordenarA(aux, centenas, c);
        EscrituraArchivos(centenas, "Centenas");
        imprimirArchivos("Centenas");
        aux.clear();
        aux = leerArchivos("Centenas");
        EscrituraArchivosAux(centenas, "AuxiliarCentenas");
        ImprimirArchivosAux("AuxiliarCentenas");
        System.out.println("\nArreglo ordenado: " + aux);
        System.out.println("Escribiendo respuesta en un archivo...");
        EscrituraArchivosAux(centenas, "Respuesta");
        ImprimirArchivosAux("Respuesta");

    }
    public static LinkedList<Integer>[] ordenarA(List<Integer> numeros, LinkedList<Integer> digitos[], int unidad){
        for(int i=0; i<numeros.size(); i++){
            int indice = numeros.get(i)/unidad %10;
            if(indice>=0){
                switch(indice){
                    case 0:
                        digitos[0].add(numeros.get(i));
                        break;
                    case 1:
                        digitos[1].add(numeros.get(i));
                        break;
                    case 2:
                        digitos[2].add(numeros.get(i));
                        break;
                    case 3:
                        digitos[3].add(numeros.get(i));
                        break;
                    case 4:
                        digitos[4].add(numeros.get(i));
                        break;
                    case 5:
                        digitos[5].add(numeros.get(i));
                        break;
                    case 6:
                        digitos[6].add(numeros.get(i));
                        break;
                    case 7:
                        digitos[7].add(numeros.get(i));
                        break;
                    case 8:
                        digitos[8].add(numeros.get(i));
                        break;
                    case 9:
                        digitos[9].add(numeros.get(i));
                        break;
                    default:
                        break;
                }
            }
        } return digitos;
    }
    public static List<Integer> agregarA(LinkedList<Integer> digitos[], List<Integer> aux){
        for(int i = 0; i<10; i++){
            for(Integer numero : digitos[i]){
                aux.add(numero);
            }
        }
        return aux;
    }

    
}
