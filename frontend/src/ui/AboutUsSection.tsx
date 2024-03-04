import styled from "styled-components"
import Heading from "./Heading"
import Row from "./Row"
import Section from "./Section"


function AboutUsSection() {
  return (
    <AboutUsSectionStyled>
        <Row as={'header'}>
          <Heading>
            Sobre <span>Nosotros</span>
          </Heading>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore
          </p>
        </Row>
    </AboutUsSectionStyled>
  )
}


const AboutUsSectionStyled = styled(Section)`

  background: rgb(10, 16, 29);
  background: linear-gradient(
    180deg,
    rgba(10, 16, 29, 1) 47%,
    rgba(14, 14, 14, 1) 100%
  );
  
`

export default AboutUsSection