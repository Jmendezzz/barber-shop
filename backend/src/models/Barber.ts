import mongoose from "mongoose";
import { User } from "./User.js";
import UserSchema from "./User.js";

export interface Barber extends User {
  puntuation: number;
}

const BarberSchema = UserSchema.extend({
  fullName: String,
  email: String,
  password: String,
});
