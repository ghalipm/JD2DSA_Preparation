package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeQueueSum {
    Node root;
    public TreeQueueSum() { root = null; }

    // based on level order print:
    // now change it to branchesValuesSum
    public static int branchSumQueue(Node root, int initS){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            /* poll() removes the present head, but tempNode keeps the value */
            Node tempNode = queue.poll();
            initS=10*initS+tempNode.value;
            System.out.println(initS + " for " + tempNode.value );

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);

            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return initS;
    }


    public static void main(String[] args) {
        TreeQueueSum tree = new TreeQueueSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Sum of the node values of all branches in the tree = " + branchSumQueue(tree.root,  0));
    }
}
