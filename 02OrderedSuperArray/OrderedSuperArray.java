public class OrderedSuperArray extends SuperArray {
    
    public OrderedSuperArray ( ) {
	new OrderedSuperArray ( 10 );
    }

    public OrderedSuperArray ( int capacity ) {
	super ( capacity );
    }

    public boolean add ( String element ) {
	super.add ( indexSearchBinary ( element ) , element );
	return true;
    }

    public void add  ( int index , String element ) {
	add( element );
    }

    private int indexSearch ( String element ) {
	if ( size( ) == 0 ) {
	    return 0;
	}
	for ( int i = 0 ; i < size( ) ; i++ ) {
	    if ( element.compareTo( get( i ) ) <= 0 ) {
		return i;
	    }
	}
	return size( );
    }
    
    private int indexSearchBinary ( String element ) {
	int start = 0;
	int end = size( ) - 1;
	int i;
	if ( end == -1 ) { //there is probably a more elegant way
	    return 0;      //to go about these cases
	    }
	if ( element.compareTo( get( end ) ) > 0 ) {
	    return size( );
	}
	while ( start != end ) {
	    i = ( start + end ) / 2;
	    if ( element.compareTo( get( i ) ) > 0 ) {
		if ( start == i ) {
		    start++;
		}
		else {
		    start = i;
		}
	    }
	    else if ( element.compareTo( get( i ) ) < 0 ) {
		end = i;
	    }
	    else {
		return i;
	    }
	}
	return start;
    }

    public String set ( int index , String element ) {
	throw new UnsupportedOperationException ( );
    }
}
