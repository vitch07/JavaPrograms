package doa;

import entity.Todo;

import java.util.Map;

public interface TodoDao {
        void save( Todo todo);
        void deleteById(int id);
         Todo findbyId(int id);
         Todo update(Todo t);
         void deleteall();
         String toString();
         Map<Integer,Todo> findall();
}
