import { useState } from 'react';
import Button from '../../ui/Button';
import GoogleSvg from '../../ui/GoogleSvg';
import Row from '../../ui/Row';

function RegisterForm() {
  const [isEmailRegister, setIsEmailRegister] = useState(false);

  if(isEmailRegister) return;

  return (
    <Row>
      <Button type="filled" onClick={()=> setIsEmailRegister(prev => !prev)} >Registrate con correo electronico</Button>
      <Button type="unfilled">
          Registrate con Google
      </Button>
    </Row>
  );
}

export default RegisterForm;
