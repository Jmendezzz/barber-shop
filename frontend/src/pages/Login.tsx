import styled from "styled-components"
import Section from "../ui/Section"
import Heading from "../ui/Heading"
import Form from "../ui/Form";
import Input from "../ui/Input"
import Row from "../ui/Row";
import Logo from "../ui/Logo";
import LoginFormRow from "../ui/LoginFormRow";
import Button from "../ui/Button";
import { device } from "../styles/devices";
import GoogleSvg from "../ui/GoogleSvg";

function Login() {
  return (
    <StyledSection >
        <header>
          <Logo size="lg"/>
          <Heading as="h2" position="center">Bienvenido de nuevo</Heading>
        </header>
        <FormRow>
          <Form>
              <StyledRow center={true}>
                <Heading as="h3" position="center">Inicia Sesión</Heading>
                <LoginFormRow>
                  <Input placeholder="Usuario" type="text" />
                </LoginFormRow>

                <LoginFormRow>
                  <Input placeholder="Contraseña" type="password" />
                </LoginFormRow>
                <Button >Iniciar Sesión</Button>
              </StyledRow>
          </Form>
        </FormRow>
        <span>o</span>
        <GoogleButton type="unfilled" size="medium"> <GoogleSvg /> Inicia sesión con Google</GoogleButton>
        
    </StyledSection>
  )
}

const StyledSection = styled(Section)`
    padding-top:2rem;
    background-color:var(--primary-color);
    height:100vh;
    display:flex;
    flex-direction:column;
    align-items:center;
    & span{
      color:var(--color-grey-50);
      font-size:1.2rem;
      margin:1rem 0;
    }
    

`

const StyledRow = styled(Row)`
  justify-content:center;
  width:100%;
`

const FormRow = styled.div`
  width:100%;

  @media (min-width: ${device.tablet}) {
    width:30rem;
  }
`

const GoogleButton = styled(Button)`
display:flex;
align-items:center;
justify-content:center;
gap:0.5rem;

`

export default Login