package gyaxi.mindenfelefeladatok;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Exercrises {
    public void listInsertDelete() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        List<Integer> list = Arrays.stream(scanner.nextLine()
                .replaceAll("\\s+$", "")
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int ROUNDS = Integer.parseInt(scanner.nextLine().trim());
        for (int round = 0; round < ROUNDS; ++round) {
            if (scanner.nextLine().trim().equals("Insert")) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                while (list.size() < index) {
                    list.add(null);
                }
                list.add(index, value);
            } else {
                int index = scanner.nextInt();
                if (scanner.hasNext()) {
                    scanner.nextLine();
                }
                if (list.size() > index) {
                    list.remove(index);
                }
            }
        }
        System.out.println(list.stream().map(i -> String.format("%d", i)).collect(Collectors.joining(" ")));
        scanner.close();
    }

    public void Array1D() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int ROUNDS = Integer.parseInt(scanner.nextLine().trim());
        for (int round = 0; round < ROUNDS; ++round) {
            int size = scanner.nextInt();
            int leap = Integer.parseInt(scanner.nextLine().trim());
            Integer[] arr = new Integer[size];
            Arrays.stream(scanner.nextLine()
                    .replaceAll("\\s+$", "")
                    .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
                    .toArray(arr);
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0;
            do {
                if (arr[i] != 0) {
                    System.out.println("NO");
                    break;
                }
                if (i == size - 1 || i + leap >= size) {
                    System.out.println("YES");
                    break;
                }
                if (leap > 1 && arr[i + leap] == 0) {
                    stack.offer(i);
                    i += leap;
                    continue;
                }
                if (arr[i + 1] == 0) {
                    stack.offer(i);
                    ++i;
                    continue;
                }
                arr[i] = 1;
                stack.remove(i);
                if (i > 0 && arr[i - 1] == 0) {
                    --i;
                    continue;
                }
                if (stack.size() > 0) {
                    i = stack.pollLast();
                } else {
                    i = 0;
                }
            } while (true);
        }
        scanner.close();
    }

    public void Arraylist() {
        Scanner scanner = new Scanner(System.in);

        int y = scanner.nextInt();
        int[][] arr = new int[y][];
        for (int i = 0; i < y; i++) {
            int x = scanner.nextInt();
            arr[i] = new int[x];
            for (int j = 0; j < x; ++j) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int LINES = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < LINES; ++i) {
            List<Integer> question = Arrays.stream(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            if (question.get(0) > y || question.get(1) > arr[question.get(0) - 1].length) {
                System.out.println("ERROR!");
            } else {
                System.out.println(arr[question.get(0) - 1][question.get(1) - 1]);
            }
        }

        scanner.close();
    }
}