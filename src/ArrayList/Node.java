package ArrayList;

import java.time.LocalDateTime;

public class Node<E> {
	private E object;
	private LocalDateTime LocalDateTime;
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
	public Node (E obj,LocalDateTime LocalDateTime){
		setObject(obj);
		setLocalDateTime(LocalDateTime);
	}
	public Node(){};
	

}
