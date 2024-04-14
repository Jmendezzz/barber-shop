import { useState } from 'react';
import Button from '../../ui/Button';
import Row from '../../ui/Row';
import EmailRegisterForm from './EmailRegisterForm';

function RegisterForm() {
  const [isEmailRegister, setIsEmailRegister] = useState(false);

  if(isEmailRegister) {
    return(
      <EmailRegisterForm setEmailRegister={setIsEmailRegister}/>
    )
  }

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
