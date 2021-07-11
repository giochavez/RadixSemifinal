import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class Fase3 {
    private Fase3(){

    }
    public static void descendente(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList();
        LinkedList<Integer> unidades[];
        LinkedList<Integer> decenas[];
        LinkedList<Integer> centenas[];
        unidades = Fase2.crearListas();
        System.out.println("Archivo original: " + numeros);
        unidades = Fase2.ordenarA(numeros, unidades, u);
        EscrituraArchivosDes(unidades, "Unidades");
        imprimirArchivosD("Unidades");
        EscrituraArchivosAuxDes(unidades, "AuxiliarUnidades");
        aux = leerArchivosDes("Unidades");
        Fase2.ImprimirArchivosAux("AuxiliarUnidades");
        decenas = Fase2.crearListas();
        decenas = Fase2.ordenarA(aux, decenas, d);
        EscrituraArchivosDes(decenas, "Decenas");
        imprimirArchivosD("Decenas");
        aux.clear();
        aux = leerArchivosDes("Decenas");
        EscrituraArchivosAuxDes(decenas, "AuxiliarDecenas");
        Fase2.ImprimirArchivosAux("AuxiliarDecenas");
        centenas = Fase2.crearListas();
        centenas = Fase2.ordenarA(aux, centenas, c);
        EscrituraArchivosDes(centenas, "Centenas");
        imprimirArchivosD("Centenas");
        aux.clear();
        aux = leerArchivosDes("Centenas");
        EscrituraArchivosAuxDes(centenas, "AuxiliarCentenas");
        Fase2.ImprimirArchivosAux("AuxiliarCentenas");
        System.out.println("\nArreglo ordenado: " + aux);
        System.out.println("Escribiendo respuesta en un archivo...");
        EscrituraArchivosAuxDes(centenas, "Respuesta");
        Fase2.ImprimirArchivosAux("Respuesta");


    }
    public static List<Integer> agregarD(LinkedList<Integer> digitos[], List<Integer> aux){
        for(int i = 9; i>=0; i--){
            for(Integer numero : digitos[i]){
                aux.add(numero);
            }
        }
        return aux;
    }
    public static void imprimirArchivosD(String nombre){
        Scanner fileIn;
        String line;
        try {
            for(int i = 9; i>=0; i--){
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
    public static void EscrituraArchivosAuxDes(LinkedList<Integer> digitos[], String nombre){
        StringBuilder str = new StringBuilder();
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter(nombre+".txt");
            for(int i = 9; i>=0; i--){
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
    static List<Integer> leerArchivosDes(String nombre) { //Clase que retornará una lista de enteros
        FileReader fr;
        BufferedReader br;
        List<Integer> numeros = new LinkedList<>();
            try {
                
                for(int i=9; i>=0; i--){
                fr = new FileReader(nombre+"_F"+i+".txt");
                br = new BufferedReader(fr);
                String linea;
                if((linea = br.readLine()) != null){
                    String [] datos = linea.split(","); //Leemos los datos que ya sabemos, estan separados por comas y los agregamos a un arreglo
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
    public static void EscrituraArchivosDes(LinkedList<Integer> digitos[], String nombre){
        StringBuilder str = new StringBuilder();
        PrintWriter fileOut;
        try{
            for(int i = 9; i>=0; i--){
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
}
