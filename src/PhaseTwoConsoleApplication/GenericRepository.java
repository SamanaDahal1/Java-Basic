package PhaseTwoConsoleApplication;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T,ID>{
    void save(T entity);
    Optional<T> find(ID id);
    List<T> findAll();
    boolean deleteBy(ID id);
}
