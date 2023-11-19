import { Client } from "./Client"
import { EntityWithId } from "./EntityWithId"
export interface Opinion extends EntityWithId{
    client: Client
    opinion: string
}