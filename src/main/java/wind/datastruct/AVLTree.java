package wind.datastruct;

import java.util.ArrayList;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-07-24 10:18
 **/
public class AVLTree {

    /**
     * 插入节点后平衡树
     *
     * @param node
     * @param key
     * @return
     */
    private AVLNode rebalanced(AVLNode node, int key) {
        int factor = this.getBalanceFactor(node);
        // 左左插入右旋
        if (factor > 1 && key < node.left.key) {
            return rightRotation(node);
        }
        // 右右插入左旋
        if (factor < -1 && key > node.right.key) {
            return rightRotation(node);
        }
        // 左右插入左右旋
        if (factor > 1 && key > node.left.key) {
            AVLNode leftRotation = leftRotation(node);
            return rightRotation(leftRotation);
        }
        //右左插入右左旋
        if (factor < -1 && key < node.right.key) {
            AVLNode rightRotation = rightRotation(node);
            return leftRotation(rightRotation);
        }
        return node;
    }

    /**
     * 右旋
     *
     * @param y
     * @return
     */
    private AVLNode rightRotation(AVLNode y) {
        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        x.height = Math.max(x.left.height, x.right.height);
        y.height = Math.max(y.left.height, y.right.height);
        return x;
    }

    /**
     * 左旋
     *
     * @param x
     * @return
     */
    private AVLNode leftRotation(AVLNode x) {
        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(x.left.height, x.right.height);
        y.height = Math.max(y.left.height, y.right.height);
        return y;
    }

    private int getBalanceFactor(AVLNode node) {
        if (null != node) {
            return node.left.height - node.right.height;
        }
        return -1;
    }

    private static class AVLNode {
        AVLNode left;
        AVLNode right;
        int height;
        int key;
        ArrayList<Object> values;
    }
}