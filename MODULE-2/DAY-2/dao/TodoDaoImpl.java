package dao;


import Todo.Todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TodoDaoImpl implements TodoDao {
    private ArrayList<Todo> todolist;

    TodoDaoImpl() {
        todolist = new ArrayList<>();
    }

    public void save(Todo todo) {
        todolist.add(todo);
    }


    public Todo findById(int id) {
        for (Todo t : todolist) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        todolist.removeIf(t -> t.getId() == id);
    }


    public void deleteAll() {
        todolist.clear();
    }

    public void update(Todo todo) {
        for (Todo t1 : todolist) {
            if (t1.getId() == todo.getId()) {
                t1.setTitle(todo.getTitle());
                t1.setDescription(todo.getDescription());
                t1.setCompleted(todo.isCompleted());
            }
        }
    }

    public Iterable<Todo> findAll() {
        return todolist;
    }

    public Iterable<Todo> findByTitle(String title) {
        ArrayList<Todo> result = new ArrayList<>();
        for (Todo t : todolist) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                result.add(t);
            }
        }
        return result;
    }

    public Iterable<Todo> sortByTitleAsc() {
        Collections.sort(todolist, new Comparator<Todo>() {
            public int compare(Todo t1, Todo t2) {
                return t1.getTitle().compareToIgnoreCase(t2.getTitle());
            }
        });
        return todolist;
    }

    public Iterable<Todo> sortByTitleDsc() {
        Collections.sort(todolist, new Comparator<Todo>() {
            public int compare(Todo t1, Todo t2) {
                return t2.getTitle().compareToIgnoreCase(t1.getTitle());
            }
        });
        return todolist;
    }
}