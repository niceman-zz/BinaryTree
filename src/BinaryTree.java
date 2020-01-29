/**
 * Simple binary search tree
 */
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree(E value) {
        root = new Node<>(value);
    }

    public void add(E value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.add(value);
        }
    }

    public boolean contains(E value) {
        return findNode(root, value) != null;
    }

    public void delete(E value) {
        if (root == null || value == null) {
            return;
        }

        deleteNode(root, value);
    }

    private Node<E> deleteNode(Node<E> node, E value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = deleteNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                if (node == root) {
                    root = null;
                }
                return null;
            }
            if (node.left != null && node.right == null) {
                if (node == root) {
                    root = node.left;
                }
                return node.left;
            }
            if (node.right != null && node.left == null) {
                if (node == root) {
                    root = node.right;
                }
                return node.right;
            }
            Node<E> min = findMin(node.right);
            node.value = min.value;
            node.right = deleteNode(node.right, min.value);
        }
        return node;
    }

    private Node<E> findNode(Node<E> currentNode, E value) {
        if (currentNode.value == value) {
            return currentNode;
        } else if (value.compareTo(currentNode.value) < 0 && currentNode.left != null) {
            return findNode(currentNode.left, value);
        } else if (value.compareTo(currentNode.value) > 0 && currentNode.right != null) {
            return findNode(currentNode.right, value);
        }
        return null;
    }

    private Node<E> findMin(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left);
        System.out.println(node.value + " ");
        traverseInOrder(node.right);
    }

    private static class Node<E extends Comparable<E>> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }

        void add(E value) {
            if (value.compareTo(this.value) <= 0) {
                if (left == null) {
                    left = new Node<>(value);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node<>(value);
                } else {
                    right.add(value);
                }
            }
        }
    }
}
