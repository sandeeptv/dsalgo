package com.test.example.other;

public class MyLinkedList<T> {

	private Node head;
	//private Node tail;
	private Node currNode;
	
	public void addFirst(int val){
		
		Node node = new Node(val);
		head = node;
		currNode= node;
	}
	
	public void add(int val){
		Node node = new Node(val);
		if(head==null){
			head = node;
		}else{
			currNode.setNext(node);
			
		}
		currNode = node;
	}
	
	public void remove(int val){
		Node currNode = head;
		Node previousNode = null ;
		while(currNode!=null){
			
			if(currNode.getValue()==val){
				Node tempNode = currNode.getNext();
				currNode = null;
				if(previousNode==null){
					head = tempNode;
				}else{
				previousNode.setNext(tempNode);
				}
			}else{
				previousNode=currNode;
				currNode = currNode.getNext();
			}
		}
		
	}
	
	public void removeByIndex(int ind) throws ArrayIndexOutOfBoundsException{
		Node currNode = head;
		Node previousNode = null ;
		for(int i=0;i<ind;i++){
			
			if(currNode.getNext()==null){
				throw new ArrayIndexOutOfBoundsException(ind);
			}
			previousNode=currNode;
			currNode = currNode.getNext();
		}
		if(previousNode==null){
			head = currNode.getNext();
		}else{
		previousNode.setNext(currNode.getNext());
		}
	}
/*	public void addLast(int val){
		Node node = new Node(val);
		tail = node;
		currNode.setNext(node);
	}*/
	
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	/*public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}*/

	public Node getCurrNode() {
		return currNode;
	}

	public void setCurrNode(Node currNode) {
		this.currNode = currNode;
	}
	
}
