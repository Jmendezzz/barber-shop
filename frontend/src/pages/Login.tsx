import styled from 'styled-components';
import Section from '../ui/Section';
import Row from '../ui/Row';
import LoginForm from '../features/login/LoginForm';
import LoginFooter from '../ui/login/LoginFooter';
import HeadingLogo from '../ui/HeadingLogo';
import BackgroundWaved from '../ui/BackgroundWaved';
import { device } from '../styles/devices';

function Login() {
  return (
    <LoginSection>
      <LoginRow>
        <div className='flex flex-col items-center m-auto px-5 relative z-50'>
          <HeadingLogo
            direction="column"
            span="Bienvenido"
            title=" de vuelta"
          />
          <LoginForm />
          <LoginFooter />
        </div>
        <LoginImage src="login-image.png" />
      </LoginRow>
      <BackgroundWaved />
    </LoginSection>
  );
}

const LoginSection = styled(Section)`
    background: linear-gradient(
    180deg,
    rgba(10, 16, 29, 1) 47%,
    rgba(14, 14, 14, 1) 100%
  );
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const LoginRow = styled(Row)`
  @media (min-width: ${device.desktop}) {
    gap:0;
    height: 90%;
    width: 100%;
    max-width: 1500px;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    background: var(--primary-color);
  }
`;

const LoginImage = styled.img`
  width: 60%;
  height: 100%;
  display: none;
  @media (min-width: ${device.desktop}) {
    display: block;
  }
`;
export default Login;
