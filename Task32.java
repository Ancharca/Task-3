import java.util.ArrayList;
import java.util.LinkedList;

public class Task32 {
    public static ArrayList<Integer> process(ArrayList<Integer> input) {
        if (input == null || input.size() <= 1) {
            return new ArrayList<>(input);
        }

        // Создаем связный список из ArrayList
        Node head = createLinkedList(input);

        // Обрабатываем согласно алгоритму
        Node resultHead = processLinkedList(head);

        // Конвертируем обратно в ArrayList
        return toArrayList(resultHead);
    }

    private static Node createLinkedList(ArrayList<Integer> list) {
        if (list.isEmpty()) return null;

        Node head = new Node(list.get(0));
        Node current = head;

        for (int i = 1; i < list.size(); i++) {
            current.next = new Node(list.get(i));
            current = current.next;
        }
        return head;
    }

    private static Node processLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node resultHead = new Node(head.data);
        Node current = head.next;

        while (current != null) {
            // 1. Добавляем элемент в начало
            Node newNode = new Node(current.data);
            newNode.next = resultHead;
            resultHead = newNode;

            // 2. Перемещаем последний в начало (если не последний элемент)
            if (current.next != null) {
                Node last = getLastNode(resultHead);
                removeLastNode(resultHead);
                last.next = resultHead;
                resultHead = last;
            }

            current = current.next;
        }

        return resultHead;
    }

    private static Node getLastNode(Node head) {
        if (head == null) return null;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private static void removeLastNode(Node head) {
        if (head == null || head.next == null) return;
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    private static ArrayList<Integer> toArrayList(Node head) {
        ArrayList<Integer> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        return result;
    }
}
