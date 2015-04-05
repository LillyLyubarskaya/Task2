package LinkedList;

import java.time.LocalDateTime;

public class Node<E> {
	private E object;
	private LocalDateTime LocalDateTime;
	private Node<E> prev;
	private Node<E> next;
	public E getObject() {
		return object;
	}
	public void setObject(E object) {
		this.object = object;
	}
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime;
	}
	public void setLocalDateTime(LocalDateTime LocalDateTime) {
		this.LocalDateTime = LocalDateTime;
	}
	public Node (E obj,LocalDateTime LocalDateTime,Node<E> prev,Node<E> next){
		setObject(obj);
		setLocalDateTime(LocalDateTime);
		setLinks(prev,next);
	}
	public Node (E obj,LocalDateTime LocalDateTime){
		setObject(obj);
		setLocalDateTime(LocalDateTime);
	}
	public void setLinks(Node<E> prev,Node<E> next){
		this.prev=prev;
		this.next=next;
	}
	public Node(){}
	public Node<E> getPrev() {
		return prev;
	}
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	};

	

}
