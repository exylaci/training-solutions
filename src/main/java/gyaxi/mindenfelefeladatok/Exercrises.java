package gyaxi.mindenfelefeladatok;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Exercrises {

    public static void main(String[] args) {
    }

    public static final String ONE_PART = "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";

    public void ipAddressCheckByRegex() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine().trim().matches(ONE_PART + "\\." + ONE_PART + "\\." + ONE_PART + "\\." + ONE_PART));
        }
        scanner.close();
    }
    /*
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
225.23.1.2
256.255.0.0
     */


    public void regexPatternSyntaxChecker() {
        Scanner scanner = new Scanner(System.in);
        int LINES = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < LINES; ++i) {
            try {
                Pattern.compile(scanner.nextLine());
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
        scanner.close();
    }

    public void stringtoken() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        scanner.close();

        String[] tokens = s.split("[ !,\\?\\._'@]+", 0);
        if (tokens.length < 1 || tokens[0].isEmpty()) {
            System.out.println("0");
            return;
        }

        System.out.println(tokens.length);
        Arrays.stream(tokens).forEach(System.out::println);
    }

    public void anagram() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim().toLowerCase();
        String s2 = scanner.nextLine().trim().toLowerCase();
        scanner.close();

        Map<Integer, Long> letters1 = s1.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> letters2 = s2.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (letters1.size() != letters2.size()) {
            System.out.println("Not Anagrams");
            return;
        }
        if (letters1
                .entrySet()
                .stream()
                .filter(one -> letters2.get(one.getKey()) != one.getValue())
                .count() > 0) {
            System.out.println("Not Anagrams");
            return;
        }
        System.out.println("Anagrams");
    }

    public void palindrome() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        for (int i = 0; i < (s.length() + 1) / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public void compareSubstrings() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int size = scanner.nextInt();
        scanner.close();

        if (size >= s.length()) {
            System.out.println(s);
            return;
        }

        String first = "zzzz";
        String last = " ";
        for (int i = 0; i <= s.length() - size; ++i) {
            String sub = s.substring(i, i + size);
            if (last.compareTo(sub) < 0) {
                last = sub;
            }
            if (first.compareTo(sub) > 0) {
                first = sub;
            }
        }

        System.out.println(first);
        System.out.println(last);
    }

    public void priorityQueue() {
        Scanner scanner = new Scanner(System.in);
        int LINES = scanner.nextInt();
        scanner.nextLine();

        PriorityQueue<Student> students =
                new PriorityQueue<>(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName));
        for (int i = 0; i < LINES; ++i) {
            String[] line = scanner.nextLine().trim().split(" ");
            if (line[0].equals("ENTER")) {
                students.add(new Student(line[1], Double.parseDouble(line[2])));
            } else {
                students.poll();
            }
        }

        scanner.close();
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.stream()
                    .sorted(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName))
                    .map(Student::getName)
                    .forEach(System.out::println);
        }
    }

    public void bitset() {
        Scanner scanner = new Scanner(System.in);
        int BITS = scanner.nextInt();
        int LINES = scanner.nextInt();
        scanner.nextLine();

        BitSet b1 = new BitSet(BITS);
        BitSet b2 = new BitSet(BITS);

        for (int i = 0; i < LINES; ++i) {
            String[] line = scanner.nextLine().trim().split(" ");
            if (line[1].equals("1")) {
                switch (line[0]) {
                    case "AND" -> b1.and(b2);
                    case "OR" -> b1.or(b2);
                    case "XOR" -> b1.xor(b2);
                    case "SET" -> b1.set(Integer.parseInt(line[2]));
                    case "FLIP" -> b1.flip(Integer.parseInt(line[2]));
                }
            } else {
                switch (line[0]) {
                    case "AND" -> b2.and(b1);
                    case "OR" -> b2.or(b1);
                    case "XOR" -> b2.xor(b1);
                    case "SET" -> b2.set(Integer.parseInt(line[2]));
                    case "FLIP" -> b2.flip(Integer.parseInt(line[2]));
                }
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        scanner.close();
    }

    public void deque() {
        Scanner scanner = new Scanner(System.in);
        int TOTAL_SIZE = scanner.nextInt();
        int SUB_SIZE = scanner.nextInt();
        scanner.nextLine();

        Deque<Integer> deque = new LinkedBlockingDeque<>(SUB_SIZE);
        Set<Integer> subSet = new HashSet<>(SUB_SIZE);

        int inElement = 0;
        int i = 0;
        for (; i < SUB_SIZE; ++i) {
            inElement = scanner.nextInt();
            deque.add(inElement);
        }

        subSet.addAll(deque);
        int maximum = subSet.size();
        int outElement;

        for (; i < TOTAL_SIZE; ++i) {
            outElement = deque.removeFirst();
            inElement = scanner.nextInt();
            deque.add(inElement);
            if (!deque.contains(outElement)) {
                subSet.remove(outElement);
            }
            subSet.add(inElement);

            maximum = Math.max(maximum, subSet.size());
        }

        scanner.close();
        System.out.println(maximum);
    }


    public void studentsOrder() {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int HEADCOUNT = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < HEADCOUNT; ++i) {
            students.add(new Student(scanner.nextLine()));
        }
        students.stream()
                .sorted(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName))
                .map(Student::getName)
                .forEach(System.out::println);
        scanner.close();
    }

    private class Student {
        private final String name;
        private final double cgpa;

        private Student(String all) {
            String[] parts = all.trim().split(" ");
            name = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 1));
            cgpa = Double.parseDouble(parts[parts.length - 1].trim());
        }

        public Student(String name, double cgpa) {
            this.name = name;
            this.cgpa = cgpa;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }
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

    public void array1D() throws IOException {
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

    public void arrayList() {
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