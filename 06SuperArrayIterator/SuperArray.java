omprt java.util.*;
public class SuperArray implements Iterable<String>{
    
    private String [] data;
    private int size;

    public SuperArray ( ) {
	new SuperArray ( 10 );
    }

    public SuperArray ( int capacity ) {
	data = new String[ capacity ];
	size = 0;
    }

    public SuperArray ( String [] old ) { // plug in values from another array 
	data = new String [ old.length * 2 ];
	for ( int i = 0 ; i < old.length ; i++ ) {
	    data[i] = old[i];
	}
	size = old.length;
    }

    public void sizeCheck ( ) { // helper
	if ( size( ) == data.length ) {
	    resize ( data );
	}
    }
    
    public void resize ( String [] old ) { 
	data = new String [ old.length * 2 + 1 ];
	for ( int i = 0 ; i < old.length ; i++ ) {
	    data[i] = old[i];
	}
	size = old.length;
    }
    
    public void clear ( ) {
	data = new String [10];
	size = 0;
    }

    public int size ( ) {
	return size;
    }
    
    public boolean add ( String element ) {
	sizeCheck( );
	data[size] = element;
	size++;
	return true;
    }
    
    public String toString ( ) {
	if ( size == 0 ) {
	    return "[]";
	}
	String output = "[";
	for ( int i = 0 ; i < size - 1 ; i++ ) {
	    output = output + data[i] + ", ";
	}
	return output + data[size - 1] + "]"; 
    }

    public String get ( int index ) {
	if ( index < 0 || index >= size( ) ) {
	    throw new IndexOutOfBoundsException( );
	}
	return data[index];
    }

    public String set ( int index , String element ) {
	if ( index < 0 || index >= size( ) ) {
	    throw new IndexOutOfBoundsException( );
	}
	String old = data[index];
	data[index] = element;
	return old; 
    }

    public boolean contains ( String element ) {
	for ( int i = 0 ; i < size ; i++ ) {
	    if ( data[i].equals( element ) ) {
		return true;
	    }
	}
	return false;
    }

    public int indexOf ( String element ) {
	for ( int i = 0 ; i < size ; i++ ) {
	    if ( data[i].equals( element ) ) {
		return i;
	    }
	}
	return -1;
    }

    public int lastIndexOf ( String element ) {
	for ( int i = size - 1 ; i > 0 ; i-- ) {
	    if ( data[i].equals( element ) ) {
		return i;
	    }
	}
	return -1;
    }

    public void add ( int index , String element ) {
	sizeCheck ( );
	if ( index < 0 || index > size( ) ) {
	    throw new IndexOutOfBoundsException ( );
	}
	else {
	    for ( int i = size( ) - 1 ; i >= index ; i-- ) {
		data[i + 1] = data[i];
	    }
	    data[index] = element;
	    size++;
	}
    }

    public String remove ( int index ) {
	if ( index < 0 || index >= size( ) ) {
	    throw new IndexOutOfBoundsException ( );
	}
	else {
	    String removed = get( index );
	    for ( int i = index ; i < size ; i++ ) {
		data[i] = data[i + 1];
	    }
	    size--;
	    return removed;
	}
    }

    public boolean remove ( String element ) { // there probably is a more elegant way to go about this
	String excuseToRunRemoveWithIndex = remove ( indexOf ( element ) );
	return true;
    }

    public SuperArrayIterator iterator ( ) {
    	return new SuperArrayIterator ( data );
    }

    private class SuperArrayIterator implements Iterator<Integer> {
    	int index;
    	public SuperArrayIterator ( String[] data ) {
    		this.data = data;
    		index = 0;
    	}

    	public Integer next ( ) {
    		if ( hasNext ( ) ) {
    			index++;
    		}
    		else {
    			System.exit( 0 );
    		}
    		return data[index - 1];
    	}

    	public boolean hasNext ( ) {
    		return index < data.length;
    	}

    }
    
}
