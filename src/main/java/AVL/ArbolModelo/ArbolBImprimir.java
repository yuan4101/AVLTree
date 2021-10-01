package AVL.ArbolModelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ArbolBImprimir {
    public static void imprimirNodo(NodoAVL prmRaiz){
        int prmValorNivelMaximo = ArbolBImprimir.NivelMaximo(prmRaiz);
        imprimirNodoInterno(Collections.singletonList(prmRaiz),1,prmValorNivelMaximo);
    }
    private static void imprimirNodoInterno(List<NodoAVL> prmNodos, int prmNivel, int prmValorNivellMaximo){
        if(prmNodos.isEmpty() || ArbolBImprimir.isAllElementsNull(prmNodos))
            return;
        int prmValorPiso = prmValorNivellMaximo - prmNivel;
        int prmEndgeLines = (int)Math.pow(2,(Math.max(prmValorPiso-1,0)));
        int prmFirstSpaces = (int)Math.pow(2, (prmValorPiso))-1;
        int prmBetweenSpaces = (int) Math.pow(2, (prmValorPiso + 1 ))-1;
        
        ArbolBImprimir.ImprimirEspacionBlanco(prmFirstSpaces);
        
        List<NodoAVL> varNodosNuevos = new ArrayList<NodoAVL>();
        for(NodoAVL varNodo : prmNodos){
            if(varNodo != null){
                System.out.print(varNodo.getValor());
                varNodosNuevos.add(varNodo.getNodoIzquierdo());
                varNodosNuevos.add(varNodo.getNodoDerecho());
            }else{
                varNodosNuevos.add(null);
                varNodosNuevos.add(null);
                System.out.print(" ");
            }
            ArbolBImprimir.ImprimirEspacionBlanco(prmBetweenSpaces);
        }
        System.out.println(" ");
        for(int varIndice = 1; varIndice <= prmEndgeLines; varIndice++){
            for(int varIndice1 = 0;varIndice1 < prmNodos.size(); varIndice1++){
                ArbolBImprimir.ImprimirEspacionBlanco(prmFirstSpaces - varIndice );
                if(prmNodos.get(varIndice1) == null){
                    ArbolBImprimir.ImprimirEspacionBlanco(prmEndgeLines + prmEndgeLines + varIndice + 1);
                    continue;
                }
                if(prmNodos.get(varIndice1).getNodoIzquierdo()!=null){
                    System.out.print("/");
                }
                else
                    ArbolBImprimir.ImprimirEspacionBlanco(1);
                ArbolBImprimir.ImprimirEspacionBlanco(varIndice + varIndice - 1);
                if(prmNodos.get(varIndice1).getNodoDerecho() != null){
                    System.out.print("\\");
                }
                else
                    ArbolBImprimir.ImprimirEspacionBlanco(1);
                
                ArbolBImprimir.ImprimirEspacionBlanco(prmEndgeLines + prmEndgeLines - varIndice);
            }
            System.out.println("");
        }
        imprimirNodoInterno(varNodosNuevos,prmNivel+1,prmValorNivellMaximo);
    }   
    private static void ImprimirEspacionBlanco(int prmContador){
        for(int varIndice = 0; varIndice<prmContador; varIndice++){
            System.out.print(" ");
        }
    }
    private static int NivelMaximo(NodoAVL prmNodo){
        if(prmNodo == null)
            return 0;
        return Math.max(ArbolBImprimir.NivelMaximo(prmNodo.getNodoIzquierdo()),ArbolBImprimir.NivelMaximo(prmNodo.getNodoDerecho()))+1;
    }
    private static <T> boolean isAllElementsNull(List<T> prmLista){
        for(Object prmObjeto : prmLista){
            if(prmObjeto != null)
                return false;
        }
        return true;
    }
}
