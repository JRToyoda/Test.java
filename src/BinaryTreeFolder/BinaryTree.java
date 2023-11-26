package BinaryTreeFolder;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    public BinaryTree() {root = null;}
    public boolean isEmpty() {return  root == null;}
    public Node getRoot() {return root;}
    public void addNode(int data) {root = add(root, data);}
    private Node add(Node node, int data) {
        if (isEmpty()) {
            root = new Node((data));
        } else {
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);

            while (!q.isEmpty()) {
                node = q.peek();
                q.remove();
                if (node.getLeft() == null) {
                    node.setLeft(new Node(data));
                    break;
                } else q.add(node.getLeft());

                if (node.getRight() == null) {
                    node.setRight(new Node(data));
                    break;
                } else q.add(node.getRight());
            }
        }
        return root;
    }
    public int count() {return count(root);}
    private int count(Node node) {
        if (node == null)
            return 0;
        else {
            int ctr = 1;
            ctr += count(node.getLeft());
            ctr += count(node.getRight());
            return ctr;
        }
    }
    public String traverseLevelOrder(Node node) { // Jaen Rafael M. Toyoda
        String hold = "";
        if (isEmpty()) {
            hold = "Tree is empty";
        } else {
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);
            while (!q.isEmpty()) {
                Node newNode = q.poll();
                hold += newNode.getData() + " ";
                if (newNode.getLeft() != null)
                    q.add(newNode.getLeft());
                if (newNode.getRight() != null)
                    q.add(newNode.getRight());
            }
        }
        return hold;
    }
    public String printLevelOrder(){return traverseLevelOrder(root);}
    public String traverseInOrder(Node node) {
        if (node != null)
            return traverseInOrder(node.getLeft()) + node.getData() + " " + traverseInOrder(node.getRight());
        else return "";
    }
    public String printInOrder() {return traverseInOrder(root);}
    public String traversePreOrder(Node node) { // Jaen Rafael M. Toyoda
        if (node != null)
            return node.getData() + " " + traversePreOrder(node.getLeft()) + traversePreOrder(node.getRight());
        else return "";
    }
    public String printPreOrder() {return traversePreOrder(root);}
    public String traversePostOrder(Node node) {
        if (node != null)
            return traversePostOrder(node.getLeft()) + traversePostOrder(node.getRight()) + node.getData() + " ";
        else return "";
    }
    public String printPostOrder() {return traversePostOrder(root);}
    public boolean search(int val) {
        if (isEmpty()) {
            return false;
        } else {
            return search(root, val);
        }
    }
    private boolean search(Node node, int val) {
        if (node.getData() == val)
            return true;
        if (node.getLeft() != null)
            if (search(node.getLeft(), val))
                return true;
        if (node.getRight() != null)
            if (search(node.getRight(), val))
                return true;
        return false;
    }
    private String traverseInternalNodes(Node node) { // Jaen Rafael M. Toyoda
        if (node != null && (node.getLeft() != null || node.getRight() != null))
            return node.getData() + " " + traverseInternalNodes(node.getLeft()) + traverseInternalNodes(node.getRight());
        else return "";
    }
    public String printParents() {return traverseInternalNodes(root);}
    private String traverseLeaves(Node node) { // Jaen Rafael M. Toyoda
        if (node == null) return "";
        if (node.getLeft() == null && node.getRight() == null)
            return String.valueOf(node.getData());
        return traverseLeaves(node.getLeft()) + " " + traverseLeaves(node.getRight());
    }
    public String printLeaves() {return traverseLeaves(root);}
    private int getHeight(Node node) { // Jaen Rafael M. Toyoda
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
    public int height() {return getHeight(root) - 1;}
    public int depth() {return getHeight(root) - 1;} // Jaen Rafael M. Toyoda
    public String level() {
        return "";
    }
    private boolean type(Node node) { // Jaen Rafael M. Toyoda
        if (node == null) {
            return true;
        } else if ((node.getLeft() == null && node.getRight() == null) || (node.getLeft() != null && node.getRight() != null)) {
            return type(node.getLeft()) && type(node.getRight());
        }
        return false;
    }
    public String treeType() {
        if (root == null)
            return "Tree is Empty";
        if (type(root))
            return "Full Binary Tree";
        else
            return "Complete Binary Tree";
    }
    public void cut() { // Jaen Rafael M. Toyoda
        root = null;
    }

    private void lastInserted(Node node) { // Jaen Rafael M. Toyoda
        if (node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        Node prev = null;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getLeft() != null) {
                prev = current;
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                prev = current;
                queue.add(current.getRight());
            }
        }
        if (prev == null)
            node = null;
        else {
            if (prev.getRight() != null)
                prev.setRight(null);
            else prev.setLeft(null);
        }
    }
    public void remove() {
        lastInserted(root);
    }

    private boolean dupe(Node node, int data) { // Jaen Rafael M. Toyoda
        if (isEmpty()) {
            return false;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.getData() == data)
                    return true;
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
        }
        return false;
    }
    public boolean contains(int data) {
        return dupe(root, data);
    }

}
