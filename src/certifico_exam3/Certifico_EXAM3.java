/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certifico_exam3;

/**
 *
 * @author khian
 */
/// The Highest Priority is the largest number
import java.util.Scanner;
    import java.util.PriorityQueue;
        import javafx.scene.Node;

class data implements Comparable<data> {
    String name;
        int priority;

    public data(String name, int priority) {
        this.name = name;
            this.priority = priority;
    }
   
    public int compareTo(data other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String toString() {
        return "data{" +
                    "name='" + name + '\'' +
                        ", priority=" + priority + '}';
    }
}

public class Certifico_EXAM3 {
    
    private PriorityQueue<data> queue;
        private Node front;
            private int printCount;

    public Certifico_EXAM3() {
            queue = new PriorityQueue<>(5);
                front = null;
                    printCount = 0;
    }

    public void insertion(data kec) {
        if (queue.size() < 5) {
            queue.add(kec);
        } else {
            data highestPriority = queue.poll();
                System.out.println("Removed due to overflow: " + highestPriority);
                    queue.add(kec);
        }
        printCount++;

        if (printCount > 6) {
            deletion();
        }
    }

    public void deletion() {
        if (!queue.isEmpty()) {
            queue.poll();
            
                printCount--;
        }
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Current Print Queue: " + queue);
        }
    }

    public static void main(String[] args) {
        Certifico_EXAM3 printerQueue = new Certifico_EXAM3();
            Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("3rd Exam:");
                System.out.println("1. Submit");
                    System.out.println("2. Exit");

            int choice = scanner.nextInt();
                scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Input Pages (You May Include Names like (Student 1, Page 6)): ");
                        String name = scanner.nextLine();
                    
                    System.out.print("Enter Priority: ");
                        int priority = scanner.nextInt();

                    data newdata = new data(name, priority);
                        printerQueue.insertion(newdata);

                    System.out.println("Print added: " + newdata);
                    break;

                case 2:
                    scanner.close();
                        System.out.println("Thank You Sir");
                            System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            
            printerQueue.display();
        }
    }
}