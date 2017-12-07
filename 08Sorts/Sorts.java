import java.util.Arrays;

public class Sorts {

	public static String name ( ) {
		return "09.Diep.Ciaran";
	}

	public static void swap ( int[] ary , int a , int b ) {
		int temp = ary[a];
		ary[a] = ary[b];
		ary[b] = temp;
	}

	public static void selectionSort ( int[] data ) {
		for ( int j = 0 ; j < data.length ; j++ ) {
			int lowestIndex = j;
			for ( int i = j ; i < data.length ; i++ ) {
				if (data[i] < data[lowestIndex] ) {
					lowestIndex = i;
				}	
			}	
			swap ( data , lowestIndex , j );
			// System.out.println( Arrays.toString( data ) );
		}	
	}

	public static void insertionSort ( int[] data ) {
		for ( int i = 0 ; i < data.length ; i++ ) {
			for ( int j = i ; j > 0 ; j-- ) {
				if ( data[j] < data[j - 1] ) {
					swap ( data , j , j - 1 );
					// System.out.println( Arrays.toString( data ) );
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 13 , 14 , 5 , 18 , (int)(Math.random( ) * 27) };
		int[] B = { 13 , 14 , 5 , 18 , (int)(Math.random( ) * 27) };
		System.out.println( Arrays.toString( A ) );
		selectionSort ( A );
		System.out.println( Arrays.toString( A ) );
		System.out.println( "" );
		System.out.println( Arrays.toString( B ) );
		insertionSort ( B );
		System.out.println( Arrays.toString( B ) );
	}
}