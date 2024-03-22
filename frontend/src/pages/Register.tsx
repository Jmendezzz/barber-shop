import styled from "styled-components";
import Section from "../ui/Section";
import HeadingLogo from "../ui/HeadingLogo";

import GoBackButton from "../ui/GoBackButton";
import RegisterForm from "../features/register/RegisterForm";

function Register() {
  return (
    <RegisterSection>
      <GoBackButton/>
      <HeadingLogo heading="h1" direction="column" title="tu experiencia aquí" span="Comienza"/>
      <RegisterForm/>
    </RegisterSection>
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
  flex-direction: column;
  justify-content: start;
  align-items: center;
`;

export default Register