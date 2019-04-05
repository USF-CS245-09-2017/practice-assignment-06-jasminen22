
public class ArrayQueue<T> implements Queue<T>{
	protected int SIZE = 10;
	protected int count = 0;
	protected T[] arr;
	protected int head, tail;
	public ArrayQueue(){
		head = 0;
		tail = 0;
		arr = (T[]) new Object[SIZE];
	}
	//remove from front of queue
	public T dequeue() {
		try{
			if(empty()){
					throw new Exception("Error!");	
			}
		}
		catch(Exception e){
			System.out.println("Empty queue!");
		}
		

		T temp = arr[head];
		head = (head+1)%arr.length;
		if(head >= arr.length){
			head=0;
		}
		count--;
		return temp;
	}
	//insert at rear
	public void enqueue(T item) {
		//… if array is full, grow …
		//need to keep one slot open at the end to be able to check if array is full
		if(count==arr.length){
			grow_array();
		}	

		arr[tail++] = item;
		tail = tail%arr.length;
		count ++;
	}
	//check if empty
	public boolean empty() {
		if(head == tail)
			return true;
		return false;
	}
	private void grow_array() {
		T[] temp = (T[]) new Object[arr.length*2];
		for(int i =0; i<arr.length; i++)
			temp[i] = arr[i];
		arr = temp;
		head = 0;
		tail = count; //these make the palindrome incorrect
	}

}