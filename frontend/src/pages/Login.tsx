import styled from 'styled-components';
import Section from '../ui/Section';
import Logo from '../ui/Logo';
import Heading from '../ui/Heading';
import Wave from 'react-wavify';
import Row from '../ui/Row';
import { device } from '../styles/devices';
import Form from '../ui/Form';
import Input from '../ui/Input';
import Button from '../ui/Button';
import LooginFooter from '../ui/LooginFooter';
import { motion } from 'framer-motion';

function Login() {
  return (
    <LoginSection>
      <LoginHeader>
        <Logo size="lg" />
        <Heading as="h1" style={{ textAlign: 'center' }}>
          <span>Bienvenido </span>
          de vuelta
        </Heading>
      </LoginHeader>
      <Row style={{ zIndex: 1000, position: 'relative' }}>
        <Form>
          <Input type="email" placeholder="Correo electronico" />
          <Input type="password" placeholder="Contraseña" />
          <LoginOptions >
            <div className='flex items justify-center'>
              <input type="checkbox" />
              <span className='text-xs text-white'> Mantener sesión iniciada</span>
            </div>
            <a href="#" className='underline text-white text-xs'>
              Recuperar contraseña
            </a>
          </LoginOptions>
          <Button type="filled">Iniciar sesión</Button>
          <LooginFooter />
        </Form>
      </Row>

      <BackGroundWaved initial={{height:0}} animate={{height:"70%"}}>
        <Wave
          fill="#1e293b"
          paused={false}
          style={{ display: 'block' }}
          options={{ height: 30, amplitude: 15, speed: 0.2, points: 3 }}
        />
        <StyledWave />
      </BackGroundWaved>
    </LoginSection>
  );
}

const LoginSection = styled(Section)`
  background-color: var(--primary-color);
  height: 100vh;
`;
const LoginHeader = styled.header`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2rem;
`;

const StyledWave = styled.div`
  height: 100%;

  background-color: var(--secondary-color);
`;

const BackGroundWaved = styled(motion.div)`
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 0;
  gap: 0;
  margin:0;
  padding:0;
  overflow: hidden;

  @media (min-width: ${device.desktop}) {
    display: none;
  }
`;
const LoginOptions = styled.footer`
  display:flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 0.8rem;
`


export default Login;
