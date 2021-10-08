package gyaxi.mindenfelefeladatok;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Exercrises {

    public static void main(String[] args) {
    }

    public void playersOrder() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();

        int ATTENDANCES = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < ATTENDANCES; ++i) {
            players.add(new Player(scanner.nextLine()));
        }

        players
                .stream()
                .sorted(Comparator.comparing(Player::getScore).reversed().thenComparing(Player::getName))
                .map(Player::toString)
                .forEach(System.out::println);
    }

    private class Player {
        private final String name;
        private final int score;

        private Player(String all) {
            String[] parts = all.trim().split(" ");
            name = parts[0].trim();
            score = Integer.parseInt(parts[1].trim());
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + ' ' + score;
        }
    }

    public void pairs() {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        int LINES = Integer.parseInt(scanner.nextLine().trim());

        for (int round = 0; round < LINES; ++round) {
            set.add(scanner.nextLine().trim().toLowerCase());
            System.out.println(set.size());
        }
        scanner.close();
    }


    private Deque<Character> stack = new ArrayDeque<>();

    public void isBalancedString() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            boolean result = true;
            for (char c : line.toCharArray()) {
                result &= check(c);
            }
            if (!stack.isEmpty()) {
                result = false;
            }
            System.out.println(result);
            stack.clear();
        }
    }

    private boolean check(char c) {
        if (c == '{' || c == '[' || c == '(') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) {
                return false;
            } else {
                char last = stack.pop();
                return (last != '{' || c == '}')
                        && (last != '(' || c == ')')
                        && (last != '[' || c == ']')
                        && "()[]{}".contains(((Character) c).toString());
            }
        }
        return true;
    }

    public void map() {
        Map<String, String> phoneRegister = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int RECORDS = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < RECORDS; ++i) {
            String name = scanner.nextLine().trim().toLowerCase();
            String phoneNumber = scanner.nextLine().trim();
            phoneRegister.put(name, phoneNumber);
        }
        while (scanner.hasNext()) {
            String name = scanner.nextLine().trim().toLowerCase();
            if (phoneRegister.containsKey(name)) {
                System.out.println(name + "=" + phoneRegister.get(name));
            } else {
                System.out.println("Not found");
            }
        }
        scanner.close();
    }

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