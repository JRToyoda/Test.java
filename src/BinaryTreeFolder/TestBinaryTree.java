package BinaryTreeFolder;

import BinaryTreeFolder.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        System.out.println("Test	run	by	:	Jaen Rafael M. Toyoda");
        BinaryTree tree=new BinaryTree();

        System.out.println("---Before	Adding	Nodes---");
        System.out.println("Empty\t\t:	"+tree.isEmpty());
        System.out.println("Number	of	Nodes\t:	"+tree.count());
        System.out.println("Level	Order\t:	"+tree.printLevelOrder());
//adding	Node to	a	tree
        tree.addNode(12);
        tree.addNode(40);
        tree.addNode(50);
        System.out.println("---After	Adding	3	Nodes---");
        System.out.println("Empty\t\t:	"+tree.isEmpty());
        System.out.println("Number	of	Nodes\t:	"+tree.count());
        System.out.println("Level	Order\t:	"+tree.printLevelOrder());
//adding	Node to	a	tree
        tree.addNode(25);
        tree.addNode(30);
        tree.addNode(10);
        System.out.println("---After	Adding	a	few	more	Nodes---");
        System.out.println("Empty\t\t:	"+tree.isEmpty());
        System.out.println("Number	of	Nodes\t:	"+tree.count());
        System.out.println("Level	Order\t:	"+tree.printLevelOrder());
        System.out.println("Empty\t: " + tree.isEmpty());
//
//        tree.addNode(12);
//        tree.addNode(40);
//        tree.addNode(50);
//        tree.addNode(10);
//        tree.addNode(8);

        Node root = new Node();
        root = tree.getRoot();

        System.out.println("In-Order\t: " + tree.traverseInOrder(root));
        System.out.println("Pre-Order\t: " + tree.traversePreOrder(root));
        System.out.println("Post-Order\t: " + tree.traversePostOrder(root));
        System.out.println(tree.search(25));
//        System.out.println("Empty\t: " + tree.isEmpty());
//
//        System.out.println("Level Order\t: " + tree.printLevelOrder());
    }
}
