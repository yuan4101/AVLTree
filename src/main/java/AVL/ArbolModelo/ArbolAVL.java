package AVL.ArbolModelo;
public class ArbolAVL {

    private boolean flag;
    private NodoAVL atrRaiz;
    String atrInOrden;

    public ArbolAVL() {
        atrRaiz = null;
    }

    public NodoAVL getRaiz() {
        return atrRaiz;
    }

    //ROTACIONES
    //Rotación simple Izquierda - Izquierda
    private NodoAVL rotacionDerecha(NodoAVL prmNodoTemp, NodoAVL prmNodoTemp1) {
        //System.out.println("ROTACION A LA DERECHA");
        prmNodoTemp.setNodoIzquierdo(prmNodoTemp1.getNodoDerecho());
        prmNodoTemp1.setNodoDerecho(prmNodoTemp);
        //actualizacion de los factores de equilibrio
        if (prmNodoTemp1.getFactorEquilibrio() == -1) {//se cumple en la insercion
            prmNodoTemp.setFactorEquilibrio(0);
            prmNodoTemp1.setFactorEquilibrio(0);
        }
        else {
            prmNodoTemp.setFactorEquilibrio(-1);
            prmNodoTemp1.setFactorEquilibrio(1);
        }
        return prmNodoTemp1;
    }

    private NodoAVL rotacionIzquierda(NodoAVL prmNodoTemp, NodoAVL prmNodoTemp1) {
        //System.out.println("ROTACION A LA IZQUIERDA ");
        prmNodoTemp.setNodoDerecho(prmNodoTemp1.getNodoIzquierdo());
        prmNodoTemp1.setNodoIzquierdo(prmNodoTemp);
        //actualizacion de los factores de equilibrio
        if (prmNodoTemp1.getFactorEquilibrio() == +1) {
            prmNodoTemp.setFactorEquilibrio(0);
            prmNodoTemp1.setFactorEquilibrio(0);
        }
        else {
            prmNodoTemp.setFactorEquilibrio(+1);
            prmNodoTemp1.setFactorEquilibrio(-1);
        }
        return prmNodoTemp1;
    }

    private NodoAVL rotacionID(NodoAVL prmNodoTemp, NodoAVL prmNodoTemp1) {
        //System.out.println("ROTACION IZQUIERDA - DERECHA");
        NodoAVL prmNodoTemp2;
        prmNodoTemp2 = (NodoAVL) prmNodoTemp1.getNodoDerecho();
        prmNodoTemp.setNodoIzquierdo(prmNodoTemp2.getNodoDerecho());
        prmNodoTemp2.setNodoDerecho(prmNodoTemp);
        prmNodoTemp1.setNodoDerecho(prmNodoTemp2.getNodoIzquierdo());
        prmNodoTemp2.setNodoIzquierdo(prmNodoTemp1);
        //Actualizacion de los factores de equilibrio
        if (prmNodoTemp2.getFactorEquilibrio() == +1) {
            prmNodoTemp1.setFactorEquilibrio(-1);
        }
        else {
            prmNodoTemp1.setFactorEquilibrio(0);
        }
        if (prmNodoTemp2.getFactorEquilibrio() == -1) {
            prmNodoTemp.setFactorEquilibrio(1);
        }
        else {
            prmNodoTemp.setFactorEquilibrio(0);
        }
        prmNodoTemp2.setFactorEquilibrio(0);

        return prmNodoTemp2;
    }

    private NodoAVL rotacionDI(NodoAVL prmNodoTemp, NodoAVL prmNodoTemp1) {
        //System.out.println("ROTACION DERECHA - IZQUIERDA");
        NodoAVL prmNodoTemp2;
        prmNodoTemp2 = (NodoAVL) prmNodoTemp1.getNodoIzquierdo();
        prmNodoTemp.setNodoDerecho(prmNodoTemp2.getNodoIzquierdo());
        prmNodoTemp2.setNodoIzquierdo(prmNodoTemp);
        prmNodoTemp1.setNodoIzquierdo(prmNodoTemp2.getNodoDerecho());
        prmNodoTemp2.setNodoDerecho(prmNodoTemp1);
        //Actualizacion de los factores de equilibrio
        if (prmNodoTemp2.getFactorEquilibrio() == +1) {
            prmNodoTemp1.setFactorEquilibrio(-1);
        }
        else {
            prmNodoTemp1.setFactorEquilibrio(0);
        }
        if (prmNodoTemp2.getFactorEquilibrio() == -1) {
            prmNodoTemp1.setFactorEquilibrio(1);
        }
        else {
            prmNodoTemp1.setFactorEquilibrio(0);
        }
        prmNodoTemp2.setFactorEquilibrio(0);

        return prmNodoTemp2;
    }

