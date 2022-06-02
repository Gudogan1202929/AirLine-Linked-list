package application;

public class LinkedList<T extends Comparable<T>> {

	private Snode<T> head;

	public Snode<T> getHead() {
		return head;
	}

	public void setHead(Snode<T> head) {
		this.head = head;
	}

	public void insertion(T data) {

		Snode<T> temb = new Snode<T>(data);
		Snode<T> prev = null;
		Snode<T> curr = head;

		for (; curr != null && curr.getData().compareTo(data) < 0; prev = curr, curr = curr.getNext())
			;

		if (head == null) {
			head = temb;
		} else if (prev == null) {
			temb.setNext(head);
			head = temb;
		} else if (curr == null) {
			prev.setNext(temb);
		} else {
			temb.setNext(curr);
			prev.setNext(temb);
		}
	}

	public void delete(T data) {

		Snode<T> prev = null;
		Snode<T> curr = head;

		if (head == null) {
			System.out.println("thats linked is empty");
			return;
		}

		for (; curr != null && curr.getData().compareTo(data) < 0; prev = curr, curr = curr.getNext())
			;

		if (curr == null) {
			System.out.println(" not exist");
		}
		if (curr.getData().equals(data)) {
			if (curr == head) {
				head = head.getNext();
			} else
				prev.setNext(curr.getNext());
		} else
			System.out.println("not exist");
	}

	public Snode<T> search(T data) {

		Snode<T> curr = head;

		for (; curr != null && curr.getData() != data; curr = curr.getNext())
			;
		if (curr == null) {
			System.out.println("not found");
		}
		return curr;
	}

	public void show() {
		System.out.print("Head->");
		Snode<T> n = head;

		while (n != null) {

			System.out.print(n.getData() + "->");
			n = n.getNext();

		}
		System.out.println("null");

	}

	public String display() {

		String s = "";
		Snode<T> n = head;

		while (n != null) {

			s = s + n.getData() + "\n";
			n = n.getNext();

		}
		return s;

	}

}
