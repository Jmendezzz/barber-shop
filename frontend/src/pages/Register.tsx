import styled from "styled-components";
import Section from "../ui/Section";

function Register() {
  return (
    <RegisterSection>Register</RegisterSection>
  )
}

const RegisterSection = styled(Section)`
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
export default Register