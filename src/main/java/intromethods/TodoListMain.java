package intromethods;

import java.util.Arrays;
import java.util.List;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList todos = new TodoList();
        todos.addTodo("alvás");
        todos.addTodo("felkelés");
        todos.addTodo("fogmosás");
        todos.addTodo("bevásárlás");
        todos.addTodo("tanulás");
        todos.addTodo("játék");
        todos.addTodo("tanulás");
        todos.addTodo("fogmosás");
        todos.addTodo("tanulás");
        todos.addTodo("alvás");
        System.out.print(todos.numberOfFinishedTodos() + " ");
        System.out.println( todos );

        todos.finishTodos("fogmosás");
        System.out.print( "\n" + todos.numberOfFinishedTodos() + " " );
        System.out.println( todos.todosToFinish() );
        System.out.println( todos );

        todos.finishAllTodos(  Arrays.asList( "alvás","játék" ));
        System.out.print( "\n" + todos.numberOfFinishedTodos() + " " );
        System.out.println( todos.todosToFinish() );
        System.out.println( todos );

        todos.finishAllTodos( todos.todosToFinish() );
        System.out.print( "\n" + todos.numberOfFinishedTodos() + " " );
        System.out.println( todos.todosToFinish() );
        System.out.println( todos );
    }
}
