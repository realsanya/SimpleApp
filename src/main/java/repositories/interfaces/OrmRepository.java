package repositories.interfaces;

import java.util.List;

public interface OrmRepository<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T entity);
}
