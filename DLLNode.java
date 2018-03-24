/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode
{
    //instance vars
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _previousNode; 

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode previous, DLLNode next ) {
	_cargo = value;
	_nextNode = next;
	_previousNode = previous;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrevious() {return _previousNode;}

    
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode setPrevious(DLLNode newPrev){
        DLLNode foo = getPrevious();
	_previousNode = newPrev;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    
    // override inherited toString
    public String toString() { return _cargo; }


    //main method for testing
    public static void main( String[] args )
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null, null ) );


	DLLNode tmp = first;
	while( tmp != null ) {
	    System.out.println( tmp );
	    tmp = tmp.getNext();
	}

	System.out.println("====================");

	//Create a node
	DLLNode last = new DLLNode( "cat", null, null );


	last.setPrevious( new DLLNode( "dog", null, null ) );


	last.getPrevious().setPrevious(new DLLNode("bear", null, null));


	DLLNode tmp0 = last;
	while( tmp0 != null ) {
	    System.out.println( tmp0 );
	    tmp0 = tmp0.getPrevious();
	}
	   
	
    }//end main

}//end class DLLNode

