import Input from '../../ui/Input';
import Heading from '../../ui/Heading';
import Form from '../../ui/Form';
import Button from '../../ui/Button';
import Row from '../../ui/Row';
import { useForm } from 'react-hook-form';

interface FormFields {
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  password: string;
}

function EmailRegisterForm() {
  const { register, handleSubmit } = useForm<FormFields>({ mode: 'onTouched' });

  const submitHandler = (data: FormFields) => {
    console.log(data);
  };

  return (
    <Row>
      <Form onSubmit={handleSubmit(submitHandler)}>
        <div className="flex gap-2">
          <Input
            {...register('firstName', {
              required: 'El nombre es requerido',
            })}
            type="text"
            placeholder="Nombre"
          />
          <Input
            {...register('lastName', {
              required: 'El apellido es requerido',
            })}
            type="text"
            placeholder="Apellido"
          />
        </div>
        <Input
          {...register('email', {
            required: 'El correo electrónico es requerido',
            pattern: {
              value: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/,
              message: 'Introduce un correo electrónico válido',
            },
          })}
          type="email"
          placeholder="Correo electronico"
        />
        <Input
          {...register('phone')}
          type="text"
          placeholder="Número de celular"
        />
        <Input
          {...register('password', {
            required: 'La contraseña es requerida',
            minLength: {
              value: 8,
              message: 'La contraseña debe tener al menos 8 caracteres',
            },
          })}
          type="password"
          placeholder="Contraseña"
        />
        <div>
          <Heading position="left" as="h4">
            Fecha de nacimiento
          </Heading>
          <div className="flex gap-2">
            <Input type="text" placeholder="Día" />
            <Input type="text" placeholder="Mes" />
            <Input type="text" placeholder="Año" />
          </div>
        </div>
        <Button>Registrarse</Button>
      </Form>
    </Row>
  );
}

export default EmailRegisterForm;
