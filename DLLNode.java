/*
Alvin Ye and Joshua Weiner - Red Elephant
APCS2 - pd08
HW #25: Generically Speaking...
2018 - 03 - 26
/*****************************************************
 * class DLLNode<T>
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class DLLNode<T>
{
    //instance vars
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode; //pointer to next DLLNode<T>
    private DLLNode<T> _previousNode;

    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode<T> previous, DLLNode<T> next ) {

	_cargo = value;
	_nextNode = next;
	_previousNode = previous;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getNext() { return _nextNode; }

    public DLLNode<T> getPrevious() {return _previousNode;}


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
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args )
    {

	//Below is an exercise in creating a linked list...

	//Create a node

	DLLNode<String> first = new DLLNode<String>( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode<String>( "dog", null, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode<String>( "cow", null, null ) );


	DLLNode<String> tmp = first;



	while( tmp != null ) {
	    System.out.println( tmp );
	    tmp = tmp.getNext();
	}

	System.out.println("====================");

	//Create a node

	DLLNode<String> last = new DLLNode<String>( "cat", null, null );


	last.setPrevious( new DLLNode<String>( "dog", null, null ) );


	last.getPrevious().setPrevious(new DLLNode<String>("bear", null, null));


	DLLNode<String> tmp0 = last;

	while( tmp0 != null ) {
	    System.out.println( tmp0 );
	    tmp0 = tmp0.getPrevious();
	}


    }//end main

}//end class DLLNode<T>
