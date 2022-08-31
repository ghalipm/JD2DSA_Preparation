package Trees;

// Recursive Java program for level
// order traversal of Binary Tree

/* Class containing left and right child of current
   node and key value*/


import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    // Root of the Binary Tree
    Node root;

    public BinaryTree() { root = null; }

    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = heightC(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }


    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/

    /*  height in ternary: */
    int heightC(Node root)
    {
        return (root == null)?0:Math.max(heightC(root.left), heightC(root.right))+1;
    }

    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    /* Post order print nodes at the current level */
    void postOrderPrint(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1) {
            postOrderPrint(root.left, level - 1);
            postOrderPrint(root.right, level - 1);
            System.out.print(root.value + " ");
        }
    }

    /**
   Depth First Traversals: Tree: time complexity: O(n^2) in worst case, O(n) in best case
        (a) Inorder (Left, Root, Right) : 4 2 5 1 3
        (b) Preorder (Root, Left, Right) : 1 2 4 5 3
        (c) Postorder (Left, Right, Root) : 4 5 2 3 1
        Breadth-First or Level Order Traversal: 1 2 3 4 5
        Please see this post for Breadth-First Traversal.
     */

/* Inorder traversal. Left -> Root -> Right */
    void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }
    /* Preorder traversal. Root -> Left -> Right */
    void preorder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }
    /* Postorder traversal. Left -> Right -> Root */
    void postorder(Node root)
    {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }


    /* Pre order print nodes at the current level */
    void preOrderPrint(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1) {
            postOrderPrint(root.left, level - 1);
            postOrderPrint(root.right, level - 1);
            System.out.print(root.value + " ");
        }
    }

    /* Post order sum  */

    int postOrderSumOfBranches(Node root, int pSum) // pSum is the sum of the previous level
    {
        if (root == null)
            return 0;
        pSum=10*pSum+root.value;
        if (root.left == null && root.right == null)
            return pSum;
        else {

            pSum=postOrderSumOfBranches(root.left, pSum)+postOrderSumOfBranches(root.right, pSum);

        }
        return pSum;
    }

    /* sum values of nodes at the current level */
    int sumCurrentLevel(Node root, int level)
    {
        int sumCL= 0;
        if (root == null ) {sumCL+=0;}
        else if (level == 1) {sumCL+= root.value; }
        else if (level > 1) {
            sumCL+= sumCurrentLevel(root.left, level - 1) + sumCurrentLevel(root.right, level - 1);
        }
        return sumCL;
    }

    /* sum values of nodes at the current level */
    int nodeValuesSum(Node root){
        int h= heightC(root);
        int sum=0;
        for (int i = 1; i <=h; i++) {
            sum+=sumCurrentLevel(root, i);
        }
        return sum;
    }

    /* Given a binary tree. Print
      its nodes in level order
      using array for implementing queue : O(n) */
    void printLevelOrderQ()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
        System.out.println( " ");
        System.out.println( "==============Current Level Node Values Sum==============");
        System.out.println("tree.sumCurrentLevel(tree.root, 3) = " + tree.sumCurrentLevel(tree.root, 3));
        System.out.println("tree.sumCurrentLevel(tree.root, 2) = " + tree.sumCurrentLevel(tree.root, 2));
        System.out.println("tree.sumCurrentLevel(tree.root, 1) = " + tree.sumCurrentLevel(tree.root, 1));


        System.out.println( "============== Post Order Print==============");
        tree.postOrderPrint(tree.root, 3);

        System.out.println( "============== Post Order Sum Of Branches==============");
        System.out.println("tree.postOrderSumAtLevel(tree.root, 0) = " + tree.postOrderSumOfBranches(tree.root, 0));

        System.out.println( "============== Node Values Sum==============");
        System.out.println("tree.nodeValuesSum(tree.root) = " + tree.nodeValuesSum(tree.root));
    }
}


