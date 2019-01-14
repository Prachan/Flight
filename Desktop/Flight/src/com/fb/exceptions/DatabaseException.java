package com.fb.exceptions;

public class DatabaseException extends Exception {
	
	public DatabaseException(String message)
	{
		super(message);
	}
	
	public DatabaseException(Throwable throw1)
	{
		super(throw1);
	}

}
