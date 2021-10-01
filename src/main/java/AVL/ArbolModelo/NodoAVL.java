package AVL.ArbolModelo;


public class NodoAVL implements Cloneable{
    private int atrValor;
    private NodoAVL atrNodoIzquierdo;
    private NodoAVL atrNodoDerecho;
    private int atrFactorEquilibrio;
    
    public NodoAVL(){
        atrValor = 0;
        atrNodoIzquierdo = null;
        atrNodoDerecho = null;
        atrFactorEquilibrio = 0;
    }
    
    public NodoAVL(int prmValor){
        this.atrValor = prmValor;
        atrNodoIzquierdo = null;
        atrNodoDerecho = null;
        atrFactorEquilibrio = 0;
    }
  
    public NodoAVL getNodoIzquierdo(){
        return atrNodoIzquierdo;
    }
    public NodoAVL getNodoDerecho(){
        return atrNodoDerecho;
    }
    public void setNodoIzquierdo(NodoAVL prmIzquierdo){
        this.atrNodoIzquierdo = prmIzquierdo;
    }
    public void setNodoDerecho(NodoAVL prmDerecho){
        this.atrNodoDerecho = prmDerecho;
    }

    public int getFactorEquilibrio() {
        return atrFactorEquilibrio;
    }

    public void setFactorEquilibrio(int prmFactorEquilibrio) {
        this.atrFactorEquilibrio = prmFactorEquilibrio;
    }

    public int getValor() {
        return atrValor;
    }

    public void setValor(int prmValor) {
        this.atrValor = prmValor;
    }
    
    @Override
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("no se puede duplicar");
        }
        return obj;
    }
    
    /*
    public boolean esIgual(Object q){
        Entero obj = (Entero)q;
        return (valor == obj.getDato());
    }
    public boolean esMenor(Object q){
        Entero obj = (Entero)q;
        return (valor < obj.getDato());
    }
    public boolean esMayor(Object q){
        Entero obj = (Entero)q;
        return (valor > obj.getDato());
    }
    */
    public String toString(){
        return "" + atrValor;
    }
}
