package doa;

import entity.Todo;

import java.util.HashMap;
import java.util.Map;

public class ToDoaImplCollections implements TodoDao{
    Map<Integer,Todo> maps = new HashMap<>();
    @Override
    public void save( Todo todo) {
           maps.put(todo.getTodoId(),todo);
    }

    @Override
    public void deleteById(int id) {
        maps.remove(id);
    }

    @Override
    public Todo findbyId(int id) {
        return maps.get(id);

    }

    @Override
    public Todo update(Todo t) {
        if(!maps.containsKey(t.getTodoId())){
            return null;
        }
        maps.put(t.getTodoId(),t);
        return maps.get(t.getTodoId());
    }



    @Override
    public void deleteall() {
        maps.clear();

    }

    public String toString(){
        StringBuilder st = new StringBuilder();
        maps.forEach((id,t)-> System.out.println(st.append("Todo_id " + t.getTodoId() +
                "task " + t.getTask() + "status" + t.getStatus())));
        return st.toString();
    }

    @Override
    public Map<Integer, Todo> findall() {
        maps.forEach((id,todo) -> System.out.println(id + " : " + todo));
        return maps;
    }
}
