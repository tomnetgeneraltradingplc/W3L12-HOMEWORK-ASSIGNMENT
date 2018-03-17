package Problem_1;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
// Demo code for the user implemenation of Binary search tree
public class MyBST {
	/** The tree root. */
	private BinaryNode root;
	int size = 0;

	public MyBST() {
		root = null;
	}
	//Size
	public int size(){
		return size;
	}
	
	/**
	* Prints the values in the nodes of the tree
	* in sorted order. Inorder Traversal
	*/
	public void Inorder() {
		if( root == null )
			System.out.println( "Empty tree" );
		else
			Inorder(root);
	}
	// Inorder Traversal to print the nodes in Ascending order
	private void Inorder( BinaryNode t ){
		if( t != null ){
			Inorder( t.left );
		    System.out.print(t.element+",");
		    Inorder( t.right );
		} 
	}
	// preOrder Traversal to print the nodes in Ascending order
	public void preOrder(){
		preOrder(root);
		}

	private void preOrder(BinaryNode t) {// implement
		if (t != null) {
			System.out.print(t.element + ",");
			preOrder(t.left);
			preOrder(t.right);
		}
	}
	// Postorder Traversal to print the nodes in Ascending order
	public void postOrder(){
		postOrder(root);
		}

	private void postOrder(BinaryNode t) {// implement

		
		if (t != null) {

			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.element + ",");
		}
	}

	public Integer getRoot() {// implement
		if (isEmpty()) {
			System.out.println("The tree is Empty.");
			return -1;
		}
		return root.element;
	}
	
	public boolean isEmpty() {// implement
		if (root == null) {
			return true;
		}
		return false;

	} 
	
	public boolean contains(Integer key){//implement
		BinaryNode temp= root;
		while(temp!=null){
			if(key==temp.element){
				return true;}
				else if(key < temp.element)
					temp=temp.left;
				else
					temp=temp.right;
			}
		return false;
		} 
	
	
	public Integer findMin() {
		 return findMin(root);
	}
	private Integer findMin(BinaryNode t) {// implement
		if (isEmpty()) {
			System.out.println("The tree is empty");
			return -1;
		}
		
		while(t.left!=null){
			t = t.left;
		}
		return t.element;
	}
	
	public Integer findMax() {
		 return findMax(root);
	}
	private Integer findMax(BinaryNode t) {// implement
		if (isEmpty()) {
			System.out.println("The tree is empty");
			return -1;
		}
		
		while(t.right!=null){
			t = t.right;
		}
		return t.element;
	}
		
	public int leafNodes() {
		return leafNodes(root);
	}

	private int leafNodes(BinaryNode p) {// Implement
		int count=0;
		if(p!=null){
			if((p.left == null) && (p.right == null))
				count=1;
			else
				count=count+ leafNodes(p.left)+leafNodes(p.right);
		}
		return count;
		
		
	}
		
		
	
	
	
	
		
	//Assume the data in the Node is an Integer.	

	public void insert(Integer x) {
		if (root == null) {
			root = new BinaryNode(x);
			size++;
			return;
		}
		else { 
			BinaryNode n = root;
			boolean inserted = false;

			while(!inserted)//true
				{
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new BinaryNode(x,null,null);
						inserted = true;
						size++;
					}
					//keep looking for a place to insert (a null)
					else {
						n = n.left;
					}
				}				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
					n.right = new BinaryNode(x,null,null);
					inserted = true;
					size++;
					}
						//keep looking for a place to insert (a null)
					else {
							n = n.right;
					}
										
				}
				// if a node already exists
				else {
					inserted = true;
				}

			}

		}
	}
	private class BinaryNode {

		private Integer element;// The data in the node
		private BinaryNode left;      // Left child
		private BinaryNode right;     // Right child	  
		// Constructors 
		
		BinaryNode( Integer theElement ){
			this( theElement, null, null );
		}	

		BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
	}
		

	public static void main(String[] args) {
		
		MyBST mybst = new MyBST();
		
		int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25};
	
		for (int j = 0; j < a.length; j++ ) {
			mybst.insert(a[j]);
					
		}
//		
		System.out.println("Inorder: ");
		mybst.Inorder();
		System.out.println("\npreOrder: ");
		mybst.preOrder();
		System.out.println("\nPostorder: ");
		mybst.postOrder();
		System.out.println("\nRoot element is: " + mybst.getRoot());
		System.out.println("Is the Tree empety : " + mybst.isEmpty());
		System.out.println("Is the Tree contain 100 : " + mybst.contains(100));
		System.out.println("Is the Tree contain 1700 : " + mybst.contains(7));
		System.out.println("The minimum element in the tree : " + mybst.findMin());
		System.out.println("The maximum element in the tree : " + mybst.findMax());
		System.out.println("Number of leaf node: " + mybst.leafNodes());
		mybst.insert(10);
		System.out.println("Number of leaf node: " + mybst.leafNodes());
		System.out.println("Inorder list after 10 inserted: ");
		mybst.Inorder();
		System.out.println("\npreOrder list after 10 inserted: ");
		mybst.preOrder();
		System.out.println("\nPostorder list after 10 inserted: ");
		mybst.postOrder();
		System.out.println("\nSize: " + mybst.size);
//		TreeSet<Integer> ts = new TreeSet<Integer>();
//		
//		for (int j = 0; j < a.length; j++ ) {
//			ts.add(a[j]);
//			System.out.println("\nAfter inserting " + j + "th item " + a[j]);
//			Iterator<Integer> it = ts.iterator();		
//			Integer nextItem = null;
//			while(it.hasNext()) {
//				nextItem = it.next();
//				System.out.print(nextItem + " ");
//			} 
//			System.out.println();
//		}
//		
//		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
//		map.put(8, "Hello");
//		map.put(10, "World!");
//		map.put(11, "Welcome");
//		map.remove(8);
//		String str = map.get(11)+", "+ map.get(10);
//		System.out.println(str);
			
	}
}
/*Output
Inorder: 
1,2,3,9,12,15,16,19,22,25,56,100,
preOrder: 
15,12,9,1,3,2,56,16,19,22,25,100,
Postorder: 
2,3,1,9,12,25,22,19,16,100,56,15,
Root element is: 15
Is the Tree empety : false
Is the Tree contain 100 : true
Is the Tree contain 1700 : false
The minimum element in the tree : 1
The maximum element in the tree : 100
Number of leaf node: 3
Number of leaf node: 4
Inorder list after 10 inserted: 
1,2,3,9,10,12,15,16,19,22,25,56,100,
preOrder list after 10 inserted: 
15,12,9,1,3,2,10,56,16,19,22,25,100,
Postorder list after 10 inserted: 
2,3,1,10,9,12,25,22,19,16,100,56,15,
Size: 13
*/