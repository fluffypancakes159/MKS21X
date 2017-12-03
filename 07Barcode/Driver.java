public class Driver {
	public static void main(String[] args) {
		Barcode A = new Barcode ( 12345 );
		Barcode B = new Barcode ( 54321 );
		System.out.println ( A );
		System.out.println ( A.getZip( ) );
		System.out.println ( A.getBar( ) );
		System.out.println ( A.equals( B ) );
	}
}