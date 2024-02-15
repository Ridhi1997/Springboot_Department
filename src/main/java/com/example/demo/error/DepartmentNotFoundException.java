package com.example.demo.error;

 
 
public class DepartmentNotFoundException extends Exception {

	private String message;
	 
    public DepartmentNotFoundException() {}
 
    public DepartmentNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
