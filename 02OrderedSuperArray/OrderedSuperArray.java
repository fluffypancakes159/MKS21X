public class OrderedSuperArray extends SuperArray {
    
	public static void main(String[] args) {
		OrderedSuperArray A = new OrderedSuperArray ( 100 );
		for(int i = 0; i < 100;   i ++){
      	    String v = ""+(int)(Math.random()*100);
      	    A.add(v);
      	    // System.out.println( A );
     	}
     	System.out.println( A );
	}

    public OrderedSuperArray ( ) {
		new OrderedSuperArray ( 10 );
    }

    public OrderedSuperArray ( int capacity ) {
	super ( capacity );
    }

    public OrderedSuperArray ( String [] stuff ) {
    	new OrderedSuperArray ( stuff.length );
    	for ( int i = 0 ; i < stuff.length ; i++ ) {
    		add( stuff[i] );
    	}
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
		while ( start <= end ) {
		    i = ( start + end ) / 2;
		    if ( element.compareTo( get ( i ) ) > 0 ) {
				start = i + 1;
	 	    }
		    else if ( element.compareTo( get ( i ) ) < 0 ) {
				end = i - 1;
		    }
	  	    else {
				while ( i > 0 && get ( i - 1 ) == element ) { 
					i -= 1;
				}
				return i;
	  		}
		}
		return start;
    }

    public String set ( int index , String element ) {
		throw new UnsupportedOperationException ( );
    }
}
