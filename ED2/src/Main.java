import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by danti on 23/05/2017.
 */
public class Main {
    private static String cadenaADN;
    private static ArrayList<String> genes;
    private static Grafo grafo;

    public static void main(String[] args) throws IOException {
        LinkedList<String> cadena = lectura();
        genes = new ArrayList<>();
        grafo = new Grafo(cadena,201);
        grafo.ese();
        cadenaADN=grafo.laCadena();
        buscarI(cadenaADN);
        escribir();
    }

    public static LinkedList<String> lectura() throws FileNotFoundException{
        Scanner in = new Scanner(new BufferedReader(new FileReader("prueba.txt")));

        LinkedList<String> arr = new LinkedList<>();

        while(in.hasNext()){
            arr.add(in.next());
        }

        return arr;
    }

    public static void buscarI(String cadena) throws IOException {
        for (int i = 0; i < cadena.length() - 2; i++){
            if(cadena.substring(i,i+3).equals("ATG")){
                buscarF(cadena.substring(i));
                break;
            }
        }
    }

    public  static void buscarF(String cadena) throws IOException {
        String gen="";
        for (int i=0; i < cadena.length() -2 ; i+=3){
            String codon = cadena.substring(i,i+3);
            if(codon.equals("TAA") || codon.equals("TAG")
                    || codon.equals("TGA")){
                gen+=codon;
                genes.add(gen);
                buscarI(cadena.substring(i));
                break;
            }

            if(codon.equals("ATG")){
                gen="";
            }
            gen += codon;
        }
    }

    public static void escribir() throws IOException {
        FileWriter fw = new FileWriter("salida.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (String gen:
             genes) {
            bw.write(gen);
        }

        bw.close();
        fw.close();
    }
}
