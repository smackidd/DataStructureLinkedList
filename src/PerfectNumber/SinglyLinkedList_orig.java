package PerfectNumber;

public class SinglyLinkedList_orig {
	Node head;
	
	public SinglyLinkedList_orig() {
		head = null;
	}

	
	public boolean listIsEmpty() {
		if(head == null) return true;
		return false;
	}
	
	public void appendNode(int val) {
		Node newNode = new Node();
		newNode.value = val;
		if (listIsEmpty()) {
			head = newNode;
		}
		else {
			Node tmpNode = head;
			while(tmpNode.next != null) {
				tmpNode = tmpNode.next;
			}
			tmpNode.next = newNode;
		}
	}
	
	public void insertAfterSNode(int sVal, int newVal) {
		Node newNode = new Node();
		Node prevNode; 
		newNode.value = newVal;
		if(listIsEmpty()) {
			appendNode(newVal);
		} else {
			Node tmpNode = head;
			prevNode = null;
			while(tmpNode != null && tmpNode.value != sVal) {
				prevNode = tmpNode;
				tmpNode = tmpNode.next;
			}
			if(tmpNode != null) {
				newNode.next = tmpNode.next;
				tmpNode.next = newNode;
			} else {
				prevNode.next = newNode;
			}
		}
	}
	
	public void insertAt(int index, int newVal) {
		Node newNode = new Node();
		Node prevNode;
		newNode.value = newVal;
		if(listIsEmpty()) {
			appendNode(newVal);
		} else {
			Node tmpNode = head;
			prevNode = null;
			for(int i = 0; i < index; i++) {
				prevNode = tmpNode;
				tmpNode = tmpNode.next;
				if (tmpNode == null) {
					prevNode.next = newNode;
					break;
				}
			}
			newNode.next = tmpNode;
			if (prevNode != null) {
				prevNode.next = newNode;
			} else {
				head = newNode;
			}
			
		}
	}
	
	public boolean deleteNode(int dVal) {
		if(listIsEmpty()) return false;
		
		if(head.value == dVal) {
			head=head.next;
			return true;
		} else {
			Node cNode = head.next;
			Node pNode = head;
			while (cNode != null && cNode.value != dVal){
				pNode = cNode;
				cNode = cNode.next;
			}
			if(cNode != null) {
				pNode.next = cNode.next;
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		Node start = head;
		String str = "";
		if (start == null) return "List Empty";
		while(start.next != null) {
			//System.out.print(start.value + " -> ");
			str += start.value + " -> ";
			start = start.next;
		}
		str += start.value + "";
		
		return str;
	}
}