    public void insertar(int prmValor) throws Exception {
        int varDato;
        flag = false;
        Logical varLogical = new Logical(false);
        varDato = prmValor;
        atrRaiz = insertarAvl(atrRaiz, varDato, varLogical);
    }

    public void inOrden(NodoAVL prmNodoArbol) {
        if (prmNodoArbol != null) {
            inOrden(prmNodoArbol.getNodoIzquierdo());
            atrInOrden += prmNodoArbol.getValor() + " ";
            System.out.print(" " + prmNodoArbol.getValor());
            inOrden(prmNodoArbol.getNodoDerecho());
        }
    }

    private NodoAVL insertarAvl(NodoAVL prmNodoRaiz, int prmDato, Logical prmLogica) throws Exception {
        NodoAVL prmNodoTemp;
        if (prmNodoRaiz == null) {
            prmNodoRaiz = new NodoAVL(prmDato);
            prmLogica.setLogical(true);
        }
        else if (prmDato < prmNodoRaiz.getValor()) {//   dt.esMenor(raiz.getValor())){
            NodoAVL varNodoInsertar;
            varNodoInsertar = insertarAvl((NodoAVL) prmNodoRaiz.getNodoIzquierdo(), prmDato, prmLogica);
            prmNodoRaiz.setNodoIzquierdo(varNodoInsertar);
            //regreso por los nodos del camino de busqueda
            if (prmLogica.booleanValue()) {
                //decrementa el fe por aumentar la altura de la rama izquierda
                switch (prmNodoRaiz.getFactorEquilibrio()) {
                    case 1 -> {
                        prmNodoRaiz.setFactorEquilibrio(0);
                        prmLogica.setLogical(false);
                    }
                    case 0 -> prmNodoRaiz.setFactorEquilibrio(-1);
                    case -1 -> {
                        if (flag == false) {
                            ArbolBImprimir.imprimirNodo(atrRaiz);
                            flag = true;
                        }
                        prmNodoTemp = (NodoAVL) prmNodoRaiz.getNodoIzquierdo();
                        if (prmNodoTemp.getFactorEquilibrio() == -1) {
                            prmNodoRaiz = rotacionDerecha(prmNodoRaiz, prmNodoTemp);
                        }
                        else {
                            prmNodoRaiz = rotacionID(prmNodoRaiz, prmNodoTemp);
                        }
                        prmLogica.setLogical(false);
                    }
                }
            }
        }
        else if (prmDato > prmNodoRaiz.getValor()) {    //(dt.esMayor(raiz.getValor())){
            NodoAVL varNodoInsertar1;
            varNodoInsertar1 = insertarAvl((NodoAVL) prmNodoRaiz.getNodoDerecho(), prmDato, prmLogica);
            prmNodoRaiz.setNodoDerecho(varNodoInsertar1);
            //regreso por los nodos del camino de busqueda
            if (prmLogica.booleanValue()) {
                //decrementa el fe por aumentar la altura de la rama izquierda
                switch (prmNodoRaiz.getFactorEquilibrio()) {
                    case 1 -> {
                        if (flag == false) {
                            ArbolBImprimir.imprimirNodo(atrRaiz);
                            flag = true;
                        }
                        prmNodoTemp = (NodoAVL) prmNodoRaiz.getNodoDerecho();
                        if (prmNodoTemp.getFactorEquilibrio() == +1) {
                            prmNodoRaiz = rotacionIzquierda(prmNodoRaiz, prmNodoTemp);
                        }
                        else {
                            prmNodoRaiz = rotacionDI(prmNodoRaiz, prmNodoTemp);
                        }
                        prmLogica.setLogical(false);
                    }
                    case 0 -> prmNodoRaiz.setFactorEquilibrio(+1);
                    case -1 -> {
                        prmNodoRaiz.setFactorEquilibrio(0);
                        prmLogica.setLogical(false);
                    }
                }
            }
        }
        else {
            throw new Exception("No pueden haber claves repetidas");
        }
        return prmNodoRaiz;
    }
    
