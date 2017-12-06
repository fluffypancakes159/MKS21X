public class Driver {
	public static void main(String[] args) {
		Barcode A = new Barcode ( "12345" );
		Barcode B = new Barcode ( "54321" );
		Barcode C = new Barcode ( "00203" );
		System.out.println ( A );
		System.out.println ( A.getZip( ) );
		System.out.println ( A.getBar( ) );
		System.out.println ( A.equals( B ) );
		System.out.println ( A.toBar( ) );
		System.out.println ( C );
		System.out.println ( Barcode.toZip ( A.toBar( ) ) );
		Barcode D = new Barcode ( "10fh2" );

	}
}