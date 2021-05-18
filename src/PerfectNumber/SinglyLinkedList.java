package PerfectNumber;

public class SinglyLinkedList implements IList{
	

		Node head;
		
		public SinglyLinkedList() {
			head = null;
		}
		
		public boolean listIsEmpty() {
			if(head == null) return true;
			return false;
		}
		
		@Override
		public void add(int item) {
			Node newNode = new Node();
			newNode.value = item;
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

		@Override
		public void add(int index, int item) {
			Node newNode = new Node();
			Node prevNode;
			newNode.value = item;
			if(listIsEmpty()) {
				add(item);
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

		@Override
		public void clear() {
			head = null;
		}

		@Override
		public int indexOf(int item) {
			Node newNode = new Node();
			Node prevNode;
			int index;
			if (listIsEmpty()) return -1;
			else {
				newNode = head;
				index = 0;
				while(newNode != null) {
					if(newNode.value == item) {
						break;
					} else {
						prevNode = newNode;
						newNode = newNode.next;
						index++;
					}
				}
				if (newNode == null) return -1;
			}
			return index;
		}

		@Override
		public int get(int index) {
			Node newNode = new Node();
			if (listIsEmpty() || index < 0) return -1;
			else {
				newNode = head;
				for (int i = 0; i < index; i++) {
					newNode = newNode.next;
					if(newNode == null) return -1;
				}
			}
			return newNode.value;
		}

		@Override
		public boolean remove(int index) {
			Node newNode = new Node();
			Node prevNode = null;
			if (listIsEmpty() || index < 0) return false;
			else {
				newNode = head;
				for (int i = 0; i < index; i++) {
					prevNode = newNode;
					newNode = newNode.next;
					if (newNode == null) return false;
				}
				if (newNode == head) {
					head = head.next;
				} else {
					prevNode.next = newNode.next;
				}
				return true;
			}
		}

		@Override
		public boolean removeAll(int item) {
			Node newNode = new Node();
			boolean removedItem = false;
			if(listIsEmpty()) return false;
			else {
				newNode = head;
				int index = 0;
				while (newNode != null) {
					if(newNode.value == item) {
						removedItem = remove(index);
						//if item is removed, index must remain the same to account for the shift
						//of items after the removed items.
					} else {
						index++;
					}
					newNode = newNode.next;
				}
			}
			return removedItem;
		}

		@Override
		public int size() {
			Node newNode = new Node();
			int size = 0;
			if (listIsEmpty()) return size;
			newNode = head;
			while(newNode != null) {
				size++;
				newNode = newNode.next;
			}
			return size;
		}

		@Override
		public void reverse() {
			Node newNode = new Node();
			int lastIndex = size() - 1;
			
			for (int i = 0; i <= lastIndex; i++) {
				newNode.value = get(lastIndex);
				add(i, newNode.value);
				//remove the last item. Because we just added, size has increased by 1
				//so remove lastIndex + 1;
				remove(lastIndex + 1);
			}
			
		}

		@Override
		public void sort() {
			Node tmpNode = new Node();
			int size = size();
			for (int i = 0; i < size - 1; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (get(j) > get(j + 1)) {
						tmpNode.value = get(j + 1);
						add(j, tmpNode.value);
						remove(j + 2);
					}
				}
			}
		}
		
		public String toString()
		{
			Node start=head;
			String str="";
			if(start==null) return "List Empty!";
			while(start.next!=null)
			{
				str+=start.value+" -> ";
				start=start.next;
			}
			str+=start.value+".";	
			return "List items: "+str;
		}
	
}
