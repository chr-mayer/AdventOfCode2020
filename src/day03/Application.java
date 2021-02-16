package day03;

public class Application {

    public static void main(String[] args) {
        TreeCounter treeCounter = new TreeCounter();
        long numberOfTrees = treeCounter.count(3, 1);
        System.out.println(numberOfTrees);
        System.out.println("-------------");
        long answer =
                treeCounter.count(1, 1) *
                        treeCounter.count(3, 1) *
                        treeCounter.count(5, 1) *
                        treeCounter.count(7, 1) *
                        treeCounter.count(1, 2);
        System.out.println(answer);
    }
}
