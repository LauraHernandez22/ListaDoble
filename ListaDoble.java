
/**
 * Write a description of class ListaDoble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDoble
{
    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;
            
            topBackward = topForward;

            return true;
        }
        else {
            return false;
        }
    }
    
    public void imprimir(){
        System.out.print("[X]"); 

        for (Node temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n"); 
    }
    
    public String toString(){
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " <- [ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n"; 

        return cadAux;
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;
        
        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
                && temp2.name.equals(buscado) == false ) {    
                 temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;
            
            return true;
        }
        else return false;
    } 
    
    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }

    
    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.topForward;

        while ( (temp != null) 
                && temp.name.equals(buscado) == false ) {    
                 temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;
            
            return true;
        }
        else return false;          
        }
        
    public void buscarNodoClave(String nombre){
        Node temp = new Node();
        temp = this.topForward;
            
            while(temp != null){
                if (temp.name == nombre){
                    System.out.println("Nodo encontrado, si existe");
                }else if (temp.name != nombre){
                    System.out.println("Nodo no encontrado, no existe en la lista");
                }
                temp = temp.next;
            }
        }    
        
    public void buscarNodo(String nombre, String nuevoNodoValor) {
    Node temp = this.topForward;

    while (temp != null) {
        if (temp.name.equals(nombre)) {  
            // Crear un nuevo nodo con el valor proporcionado
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNodoValor;

            // Insertar el nuevo nodo después del nodo encontrado
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;

            System.out.println("Nuevo nodo agregado después del nodo encontrado");
            
            // Romper el bucle ya que ya se ha encontrado el nodo
            break;
        } 

        temp = temp.next;
    }
}
        
        
        
        public boolean intercambiarNodos(String nodo1, String nodo2) {
        Node temp1 = null, temp2 = null;
        Node prevTemp1 = null, prevTemp2 = null;

        // Buscar los nodos a intercambiar y sus nodos previos
        for (Node temp = this.topForward; temp != null; temp = temp.next) {
            if (temp.name.equals(nodo1)) {
                temp1 = temp;
                break;
            }
            prevTemp1 = temp;
        }

        for (Node temp = this.topForward; temp != null; temp = temp.next) {
            if (temp.name.equals(nodo2)) {
                temp2 = temp;
                break;
            }
            prevTemp2 = temp;
        }

        // Verificar si se encontraron ambos nodos
        if (temp1 != null && temp2 != null) {
            // Intercambiar nodos
            if (prevTemp1 != null) {
                prevTemp1.next = temp2;
            } else {
                this.topForward = temp2;
            }

            if (prevTemp2 != null) {
                prevTemp2.next = temp1;
            } else {
                this.topForward = temp1;
            }

            Node temp = temp1.next;
            temp1.next = temp2.next;
            temp2.next = temp;

            return true;
        }

        return false; // No se encontraron ambos nodos especificados
    }
    
    
}
