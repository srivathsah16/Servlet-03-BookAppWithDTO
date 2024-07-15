package in.srivath.dto;

public class BookDto {
	private int bookId;
	private String bookName;
	private int bookPrice;

	public BookDto() {
		System.out.println("Book::constructor");
	}

	public BookDto(int bookId, String bookName, int bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String toString() {
		return "Book [ bookId = " + bookId + ",bookName = " + bookName + ", bookPrice = " + bookPrice + "]";
	}

}
