/**
 *
 */
public class BST {

    Node root;

    //O(log N)
    void search(){

    }

    /**
     * Calls insertRecursive.
     * @param key, the key to be stored.
     */
    public void initInsert(int key){
        root = insertRecursive(root, key);
    }

    /**
     * Creates a new node that is then inserted into the tree.
     * The method recursively iterates through the tree to find where
     * the new node fits.
     * @param current The head node, or current, of the tree.
     * @param key The integer data to be stored in the node.
     * @return current, the current Node.
     * Partially based off of code from:
     * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    Node insertRecursive(Node current, int key) {
        //if current node is null, set it to the new node.
        if (current == null) {
            return new Node(key);
        }
        //otherwise, recurse to the left or right child.
        else if (current.key < key) {
            current.rightChild = insertRecursive(current.rightChild, key);
        } else if (current.key > key) {
            current.leftChild = insertRecursive(current.leftChild, key);
        }
        return current;
    }

    /**
     * FIXME: CAN CAUSE STACK OVERFLOW
     * Finds the height of a subtree from a given node.
     * @param node The node given by the method call. The root of the subtree.
     * @return the height of the tree.
     * Partial based off of:
     * https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
     */
    int getHeight(Node node){
        //if the node is null, it has height of zero.
        if (node == null){
            return 0;
        }
        //otherwise, find the depth of the left and right subtrees,
        //and add the larger ones recursively.
        else {
            int depthLeft = getHeight(node.leftChild);
            int depthRight = getHeight(node.rightChild);

            if (depthLeft > depthRight) {
                return (depthLeft + 1);
            }
            else {
                return (depthRight + 1);
            }
        }
    }

    /**
     * Finds the height of this tree.
     * Doesn't work for finding subtrees,
     * just useful for the convenience of not accessing
     * root from public.
     * @return the height of this tree.
     */
    int getThisHeight(){
        return getHeight(root);
    }

    /**
     * Prints all nodes on the given level of subtree of given node.
     * Spaces the nodes according to null pointer exceptions.
     * @param current The current node, the node from which the level is measured.
     * @param level The level with respect to the given node.
     * Based off of https://www.geeksforgeeks.org/level-order-tree-traversal/
     */
    void printLevel(Node current, int level) {
        if (root == null){
            return;
        }
        if (level == 1){
            System.out.print(current.key + " ");
        }
        //recursively gets the child nodes to reach the desired level.
        else if (level > 1){
            try {
                printLevel(current.leftChild, level - 1);
            } catch (NullPointerException e){System.out.print(" ");}
            try {
                printLevel(current.rightChild, level - 1);
            } catch (NullPointerException e){System.out.print(" ");}
        }
    }

    /**
     * Prints the tree using a mediocre text base graphical representation.
     */
    void printTree(){
        int h = getThisHeight();
        //for each level, print the level.
        for (int i = 1; i <= h; i++){
            //also add spaces in front of level, more the higher.
            for (int j = i; j < h; j++) {
                System.out.print(" ");
            }
            printLevel(root, i);
            System.out.println();
        }
    }

    void rotateRight(Node parent) {
        Node tempParent = parent;
        tempParent.leftChild = parent.leftChild.rightChild;
        parent = parent.leftChild;
        parent.rightChild = tempParent;
    }

    //O(log N)
    void remove(int key){

    }
}

/**
 * Node class for binary search tree.
 * Stores key, and pointers to two children.
 */
class Node {
    int key;
    Node leftChild;
    Node rightChild;

    //constructor to set key and color.
    Node(int key){
        this.key = key;
        rightChild = null;
        leftChild = null;
    }
}