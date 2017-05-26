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
                Nodo nodoI=null,nodoD = null,tmp;
                int nodoA,nodoB;
                if ((nodoA=contiene(km1I))!= -1) {
                    nodoI = nodos.get(nodoA);
                }else{
                    nodoI = tmp = new Nodo(km1I);
                    nodos.add(tmp);
                }
                if ((nodoB=contiene(km1D))!= -1){
                    nodoD=nodos.get(nodoB);
                }else {
                    nodoD = tmp = new Nodo(km1D);
                    nodos.add(tmp);
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

    public int contiene(String cadenaA){
        for (Nodo nodo:
             nodos) {
            if (nodo.cadena.equals(cadenaA)) return nodos.indexOf(nodo);
        }
        return -1;
    }

    public void visitar(Nodo n){
        //Primero buscar nodo en g(HashMap)
        try {
            while (g.get(n).size() > 0) {
                Nodo dst = g.get(n).pop();
               camino.add(dst.cadena);
                visitar(dst);
            }
        }catch (Exception ex){
            //camino.add(n.cadena);
        }
    }

    public void ese(){
        visitar(nodos.get(0));
    }
}