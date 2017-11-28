abstract class LibraryBook extends Book implements Comparable<LibraryBook> {

    private String callNum;

    public LibraryBook ( String author , String title , String isbn , String callNum ) {
	this.author = author;
	this.title = title;
	this.isbn = isbn;
	this.callNum = callNum;
    }

    public String getCallNum ( ) {
	return callNum;
    }
}