    public void eliminar(int valor){
        //System.out.println("ELIMINAR");
        int dato;
        dato = valor;
        Logical logicalFlag = new Logical(false);
        atrRaiz = borrarAvl(atrRaiz, dato, logicalFlag);
    }
    
    private NodoAVL borrarAvl(NodoAVL prmRaiz, int prmClave, Logical prmCambiaAltura){
        //System.out.println("BORRAR AVL");
        if(prmRaiz==null){
            System.out.println("Nodo no encontrado");
        }
        else if(prmClave < prmRaiz.getValor()){
            NodoAVL iz;
            iz = borrarAvl((NodoAVL)prmRaiz.getNodoIzquierdo(),prmClave,prmCambiaAltura);
            prmRaiz.setNodoIzquierdo(iz);
            if(prmCambiaAltura.booleanValue())
                prmRaiz = equilibrar1(prmRaiz,prmCambiaAltura);
        }
        else if(prmClave > prmRaiz.getValor()){
            NodoAVL dr;
            dr = borrarAvl((NodoAVL)prmRaiz.getNodoDerecho(),prmClave,prmCambiaAltura);
            prmRaiz.setNodoDerecho(dr);
            if(prmCambiaAltura.booleanValue())
                prmRaiz = equilibrar2(prmRaiz,prmCambiaAltura);
        }
        else//nodo encontrado
        {
            NodoAVL q;
            q = prmRaiz;
            if(q.getNodoIzquierdo()== null){
                prmRaiz = (NodoAVL) q.getNodoDerecho();
                prmCambiaAltura.setLogical(true);
            }
            else if(q.getNodoDerecho()==null){
                prmRaiz = (NodoAVL) q.getNodoIzquierdo();
                prmCambiaAltura.setLogical(true);
            }
            else{
                NodoAVL iz;
                iz = reemplazar(prmRaiz, (NodoAVL) prmRaiz.getNodoIzquierdo(),prmCambiaAltura);
                prmRaiz.setNodoIzquierdo(iz);
                if(prmCambiaAltura.booleanValue())
                    prmRaiz = equilibrar1(prmRaiz,prmCambiaAltura);
            }
            q = null;
        }
        return prmRaiz;
    }
    
    private NodoAVL reemplazar(NodoAVL n, NodoAVL act, Logical cambiaAltura){
        if(act.getNodoDerecho()!= null){
            NodoAVL d;
            d = reemplazar(n, (NodoAVL)act.getNodoDerecho(),cambiaAltura);
            act.setNodoDerecho(d);
            if(cambiaAltura.booleanValue())
                act = equilibrar2(act, cambiaAltura);
            
        }else{
            n.setValor(act.getValor());
            n = act;
            act = (NodoAVL) act.getNodoIzquierdo();
            n = null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }
    
    private NodoAVL equilibrar1(NodoAVL n, Logical cambiaAltura){
        NodoAVL n1;
        switch(n.getFactorEquilibrio()){
            case -1 -> n.setFactorEquilibrio(0);
            case 0 -> {
                n.setFactorEquilibrio(1);
                cambiaAltura.setLogical(false);
            }
            case +1 -> {
                //se aplica un tipo de rotacion derecha
                n1 = (NodoAVL) n.getNodoDerecho();
                if(n1.getFactorEquilibrio() >= 0){
                    if(n1.getFactorEquilibrio() == 0)
                        cambiaAltura.setLogical(false);
                    n = rotacionIzquierda(n,n1);
                }
                else
                    n = rotacionDI(n,n1);
            }
        }
        return n;
    }
    
    private NodoAVL equilibrar2(NodoAVL n, Logical cambiaAltura){
        NodoAVL n1;
        switch(n.getFactorEquilibrio()){
            case -1 -> {
                //se aplica un tipo de rotacion izquierda
                n1 = (NodoAVL) n.getNodoIzquierdo();
                if(n1.getFactorEquilibrio() <= 0){
                    if(n1.getFactorEquilibrio() == 0)
                        cambiaAltura.setLogical(false);
                    n = rotacionIzquierda(n,n1);
                }
                else
                    n = rotacionID(n,n1);
            }
            case 0 -> {
                n.setFactorEquilibrio(-1);
                cambiaAltura.setLogical(false);
            }
            case +1 -> n.setFactorEquilibrio(0);
        }
        return n;
    }
}