/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * If placed in current working dir, will be consulted instead of
 * built-in Java library interface.
 *****************************************************/

public interface List<T>
<<<<<<< HEAD
{ 

    //add node to list, containing input String as its data
    public boolean add( T x ); 

    //return data in element at position i
    public T get( int i ); 

    //overwrite data in element at position i
    public T set( int i, T x ); 
=======
{

    //add node to list, containing input String as its data
    public boolean add( T x );

    //return data in element at position i
    public T get( int i );

    //overwrite data in element at position i
    public T set( int i,T x );
>>>>>>> 6a9b25e3e6150447222c63ab3f274c98ee8f9d11

    //return length of list
    public int size();

}//end interface
