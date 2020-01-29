public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.add(5);
        tree.add(15);
        tree.add(9);
        tree.add(12);
        tree.add(11);
        tree.add(7);
        tree.add(2);
        tree.add(14);
        tree.add(8);
        tree.add(5);
        tree.add(10);
        tree.traverse();

        System.out.println("12 ? " + tree.contains(12));
        System.out.println("Deleting 12...");
        tree.delete(12);
        System.out.println("12 ? " + tree.contains(12));
        tree.traverse();
        System.out.println("Deleting 7...");
        tree.delete(7);
        tree.traverse();
        System.out.println("Deleting 5...");
        tree.delete(5);
        tree.traverse();
        System.out.println("Deleting 10 (root)...");
        tree.delete(10);
        tree.traverse();
        System.out.println("Deleting all the rest nodes consequentially...");
        tree.delete(2);
        tree.delete(5);
        tree.delete(8);
        tree.delete(9);
        tree.delete(10);
        tree.delete(11);
        tree.delete(14);
        tree.delete(15);
        System.out.println("Result is");
        tree.traverse();
    }
}
