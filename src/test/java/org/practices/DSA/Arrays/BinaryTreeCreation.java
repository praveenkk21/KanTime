package org.practices.DSA.Arrays;

class BinaryTreeCreation {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class BinaryCreation{
        static int indx=-1;
        public static Node create(int[] node){
            indx++;
            if(node[indx]==-1 || indx >= node.length){
                return null;
            }

            Node bin= new Node(node[indx]);
            bin.left=create(node);
            bin.right=create(node);
            return bin;
        }

    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, -1};

        inorderTraversal(BinaryCreation.create(node));
    }
}
