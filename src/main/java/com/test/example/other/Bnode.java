package com.test.example.other;

public class Bnode {

	private int val;
	private Bnode left;
	private Bnode right;
	
	Bnode(int val,Bnode left,Bnode right){
		this.val=val;
		this.left=left;
		this.right=right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Bnode getLeft() {
		return left;
	}

	public void setLeft(Bnode left) {
		this.left = left;
	}

	public Bnode getRight() {
		return right;
	}

	public void setRight(Bnode right) {
		this.right = right;
	}
	
	
}
