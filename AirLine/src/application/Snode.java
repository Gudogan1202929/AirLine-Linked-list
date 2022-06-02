package application;

public class Snode<T extends Comparable<T>> {

	private Snode<T> next;
	private T data;

	public Snode(T data) {
		super();
		this.data = data;
	}

	public Snode<T> getNext() {
		return next;
	}

	public void setNext(Snode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
