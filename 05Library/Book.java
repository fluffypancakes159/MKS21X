class Book {

    private String author;
    private String title;
    private String isbn;

    public Book ( ) {
	this ( "Dr. Seuss" , "The Cat in the Hat" , "00-000-0-000" );
    }

    public Book ( String author , String title, String isbn ) {
	this.author = author;
	this.title = title;
	this.isbn = isbn;
    }
    
    public String getAuthor ( ) {
	return author;
    }
    
    public String getTitle ( ) {
	return title;
    }

    public String getNum ( ) {
	return isbn;
    }

    public void setAuthor ( String author ) {
	this.author = author; 
    }
    
    public void setTitle ( String title ) {
	this.title = title; 
    }
    
    public void setNum ( String isbn ) {
	this.isbn = isbn; 
    }

    public String toString ( ) {
	return "Author: " + author + "\nTitle: " + title + "\nISBN: " + isbn;
    }
    
}
