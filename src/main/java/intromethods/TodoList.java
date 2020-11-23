package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption){
        for ( int i=0 ; i<todos.size() ; ++i){
            if ( todos.get(i).getCaption().equals( caption )) {
                todos.get(i).finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish){
        for ( String one : todosToFinish ) {
            finishTodos( one );
        }
    }

    public int numberOfFinishedTodos(){
        int counter = 0;
        for ( Todo one : todos ) {
            if ( one.isFinished() ) {
                ++counter;
            }
        }
        return counter;
    }

    public List<String> todosToFinish() {
        List<String> result = new ArrayList<>();
        for ( Todo one : todos ) {
            if ( !one.isFinished() ) {
                result.add( one.getCaption() );
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Todos: " +  todos;
    }
}
