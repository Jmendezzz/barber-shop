package barber.gerard.backend.infraestructure.ports.out;

public interface EntityRepository<T>{
  public T save(T entity);

  public T getById(Long id);

  public T deleteById(Long id);


}
