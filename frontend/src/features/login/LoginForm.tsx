import Form from '../../ui/Form';
import Input from '../../ui/Input';
import Button from '../../ui/Button';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { SubmitHandler, useForm } from 'react-hook-form';
import FormRow from '../../ui/FormRow';
import InputPassword from '../../ui/InputPassword';

interface FormFields {
  email: string;
  password: string;
}

function LoginForm() {
  const {
    register,
    handleSubmit,
    formState: { errors}
  } = useForm<FormFields>({mode:'onTouched'}); //Handle Submit validates the form and sends the data to the submitHandler function
  const submitHandler: SubmitHandler<FormFields> = ({ email, password }) => {
    console.log(email, password);
  };

  return (
    <Form onSubmit={handleSubmit(submitHandler)}>
      <FormRow error={errors.email}>
        <Input
          {...register('email',{
            required: 'El correo electrónico es requerido',
            pattern: {
              value: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/,
              message: 'Introduce un correo electrónico válido',
            },
          
          })}
          type="email"
          placeholder="Correo electronico"
        />
      </FormRow>
      <FormRow error={errors.password}>
        <InputPassword
          {...register('password', {
            required: 'La contraseña es requerida',
            minLength: {
              value: 8,
              message: 'La contraseña debe tener al menos 8 caracteres',
            },
          })}
        />
      </FormRow>
      <LoginOptions>
        <div className="flex items justify-center">
          <input type="checkbox" />
          <span className="text-xs text-white">Mantener sesión iniciada</span>
        </div>
        <Link to="#" className="underline text-white text-xs">
          Recuperar contraseña
        </Link>
      </LoginOptions>
      <Button type="filled">Iniciar sesión</Button>
    </Form>
  );
}

const LoginOptions = styled.footer`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 0.8rem;
`;

export default LoginForm;
