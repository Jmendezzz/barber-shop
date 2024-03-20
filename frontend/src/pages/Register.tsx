import styled from "styled-components";
import Section from "../ui/Section";
import HeadingLogo from "../ui/HeadingLogo";

import GoBackButton from "../ui/GoBackButton";

function Register() {
  return (
    <RegisterSection>
      <GoBackButton/>
      <HeadingLogo heading="h1" direction="column" title="tu experiencia aquí" span="Comienza"/>
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
  align-items: start;
`;

export default Register