package exam03retake02;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo bevásárlás) {
        todos.add(bevásárlás);
    }

    public int getNumberOfItemsLeft() {
        return (int) todos
                .stream()
                .filter(Todo::isNotComplete)
                .count();
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<String> getMostImportantTodosText() {

        Optional<Integer> min = todos
                .stream()
                .map(Todo::getPriority)
                .min((a, b) -> a - b);
        if (min.isEmpty()) {
            return Collections.emptyList();
        }

        return todos
                .stream()
                .filter(todo -> todo.getPriority() <= min.get())
                .map(Todo::getText)
                .collect(Collectors.toList());
    }

    public void deleteCompleted() {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isNotComplete())
                iterator.remove();
        }
    }
}
//Írj egy tennivaló osztályt (Todo), melynek attribútumai: text, state és priority, rendre String, State és int típusú.
// A State egy saját enum COMPLETED és NON_COMPLETED értékekkel. A prioritás 1 és 5 közötti egész szám. Ha nem ilyet kap,
// akkor kivételt dob. Konstuktorban csak a szövegét és a prioritását kell megadni, alapértelmezetten NON_COMPLETED
// állapottal jön létre. Legyen egy complete() metódusa, mely átállítja az állapotát!
//
//Legyen egy TodoList osztály, mely több tennivalót tartalmaz! Egy List<Todo> attribútumban tartalmazza a tennivalókat.
//
//Metódusai:
//    getNumberOfItemsLeft() - visszaadja a még el nem készült tennivalók számát
//    getMostImportantTodosText() - visszaadja a legyfontosabb tennivalókat. Nem feltétlen van 1-es prioritású.
//    deleteCompleted() - a listából kitörli az elvégzetteket