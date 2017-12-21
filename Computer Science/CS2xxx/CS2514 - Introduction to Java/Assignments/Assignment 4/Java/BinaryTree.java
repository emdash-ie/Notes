/**
 * A binary tree where the left child of each node is less than or equal to
 * its parent and the right child of each node is greater than the parent.
 *
 * @author Noel Bourke (112493412)
 */
public class BinaryTree<T extends Comparable<T>> {
    private T element;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    /**
     * Traversal orders.
     */
    private enum Traversal {
        PRE_ORDER(new Node[]
                    {Node.PARENT, Node.LEFT_CHILD, Node.RIGHT_CHILD}),
        IN_ORDER(new Node[]
                    {Node.LEFT_CHILD, Node.PARENT, Node.RIGHT_CHILD}),
        POST_ORDER(new Node[]
                    {Node.LEFT_CHILD, Node.RIGHT_CHILD, Node.PARENT});

        private final Node[] order;
        private static final int INDENT = 4;
        private static final String INDENT_STRING = " ";

        /**
         * Initialises a traversal.
         *
         * @param order The node positions to process, in processing order.
         */
        Traversal(Node[] order) {
            this.order = order;
        }

        /**
         * Prints the tree in the order specified by the traversal.
         *
         * @param tree The tree to print.
         * @param depth The depth of the call in the current traversal.
         */
        public void print(BinaryTree tree, int depth) {
            if (tree.getElement() != null) {
                for (Node node : this.order) {
                    node.print(tree, this, depth);
                }
            }
        }

        /**
         * Node positions.
         */
        private enum Node {
            // I couldn't decide whether to put this behaviour with the
            // nodes or the traversals. In the end I decided to go with the
            // nodes – this way if I add a new traversal method (rather
            // than print) and then add a middleChild, behaviour for the
            // middleChild is provided here.
            PARENT {
                @Override
                public void print(BinaryTree tree, Traversal traversal,
                                    int depth) {
                    for (int i = 0; i < depth * INDENT; i++) {
                        System.out.print(INDENT_STRING);
                    }
                    System.out.print(tree.getElement());
                    System.out.print("\n");
                }
            },
            LEFT_CHILD {
                @Override
                public void print(BinaryTree tree, Traversal traversal,
                                    int depth) {
                    traversal.print(tree.leftChild, depth + 1);
                }
            },
            RIGHT_CHILD {
                @Override
                public void print(BinaryTree tree, Traversal traversal,
                                    int depth) {
                    traversal.print(tree.rightChild, depth + 1);
                }
            };
            /**
             * Prints the correct node, according to the position, the
             * traversal, and the depth.
             *
             * @param tree The tree to print a node from.
             * @param traversal The Traversal to use.
             * @param depth The depth of the current operation within this
             *              traversal.
             */
            public abstract void print(BinaryTree tree,
                        Traversal traversal, int depth);
        }
    }

    /**
     * Creates a tree made up of only an empty leaf node.
     */
    private BinaryTree() {}

    /**
     * Creates a tree with a root node and two empty leaf children.
     *
     * @param element The element for the root node to contain.
     */
    private BinaryTree(final T element) {
        this.setElement(element);
    }

    /**
     * Creates a tree.
     *
     * @param element The element for the root node to contain.
     * @return A BinaryTree with a root node and two empty children if
     *     element is a valid object reference, and a BinaryTree with only
     *     an empty root node if element is null.
     */
    public static <T extends Comparable<T>> BinaryTree<T> create(
                                                    final T element) {
        return element == null
               ? new BinaryTree<T>() : new BinaryTree<T>(element);
    }

    /**
     * Changes a tree from an empty leaf node to a root node which contains
     * an element and has two empty children.
     *
     * @param element The element for the node to hold.
     */
    private void setElement(final T element) {
        this.element = element;
        this.leftChild = new BinaryTree<T>();
        this.rightChild = new BinaryTree<T>();
    }

    /**
     * Inserts a new element into the subtree rooted at this node.
     *
     * @param element The element to insert.
     * @return The node containing the newly inserted element.
     */
    public BinaryTree<T> insert(final T element) {
        BinaryTree<T> result;

        if (this.element == null) {
            this.setElement(element);
            result = this;
        } else if (element.compareTo(this.element) <= 0) {
            result = this.leftChild.insert(element);
        } else {
            // element > this.element
            result = this.rightChild.insert(element);
        }
        return result;
    }

    /**
     * Prints a pre-order representation of the tree, where the parent is
     * printed above the left child and the left child is printed above the
     * right child. Children are indented from their parent.
     */
    public void showPreOrder() {
        Traversal.PRE_ORDER.print(this, 0);
    }

    /**
     * Prints an in-order representation of the tree, where the left child
     * is printed above the parent and the parent is printed above the
     * right child. Children are indented from their parent.
     */
    public void showInOrder() {
        Traversal.IN_ORDER.print(this, 0);
    }

    /**
     * Prints a post-order representation of the tree, where the left child
     * is printed above the right child and the right child is printed
     * above the parent. Children are indented from their parent.
     */
    public void showPostOrder() {
        Traversal.POST_ORDER.print(this, 0);
    }

    public T getElement() {
        return this.element;
    }

    /**
     * Tests the BinaryTree class by creating a tree of Integers and
     * showing pre-order, in-order, and post-order traversals of it.
     */
    public static void main(String[] args) {
        BinaryTree<Integer> myTree = BinaryTree.create(10);
        myTree.insert(9);
        myTree.insert(11);
        myTree.insert(8);
        myTree.insert(12);
        myTree.insert(10);
        myTree.insert(11);
        System.out.println("Pre-order:");
        myTree.showPreOrder();
        System.out.println("In-order:");
        myTree.showInOrder();
        System.out.println("Post-order:");
        myTree.showPostOrder();
    }
}
