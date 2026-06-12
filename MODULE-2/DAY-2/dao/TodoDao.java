package dao;


import Todo.Todo;

public interface TodoDao {
    public void save(Todo todo);
    public void deleteById(int id);
    public void deleteAll();
    public Iterable<Todo> findAll();
    public Iterable<Todo> findByTitle(String title);
    public Iterable<Todo> sortByTitleAsc();
    public Iterable<Todo> sortByTitleDsc();
}
