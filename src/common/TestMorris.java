package common;


import com.adam.printer.BinaryTrees;

import java.util.Random;

/**
 * @auther adam
 * @date 2022/2/16
 * @apiNote common
 */
public class TestMorris {
    private  static  class  MorrisTree extends BST<Integer> {
        public  void inorder() {
            Node<Integer> node = root;
            while (node != null) {
                if (node.left != null) {
                    // 找到前驱节点(predecessor)  后继节点(successor)
                    Node<Integer> pred = node.left;
                    while (pred.right != null && pred.right != node) {
                        pred = pred.right;
                    }
                    if (pred.right == null) {
                        pred.right = node;
                        node = node.left;
                    } else {
                        // 第二次遍历到前驱节点  node.right == node
                        System.out.print(node.element + " ");
                        pred.right = null;
                        node = node.right;
                    }
                } else {
                    System.out.print(node.element + " ");
                    node = node.right;
                }
            }
        }
        private  void inorder(Node<Integer> root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        MorrisTree tree = new MorrisTree();
        for (int i = 0; i < 10; i++) {
            tree.add(new Random().nextInt(100));
        }
        BinaryTrees.println(tree);
        System.out.println("--------------------");
        tree.inorder();
        System.out.println("");
        System.out.println("--------------------");
        BinaryTrees.println(tree);
    }
}

