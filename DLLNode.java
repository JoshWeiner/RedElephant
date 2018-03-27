//Joshua Weiner
/*****************************************************
 * class DLLNode<T>
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode<T><T>
{
    //instance vars
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T><T> _nextNode; //pointer to next DLLNode<T>
    private DLLNode<T><T> _previousNode;

    // constructor -- initializes instance vars
    public DLLNode<T><T>( T value, DLLNode<T><T> previous, DLLNode<T><T> next ) {
	_cargo = value;
	_nextNode = next;
	_previousNode = previous;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T><T> getNext() { return _nextNode; }

    public DLLNode<T><T> getPrevious() {return _previousNode;}


    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) {
	T foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ) {
	DLLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode<T> setPrevious(DLLNode<T> newPrev){
        DLLNode<T> foo = getPrevious();
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
	DLLNode<T> first = new DLLNode<T>( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode<T>( "dog", null, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode<T>( "cow", null, null ) );


	DLLNode<T> tmp = first;
	while( tmp != null ) {
	    System.out.println( tmp );
	    tmp = tmp.getNext();
	}

	System.out.println("====================");

	//Create a node
	DLLNode<T> last = new DLLNode<T>( "cat", null, null );


	last.setPrevious( new DLLNode<T>( "dog", null, null ) );


	last.getPrevious().setPrevious(new DLLNode<T>("bear", null, null));


	DLLNode<T> tmp0 = last;
	while( tmp0 != null ) {
	    System.out.println( tmp0 );
	    tmp0 = tmp0.getPrevious();
	}


    }//end main

}//end class DLLNode<T>
