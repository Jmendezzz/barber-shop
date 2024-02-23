import styled from "styled-components"
import Section from "../ui/Section"
import Heading from "../ui/Heading"
import Form from "../ui/Form";
import Input from "../ui/Input"
import Row from "../ui/Row";

function Login() {
  return (
    <StyledSection>
        
        <Heading as="h2" position="center">Bienvenido de nuevo</Heading>
        <Form>
            <Row>
                <Input />

            </Row>
        </Form>
     
    </StyledSection>
  )
}

const StyledSection = styled(Section)`
    background-color:var(--primary-color);
    height:100vh;
    color:white;
`

export default Login