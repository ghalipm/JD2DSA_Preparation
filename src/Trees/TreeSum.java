package Trees;

public class TreeSum {

    Node root;

    public TreeSum() { root = null; }

    public static int branchSum(Node root, int initSum) {
        //for root, initSum=0 (grandpa was born, zero savings)

        // if root is null:
        if(root==null) return 0;
        // if root is not null:
        else if(root!=null) {
            initSum = 10 * initSum + root.value;
            //if root has no children:
            if (root.left == null && root.right == null) { // if root is leaf
                return initSum;
            }
            // if root has children:
            else {
                initSum = branchSum(root.left, initSum) + branchSum(root.right, initSum);
            }
        }
        return initSum ;
    }

    public static void main(String[] args) {
        TreeSum tree = new TreeSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);

        System.out.println("Sum of the node values of all branches in the tree = " + branchSum(tree.root,  0));
    }
}
