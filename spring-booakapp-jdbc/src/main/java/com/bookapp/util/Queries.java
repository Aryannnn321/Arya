

package com.bookapp.util;

public class Queries {
	
	public static final String INSERTQUERY = "INSERT INTO BOOK VALUES(?,?,?,?,?,?)";
	public static final String UPDATEQUERY = "UPDATE BOOK SET price=? where book_id=?";
	public static final String DELETEQUERY = "DELETE FROM BOOK where book_id=?";
	public static final String SELECTQUERY="SELECT *FROM BOOK";
	public static final String SELECTBYAUTHORQUERY="SELECT * FROM BOOK WHERE author=?";
	public static final String SELECTBYPRICEQUERY="SELECT * FROM BOOK WHERE price<?";
	public static final String SELECTBYAUTHCATQUERY="SELECT * FROM BOOK WHERE author=?&& category=?";
	public static final String SELECTBYIDQUERY="SELECT * FROM BOOK WHERE book_id=?";

	
}
