package repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    List<T> findAll();

    List<T> findAll(int page, int size);

    Optional<T> findById(Integer id);

    void save(T entity);

    void update(T entity);

    void deleteById(Long id);

    void delete(T entity);
}
