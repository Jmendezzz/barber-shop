import styled from 'styled-components';
import Section from '../ui/Section';
import Row from '../ui/Row';
import LoginForm from '../features/login/LoginForm';
import LoginFooter from '../ui/login/LoginFooter';
import HeadingLogo from '../ui/HeadingLogo';
import BackgroundWaved from '../ui/BackgroundWaved';

function Login() {
  return (
    <LoginSection>
      <HeadingLogo direction='column' span='Bienvenido' title=' de vuelta' />
      <Row style={{ zIndex: 1000, position: 'relative' }}>
        <LoginForm />
        <LoginFooter />
      </Row>
      <BackgroundWaved />
    </LoginSection>
  );
}

const LoginSection = styled(Section)`
  background-color: var(--primary-color);
  height: 100vh;
`;


export default Login;
