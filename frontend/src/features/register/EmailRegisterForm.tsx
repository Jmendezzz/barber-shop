import Input from '../../ui/Input';
import Heading from '../../ui/Heading';
import Form from '../../ui/Form';
import Button from '../../ui/Button';

function EmailRegisterForm() {
  return (
    <div>
      <Form>
        <div className="flex gap-2">
          <Input type="text" placeholder="Nombre" />
          <Input type="text" placeholder="Apellido" />
        </div>
        <Input type="email" placeholder="Correo electronico" />
        <Input type="text" placeholder="Número de celular" />
        <Input type="password" placeholder="Contraseña" />
        <Heading position="left" as="h4">
          Fecha de nacimiento
        </Heading>
        <div className="flex gap-2">
          <Input type="text" placeholder="Día" />
          <Input type="text" placeholder="Mes" />
          <Input type="text" placeholder="Año" />
        </div>
      </Form>
        <Button>Registrarse</Button>
    </div>
  );
}

export default EmailRegisterForm;
