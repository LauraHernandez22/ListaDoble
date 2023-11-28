
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
        
            public void intercambiarNodos(String nodo1, String nodo2) {
        Node temp1 = buscarNodo(nodo1);
        Node temp2 = buscarNodo(nodo2);

        if (temp1 != null && temp2 != null) {
            // Intercambiar nodos solo si ambos nodos existen en la lista
            Node temp1Previous = temp1.previous;
            Node temp1Next = temp1.next;

            Node temp2Previous = temp2.previous;
            Node temp2Next = temp2.next;
            System.out.println("*************************1");

            // Actualizar enlaces del nodo 1
            if (temp2Previous != null) {
                temp2Previous.next = temp1;
                System.out.println("**********************2***");
            } else {
                topForward = temp1; // Si temp2 es el primer nodo, actualizar topForward
                System.out.println("***********************3**");
            }
            temp1.previous = temp2Previous;
            temp1.next = temp2Next;

            // Actualizar enlaces del nodo 2
            if (temp1Previous != null) {
                temp1Previous.next = temp2;
                System.out.println("************************4*");
            } else {
                topForward = temp2; // Si temp1 es el primer nodo, actualizar topForward
                System.out.println("*************************5");
            }
            temp2.previous = temp1Previous;
            temp2.next = temp1Next;
            System.out.println("*************************6");
        }   
    }

    public Node buscarNodo(String nombre) {
        Node temp = topForward;
        while (temp != null && !temp.name.equals(nombre)) {
            temp = temp.next;
            System.out.println("*************************7");
        }
        return temp;
    }
}

	//Buscar un nodo por el valor de su campo clave y devolver una referencia
	//Buscar un nodo por su campo clave e insertar un nuevo nodo después de el
	//Intercambiar un nodo por otro buscado.
	

