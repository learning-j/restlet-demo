package com.dengshaolin.db.exception;

public class NotFoundException extends DAOException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(Class<?> clazz, int objId) {
		super(String.format("Object [%s %s] does not find in DB.", clazz.getSimpleName(), objId));
	}	
}
