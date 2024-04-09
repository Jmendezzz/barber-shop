import { useState } from 'react';
import Input from './Input';
import { HiEye, HiEyeOff } from 'react-icons/hi';

function InputPassword() {
  const [showPassword, setShowPassword] = useState(false);

  const toggleShowPassword = () => {
    setShowPassword((prev) => !prev);
  };
  if (showPassword) {
    return (
      <div className="relative">
        <Input type="text" placeholder="Contraseña" />
        <HiEyeOff
          className="absolute top-1/2 right-2 transform -translate-y-1/2 cursor-pointer text-yellow-300"
          onClick={toggleShowPassword}
        />
      </div>
    );
  }
  return (
    <div className="relative">
      <Input type="password" placeholder="Contraseña" />
      <HiEye
        className="absolute top-1/2 right-2 transform -translate-y-1/2 cursor-pointer text-yellow-300"
        onClick={toggleShowPassword}
      />
    </div>
  );
}

export default InputPassword;
