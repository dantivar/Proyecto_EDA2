import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by danti on 20/05/2017.
 */
public class Main {
    public static void main(String args[]){
        System.out.println();
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            //int t_bases=Integer.parseInt(br.readLine());
            //int n_genes=Integer.parseInt(br.readLine());
            //String nom_archivo=br.readLine();
            ArrayList<String> segmentos = almacenarSegmento("C:/Users/danti/IdeaProjects/ProyectoEDA2/src/prueba.txt");
            reconstruirSufijo(segmentos, segmentos.get(0), segmentos.get(1).length(),segmentos.get(1), 1);
            //System.out.println("El t_bases es: " + t_bases + "\n El n_genes es: " + n_genes + "\n El nom_archivo es: " + nom_archivo);
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error en el proceso de lectura");
        }
    }

    public static ArrayList<String> almacenarSegmento(String nom_archivo){
        ArrayList<String> segmentos = new ArrayList<>();
        try{
            FileReader in = new FileReader(nom_archivo);
            BufferedReader br = new BufferedReader(in);
            String segmento;

            while((segmento = br.readLine()) != null){
                segmentos.add(segmento);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return segmentos;
    }

    public static String reconstruirSufijo(ArrayList<String> segmentos, String cadena, int posC, String segmento, int posA){
        /*
        Cadena1 -> Cadena2(toda) es substring de cadena1, no entonces cadena2(toda-1), cadena2.tam=0, entonces siguiente cadena, si
        sí es substring, concateno cadenas y cadena 1+cadena2=nueva cadena 1 y sigo el proceso
         */
        if(posC == 0){
            return cadena;
        }

        if(cadena.contains(segmento.substring(0,posC))) {
            System.out.println(cadena.concat(segmento.substring(posC)));
            return "";
            //return reconstruirSufijo(segmentos,cadena.concat(segmento.substring(posC)),segmentos.get(posA+1).length(),
                    //segmentos.get(posA+1),posA+1);
        }
        return reconstruirSufijo(segmentos, cadena,posC-1, segmento,posA);
    }

}
