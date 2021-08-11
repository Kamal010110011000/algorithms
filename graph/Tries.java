package graph;

public class Tries {

	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		boolean isEndOfWord;
		
		public TrieNode() {
			isEndOfWord = false;
			for(int i=0; i<ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	};
	
	static TrieNode root;
	
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		
		TrieNode pNode = root;
		for(level =0; level<length; level++) {
			index = key.charAt(level) - 'a';
			if(pNode.children[index] == null) {
				pNode.children[index] = new TrieNode();
			}
			pNode = pNode.children[index];
		}
		
		pNode.isEndOfWord = true;
	}
	
	static boolean search(String key) {
		int length = key.length();
		int index;
		TrieNode node = root;
		for(int level =0; level<length; level++) {
			index = key.charAt(level)-'a';
			if(node.children[index] == null)
				return false;
			node = node.children[index];
		}
		return (node.isEndOfWord);
	}
	
	public static void main(String[] args) {
		String[] keyStrings = {"the", "a", "there", "answer", "any", "by","bye", "their"};
		String[] outputStrings = {"Not present in trie", "present in trie"};
		
		root = new TrieNode();
		
		for(int i=0; i<keyStrings.length; i++) {
			insert(keyStrings[i]);
		}
		if(search("the") == true)
            System.out.println("the --- " + outputStrings[1]);
        else System.out.println("the --- " + outputStrings[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + outputStrings[1]);
        else System.out.println("these --- " + outputStrings[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + outputStrings[1]);
        else System.out.println("their --- " + outputStrings[0]);
         
        if(search("thaw") == true)
            System.out.println("thaw --- " + outputStrings[1]);
        else System.out.println("thaw --- " + outputStrings[0]);
		
		
	}
}
