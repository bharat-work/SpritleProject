package com.spritle.model;

public class DisplayTable {
	private String masterName;
	private String studName;
	private String left;
	private String operation;
	private String right;
	private String studentOrMasterName;
	
	public String getStudentOrMasterName() {
		return studentOrMasterName;
	}

	public void setStudentOrMasterName(String studentOrMasterName) {
		this.studentOrMasterName = studentOrMasterName;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public DisplayTable() {
		super();
	}

	public DisplayTable(String studentOrMasterName, String left, String operation, String right) {
		super();
		this.studentOrMasterName = studentOrMasterName;
		this.left = left;
		this.operation = operation;
		this.right = right;
	}

	public DisplayTable(String masterName, String studName, String left, String operation, String right) {
		super();
		this.masterName = masterName;
		this.studName = studName;
		this.left = left;
		this.operation = operation;
		this.right = right;
	}
}
