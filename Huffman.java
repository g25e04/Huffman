import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

	public Huffman() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = 6;//6 char
		char[] engArray = {'a','b','c','d','e','f'};
		int[] engFrequency= {10,15,8,6,22,9};
		
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(num,new RealCompare());
		for(int i=0;i<num;i++) {
			HuffmanNode node = new HuffmanNode();
			node.eng=engArray[i];
			node.data=engFrequency[i];
			
			node.left=node.right=null;
			pq.add(node);//input node into Priority Queue
		}
		//new root:left+right 's end
		HuffmanNode root = null;
		while(pq.size()>1) {
			HuffmanNode a = pq.peek();//find and not remove the head from queue
			pq.poll();//find and remove the head from queue		
			HuffmanNode b = pq.peek();
			pq.poll();
			
			HuffmanNode hn = new HuffmanNode();
			hn.data=a.data+b.data;
			hn.left=a;
			hn.right=b;
			root=hn;
			pq.add(hn);
		}
		Print(root,"");
	}

	public static void Print(HuffmanNode root,String op) {
		//best case :no child
		if(root.left == null && root.right == null && Character.isLetter(root.eng)) {
			//isLetter:if if English,return true
			System.out.println(root.eng + " : " + op);
			return;
		}
		//left:0 right:1
		Print(root.left, op + "0");
		Print(root.right, op + "1");
	}
}
