
public class ArrayStack<T> implements Stack<T>{
	protected int SIZE = 10;
	protected T[] arr;
	protected int top;
	public ArrayStack(){
		arr = (T[]) new Object[SIZE];
		top = -1;
	}
	//add to top
	public void push(T item) {
		if(top==arr.length-1){
			grow_array();
		}
		arr[++top] = item;
	}
	//take first off
	public T pop() {
		try{				
			if(empty()){
				throw new Exception("Error!");
			}
		}catch(Exception e){
			System.out.println("Empty queue!");
		}
		return arr[top --];
	}
	//pop & push & make a copy
	public T peek() {
		try{
			if(empty()){
				throw new Exception("Error!");
			}
		}catch(Exception e){
			System.out.println("Empty queue!");
		}
		return arr[top];
	}
	//check if empty
	public boolean empty() {			
		if(top == -1)
			return true;
		return false;
	}
	
	void grow_array() {
		T[] temp = (T[]) new Object[arr.length*2];
		for(int i =0; i<arr.length; i++)
			temp[i] = arr[i];
		arr = temp;
	}

}