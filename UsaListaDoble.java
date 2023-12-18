
/**
 * Write a description of class UsaListaDoble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsaListaDoble
{
   public static void main (String[]args){
       ListaDoble lista = new ListaDoble();
       lista.insertaPrimerNodo("R");
       lista.imprimir();
       lista.insertaPrimerNodo("F");
       lista.imprimir();
       System.out.println(lista);
       lista.insertaAntesPrimerNodo("H");
       System.out.println(lista);
       lista.insertaAlFinal("Z");
       System.out.println(lista);
       lista.insertaEntreNodos("T", "R");
       System.out.println(lista);
       lista.insertaAntesPrimerNodo("K");
       System.out.println(lista);
       lista.insertaAlFinal("Ñ");
       System.out.println(lista);
       lista.borrarPrimerNodo();
       System.out.println(lista);
       lista.borrarUltimoNodo();
       System.out.println(lista);
       lista.borrarCualquierNodo("R");
       System.out.println(lista);
       
       /* ----------------------------------------------------- */
       lista.buscarNodo("R", "L"); 
       System.out.println(lista);
       lista.intercambiarNodos("H","R");
       System.out.println(lista);
       lista.buscarNodoClave("Z");
       System.out.println(lista);
        /* ----------------------------------------------------- */
   }
}
