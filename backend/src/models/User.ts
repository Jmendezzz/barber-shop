import mongoose from "mongoose";

export interface User {
  fullName: string;
  email: string;
  password: string;
}

const UserSchema = new mongoose.Schema<User>(
  {
    fullName: {
      type: String,
      required: true,
      maxLength: 50,
      minLength: 5,
    },
    email: {
      type: String,
      required: true,
      unique: true,
      maxLength: 50,
      minLength: 5,
    },
    password: {
      type: String,
      required: true,
      minLength: 7,
    },
  },
  { timestamps: true }
);

export default mongoose.model("User", UserSchema);
