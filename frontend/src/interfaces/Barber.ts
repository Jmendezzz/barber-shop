import { EntityWithId } from "./EntityWithId";

export interface Barber  extends EntityWithId{
    fullName: string,
    image: string,
    stars: number

}