/*****************************************************
 * class DLList
 * Implements a linked list of DDLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class DLList implements List //your List interface must be in same dir
{

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public DLList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( String newVal ) {
      //If list is empty, initialize the first node.
      //Both head and tail need to be set to this node
    	if(_size == 0){
    	    DLLNode tmp = new DLLNode(newVal, null,  _head ); //makes tmp point forwards to _head
    	    _head = tmp; //makes tmp the new _head
    	    _tail = _head; //makes _tail also equal to the same node as _head
        }

    	else{
    	    DLLNode tmp = new DLLNode(newVal, null,  _head ); //makes tmp point forwards to _head
    	    _head.setPrevious(tmp); //makes _head point backwards to tmp
    	    _head = tmp; //makes tmp the new _head
  	     }

       _size++;
       return true;
    }

    public void add( int index, String newVal ) {

      if ( index < 0 || index >= size() )
  	    throw new IndexOutOfBoundsException();

      DLLNode newNode = new DLLNode( newVal, null, null );

      //if index==0, insert node before head node
      if ( index == 0 ){
  	    add( newVal );
  	}

      else {
  	    DLLNode tmp = _head; //create alias to head


  	    //walk to node before desired node
  	    for( int i=0; i < index - 1; i++ ){
  	    	tmp = tmp.getNext();
  	    }
          

  	    //insert new node at index
  	    newNode.setNext(tmp.getNext()); //makes newNode point forwards to node next to tmp
        
        newNode.setPrevious(tmp); //makes newNode point backwards to tmp
        
  	    tmp.setNext( newNode ); //makes tmp point forwards to newNode

  	    tmp.getNext().getNext().setPrevious(newNode); //makes the node that used to be in front of tmp point backwards to newNode

        //increment size attribute
  	    _size++;
      }
    }

    public boolean addEnd(String newVal){
    	if(_size == 0){ //if size is 0, you need to make _head point to the same new node as _tail
    	    DLLNode tmp = new DLLNode(newVal, _tail, null); //makes tmp point backwards to _tail
    	    _tail = tmp; //makes tmp the new _tail
    	    _head = _tail; //makes _head also equal to _tail
    	    _size++;
    	    return true;
    	}
    	else{
    	    DLLNode tmp = new DLLNode(newVal, _tail, null); //makes tmp point backwards to _tail
    	    _tail.setNext(tmp); //makes _tail point forwards to tmp
    	    _tail = tmp; //makes tmp the new _tail
    	    _size++;
    	    return true;
    	}

    }



    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }



    //return number of nodes in list
    public int size() { return _size; }




    //remove node at pos index, return its cargo
    public String remove( int index ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
	}
	else {
	    //walk to node before desired node
	    for( int i=0; i < index - 1; i++ )
		    tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getCargo();

	    //remove target node
	  tmp.getNext().getNext().setPrevious(tmp); //makes tmp point forward to 2 nodes in front of it
      tmp.setNext(tmp.getNext().getNext()); //makes the node that is 2 in front of tmp point backwards to tmp
	}

	//decrement size attribute
	_size--;

	return retVal;
    }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD <-> ";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + " <-> ";
	    tmp = tmp.getNext();
	}
	retStr = retStr.substring(0, retStr.length() - 4) + "<-> TAIL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {

	DLList james = new DLList();

	System.out.println( james );
	System.out.println("Size before adding: " + james.size());

	james.add("2");
	System.out.println(james);
	System.out.println("Size after adding: " + james.size());

	james.add("3");
	System.out.println(james);
	System.out.println("Size after adding: " + james.size());

	james.addEnd("1");
	System.out.println(james);
	System.out.println("Size after adding: " + james.size());

	james.addEnd("0");

	System.out.println(james);
	System.out.println("Size after adding: " + james.size());

	james.add(2, "100");
	System.out.println(james);
	System.out.println("Size after adding: " + james.size());

	james.remove(2);
	System.out.println(james);
	System.out.println("Size after removing: " + james.size());

	james.remove(0);
	System.out.println(james);
	System.out.println("Size after removing: " + james.size());

    }

}//end class DLList
