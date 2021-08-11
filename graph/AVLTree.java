package graph;

class Node{
	int key, height;
	Node left, right;
	public Node(int d) {
		key = d;
		height = 1;
	}
}

public class AVLTree {
	Node rootNode;
	
	int height(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	int max(int a, int b) {
		return (a>b)?a:b;
	}
	
	Node rightRotate(Node y) {
		Node xNode = y.left;
		Node T2 = xNode.right;
		
		xNode.right = y;
		y.left = T2;
		
		y.height = max(height(y.left), height(y.right)) +1;
		xNode.height = max(height(xNode.left), height(xNode.right))+1;
		
		return xNode;
	}
	Node leftRotate(Node x) {
		Node yNode = x.right;
		Node T2 = yNode.left;
		
		yNode.left = x;
		x.right = T2;
		
		x.height = max(height(x.left), height(x.right)) +1;
		yNode.height = max(height(yNode.left), height(yNode.right))+1;
		
		return yNode;
	}
	
	int getBalance(Node n) {
		if(n == null) {
			return 0;
		}
		
		return height(n.left) - height(n.right);
	}
	
	Node insertNode(Node node, int key) {
		if(node == null)
			return (new Node(key));
		
		if(key<node.key)
			node.left = insertNode(node.left, key);
		else if(key> node.key) 
			node.right = insertNode(node.right, key);
		else {
			return node;
		}
		
		node.height = 1+max(height(node.left), height(node.right));
		
		int balance = getBalance(node);
		
		if(balance>1 && key<node.left.key)
			return rightRotate(node);
		if(balance <- 1 && key<node.right.key)
			return leftRotate(node);
		if(balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && key < node.right.key) {
			node.right = rightRotate((node.right));
			return leftRotate(node);
		}
		
		return node;
	}
	
	void preOrder(Node node) {
		if(node!=null) {
			System.out.print(node.key+" ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		
		tree.rootNode = tree.insertNode(tree.rootNode, 10);
		tree.rootNode = tree.insertNode(tree.rootNode, 20);
        tree.rootNode = tree.insertNode(tree.rootNode, 30);
        tree.rootNode = tree.insertNode(tree.rootNode, 40);
        tree.rootNode = tree.insertNode(tree.rootNode, 50);
        tree.rootNode = tree.insertNode(tree.rootNode, 25);
        
        System.out.println("Preorder traversal of constructed tree is:");
        tree.preOrder(tree.rootNode);
	}

}
