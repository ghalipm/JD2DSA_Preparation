package Tree;

class Node
{
    int value;
    Node left, right;

    public Node(int item)
    {
        value= item;
        left = right = null;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}