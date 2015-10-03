/**
 * 
 */

/**
 * @author Sean Keeley-Cain
 *
 */
import java.io.*;
import java.util.*;
public class DLB {
	
	private Node firstNode;
	private char endChar;
	private int numWords;
	
	private class Node {
		char data;
		Node sibling,child;
		
		public Node (char c) {
			data=c;
			sibling=null;
			child=null;
		}
	}
	public DLB() throws FileNotFoundException {
		firstNode=new Node ('/');
		endChar='$';
		numWords=0;
	}
	
	public boolean addWord(String word) {
		if (word==null) {
			return false;
		}
		Node curNode=firstNode;
		for(int i=0;i<word.length();i++) {
			if (curNode.child==null) {
				curNode.child=new Node (word.charAt(i));
				curNode=curNode.child;
				//System.out.println(curNode.data);
			}
			else {
				curNode=curNode.child;
				//System.out.println(curNode.data);
				while (curNode.data!=word.charAt(i)) {
					if (curNode.sibling==null) {
						curNode.sibling=new Node (word.charAt(i));
						curNode=curNode.sibling;
						//System.out.println(curNode.data+"Sibling");
					}
					else {
						curNode=curNode.sibling;
						//System.out.println(curNode.data);
					}
				}
			}
		}
		curNode.child=new Node(endChar);
		curNode=curNode.child;
		//System.out.println(curNode.data);
		numWords++;
		return true;
	}
	public boolean search(String s) {
		Node curNode=firstNode.child;
		for (int i=0;i<s.length();i++) {
			while (curNode.data!=s.charAt(i)) {
				if (curNode.sibling==null) {
					return false;
				}
				curNode=curNode.sibling;
			}
			curNode=curNode.child;
		}
		return true;
	}
	public void printToFile() throws FileNotFoundException {
		PrintWriter fileOut=new PrintWriter(new File("my_dictionary.txt"));
		StringBuilder s=new StringBuilder();
		Node branch=null;
		boolean option=true;
		int numFound=0;
		while (numFound!=numWords) {
			Node curNode=firstNode.child;
			while (option) {
				if (curNode.child==null&&curNode.sibling==null) {
					option=false;
				}
				else {
					
				}
				s=new StringBuilder ();
			}
		}
		fileOut.close();
		Scanner fileIn=new Scanner ("my_dictionary.txt");
		while (fileIn.hasNext()) {
			addWord(fileIn.nextLine());
		}
		fileIn.close();
	}
}
