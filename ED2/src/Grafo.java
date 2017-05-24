import java.util.*;

/**
 * Created by danti on 23/05/2017.
 */
public class Grafo {

private HashMap<Nodo,LinkedList<Nodo>> g;
private LinkedList<Nodo> nodos;
private ArrayList<String> camino;

    private class Nodo{
        public String cadena;

        public Nodo(String cadenaN){
            this.cadena=cadenaN ;
        }
    }

    public Grafo(String[] cadena, int k){
        g = new HashMap<>();
        nodos = new LinkedList<>();

        for (String st : cadena) {
            for (String kmer : this.k_1mer(st,k)){
                String km1I = kmer.substring(0,kmer.length() - 1);
                String km1D = kmer.substring(1);
                Nodo nodoI=null,nodoD = null ,nodoA,nodoB;
                if ((nodoA=contiene(km1I))!= null){
                    nodoI=nodoA;
                }else{
                    nodoI = nodoA = new Nodo(km1I);
                }
                if ((nodoB=contiene(km1I))!= null){

                }else {
                    nodoD = nodoB = new Nodo(km1D);
                }
                if(g.containsKey(nodoI)){
                    g.get(nodoI).add(nodoD);
                }else{
                    g.put(nodoI,new LinkedList<Nodo>());
                    g.get(nodoI).add(nodoD);
                }
            }
        }
    }

    public ArrayList<String> k_1mer(String st, int k){
        ArrayList<String> stArr = new ArrayList<>();
        String st2;
        for(int i = 0; i< st.length()-(k-1);i++){
            st2=st.substring(i,i+k);
            stArr.add(st2);
        }
        return stArr;
    }

    public Nodo contiene(String cadenaA){
        for (Nodo nodo:
             nodos) {
            if (nodo.cadena.equals(cadenaA)) return nodo;
        }
        return null;
    }

    public void visitar(Nodo n){
        while (g.get(n).size() > 0){
            Nodo dst=g.get(n).pop();
            visitar(dst);
        }
        System.out.println(n.cadena);
    }

    public void imprimir(){
        /*Random rdm = new Random();
        List<Nodo> keys = new ArrayList<Nodo>(g.keySet());
        Nodo rdmKey = keys.get(rdm.nextInt(keys.size()));
        visitar(rdmKey);*/
        for(LinkedList<Nodo> k : g.values()){
            for (Nodo m:
                 k) {
                System.out.print(m.cadena + ",");
            }
        }
    }
}