package PerfectNumber;
/*please do not modify a single character from this java file */
public interface IList{
	void add(int item);  //adds an item at the end of the list 
	void add(int index, int item);  //adds an item at a position specified by the index, if index goes outside list size, the program adds the item at the end of the list 
	void clear();   //clears the entire list and list size becomes 0
	int indexOf(int item);  //returns an items position (index value) from the list
	int get(int index);     //gets an item from the list specified by the index value, return -1/null if item is not found
	boolean remove(int index);   //removes an item specified by the index value and returns a boolean (successful or failed when value not exists)
	boolean removeAll(int item); // removes all occurrences of item from the list and returns a boolean (successful when at-least one item removed or failed when value not exists)
	int size();            //returns the size of the list
	void reverse();        //reverses the entire list
	void sort();           //sorts the contents of the list in ascending order
	String toString();     //displays the entire list
}