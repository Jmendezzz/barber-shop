import { EntityWithId } from "./EntityWithId";
export interface Location extends EntityWithId{
    image: string,
    country: string,
    city: string,
    direction: string,
    description: string
}