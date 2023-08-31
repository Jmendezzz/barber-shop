
export interface CrudService<T> { 

    getAll(): Array<T>;

    getById(id: number): T;

    create(entity: T): T;

    updateById(id: number, entity: T): T;

    deleteById(id: number): T;

}