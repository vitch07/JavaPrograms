package fullpackageDaoJdbc.connection.dao;

import fullpackageDaoJdbc.connection.entity.Todo;

import java.util.Map;

public interface TodoDao {
        void save( Todo todo);
        void deleteById(int id);
         Todo findbyId(int id);
         Todo update(Todo t);
         void deleteall();
         Map<Integer,Todo> findall();
}
