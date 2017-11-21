import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Random randgen = new Random ( );
		if ( args.length < 3 || args.length > 5 ) {
			System.out.println ( "You must enter arguments in the following order: \n\n java Driver -rows- -columns- -txt file- -seed- -key- \n seed and key are optional" );
		}
		else {
			if ( args.length == 3 ) {
				WordSearch A = new WordSearch ( Integer.parseInt ( args[0] ) , Integer.parseInt ( args[1] ) , args[2] );
				System.out.println ( A );
			}
			else if ( args.length == 4 ) {
				WordSearch A = new WordSearch ( Integer.parseInt ( args[0] ) , Integer.parseInt ( args[1] ) , args[2] , Integer.parseInt ( args[3] ) );
				System.out.println ( A );
			}
			else if ( args.length == 5 ) {
				WordSearch A = new WordSearch ( Integer.parseInt ( args[0] ) , Integer.parseInt ( args[1] ) , args[2] , Integer.parseInt ( args[3] ) , args[4] );
				System.out.println ( A );
			}
		}
		System.out.println ( randgen.nextInt( ) % 2 );
	}
}