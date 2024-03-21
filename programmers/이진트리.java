package programmers;

import java.util.*;

public class 이진트리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        BinaryTree binaryTree = new BinaryTree();

        //자료 넣기
        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split(" ");
            char key = parts[0].charAt(0);
            char left = parts[1].charAt(0);
            char right = parts[2].charAt(0);
            binaryTree.add(key, left, right);
        }

        binaryTree.preOrder(binaryTree.tree.get('A'));
        System.out.println();
        binaryTree.inOrder(binaryTree.tree.get('A'));
        System.out.println();
        binaryTree.postOrder(binaryTree.tree.get('A'));
        System.out.println();

    }
}

class BinaryTree {
    Map<Character, Node> tree = new HashMap<>();

    void add(char key, char left, char right){
        if (!tree.containsKey(key)) {
            tree.put(key, new Node(key));
        }

        Node parent = tree.get(key);

        if (left != '.') {
            parent.left = new Node(left);
            tree.put(left, parent.left);
        }
        if (right != '.') {
            parent.right = new Node(right);
            tree.put(right, parent.right);
        }
    }

    //전위순회 //왼쪽부터 재귀
    void preOrder(Node node) {
        if (node != null) { //탈출조건
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //중위순회
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    //후위순회
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
    }
}

