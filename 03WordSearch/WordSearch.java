import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch {

	private int seed;
	private char[][] data;
    private Random randgen;
    private ArrayList<String>wordsToAdd = new ArrayList<String>( );
    private ArrayList<String>wordsAdded = new ArrayList<String>( );
    

	public WordSearch ( int rows , int cols , String wordFile ) {
		this ( rows , cols , wordFile , (int)(Math.random ( ) * 23978.0 ) , "" );
	}

	public WordSearch ( int rows , int cols , String wordFile , int seed ) {
		this ( rows , cols , wordFile , seed , "" );
	}

	public WordSearch ( int rows , int cols , String wordFile , int seed , String key ) {
		this.seed = seed;
		randgen = new Random ( this.seed );
		data = new char[rows][cols];
		for ( int i = 0 ; i < rows ; i++ ) {
			for ( int j = 0 ; j < cols ; j++ ) {
				data[i][j] = '_';
			}
		}
		wordInit ( wordFile ); 
		addAllWords ( );
		if ( !key.equals( "key" ) ) {
			fillIn ( );
		}
	}

	private void wordInit ( String wordFile ) {
    	try {			
     	    File file = new File ( wordFile );
    		Scanner in = new Scanner ( file );

        	while ( in.hasNext( ) ) {
      		    String word = in.next( );
      		    // System.out.println( word );
        		wordsToAdd.add( word );
      			// System.out.println( word );
			}
			// System.out.println ( wordsToAdd );
    	} 
    	catch ( FileNotFoundException e ){
     		System.out.println( "File not found: " + wordFile );
     		//e.printStackTrace();
     		System.exit( 1 );
   	  	}
	}

	private boolean addAllWords ( ) {
		int counter = 0;
		while ( counter < 50 || wordsToAdd.size( ) == 0 ) {
			for ( int i = 0 ; i < wordsToAdd.size( ) ; i++ ) {
				// System.out.println ( wordsToAdd );
				// System.out.println ( wordsAdded );
				if ( addWord ( wordsToAdd.get( i ) ) ) {
					if ( wordsToAdd.size( ) == 1 ) {
						wordsAdded.add ( wordsToAdd.get ( 0 ) );
						wordsToAdd.remove ( 0 );
						return true;
					}
					else {
						wordsAdded.add ( wordsToAdd.get( i ) );
						wordsToAdd.remove ( i );
						// printArray ( data );
					}
				}
			}
			counter++;
		}
		return true;
	}

	private boolean addWord ( String word ) {
		int row = Math.abs ( randgen.nextInt( ) % data.length );
		int col = Math.abs ( randgen.nextInt( ) % data[0].length);
		int rowInc = randgen.nextInt( ) % 2;
		int colInc = randgen.nextInt( ) % 2;
		while ( rowInc == 0 && colInc == 0 ) {
			rowInc = randgen.nextInt( ) % 2;
		    colInc = randgen.nextInt( ) % 2;
		}
		if ( wordCheck ( word , row , col , rowInc , colInc ) ) {
			/* System.out.println ( row );
			System.out.println ( col );
			System.out.println ( rowInc );
			System.out.println ( colInc ); */
			for ( int i = 0 ; i < word.length ( ) ; i++ ) {
				data[row][col] = word.charAt( i );
				row += rowInc;
				col += colInc;
			}
		}
		else {
			return false;
		}
		// printArray ( data );
		return true;
	}

	private boolean wordCheck ( String word , int row , int col , int rowInc , int colInc) {
		int currentRow = row;
		int currentCol = col;
		for ( int i = 0 ; i < word.length ( ) ; i++ ) {
			try {
				if ( ( word.charAt ( i ) != data[currentRow][currentCol] &&
					data[currentRow][currentCol] != '_' )                || 
					currentRow < 0 ||
					currentRow > data.length ||
					currentCol < 0 ||
					currentCol > data[0].length ) {
					return false;
				}
			}
			catch ( ArrayIndexOutOfBoundsException e ) {
				// System.out.println ( "Array Index Out of Bounds for: " + word);
				return false;
			}
			currentRow += rowInc;
			currentCol += colInc;
		}
		// System.out.println ( "Word: " + word + " is good!" );
		return true;
	}

	private void fillIn ( ) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for ( int i = 0 ; i < data.length ; i++ ) {
			for ( int j = 0 ; j < data[i].length ; j++ ) {
				if ( data[i][j] == '_' ) {
					data[i][j] = alphabet.charAt( Math.abs ( randgen.nextInt( ) % 26 ) );
				}
			}
		}
	}

	private void clear ( ) {
		for ( int i = 0 ; i < data.length ; i++ ) {
			for ( int j = 0 ; j < data[i].length ; j++ ) {
				data[i][j] = '_';
			}
		}
	}

	public String toString ( ) {
		String output = "";
		for ( int i = 0 ; i < data.length ; i++ ) {
			for ( int j = 0 ; j < data[i].length ; j++ ) {
				output += data[i][j] + " ";
			}
			output += "\n";
		}
		output += "Words to find: " + wordsAdded + "\n";
		output += "Seed: " + seed;
		return output;
	}

	private void printArray ( char[][] ary ) { // helper
		String output = "";
		for ( int i = 0 ; i < data.length ; i++ ) {
			for ( int j = 0 ; j < data[i].length ; j++ ) {
				output += data[i][j] + " ";
			}
			output += "\n";
		}
		System.out.println ( output );
	}
}
