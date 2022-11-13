package Trees;

import lombok.ToString;

/* Class containing left and right child of current
   node and key value*/
@ToString
class Node
{
    int value;
    Node left, right;

    public Node(int item)
    {
        value= item;
        left = right = null;
    }

}