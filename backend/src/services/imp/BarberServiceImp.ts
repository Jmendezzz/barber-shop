import { CrudService } from "../CrudService.js";
import { Barber } from "../../models/Barber.js";

export class BarberServiceImp implements CrudService<Barber>{ 

    getAll(): Array<Barber> {
        throw new Error("Method not implemented.");
    }

    getById(id: number): Barber {
        throw new Error("Method not implemented.");
    }

    create(entity: Barber): Barber {
        throw new Error("Method not implemented.");
    }

    updateById(id: number, entity: Barber): Barber {
        throw new Error("Method not implemented.");
    }

    deleteById(id: number): Barber {
        throw new Error("Method not implemented.");
    }

}