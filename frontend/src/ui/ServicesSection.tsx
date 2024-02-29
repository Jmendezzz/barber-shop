import styled from 'styled-components';
import Section from './Section';
import Heading from './Heading';
import Bento from './Bento';
import BentoItem from './BentoItem';
import Row from './Row';

function ServicesSection() {
  return (
    <StyledSection>
      <Row gap={4}>
        <Row as={'header'}>
          <Heading position="right">
            Nuestros <span>Servicios</span>
          </Heading>
          <p style={{textAlign:"right"}}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore
          </p>
        </Row>

        <Bento>
          <BentoItem
            gridColumn="span 2"
            gridRow="span 1"
            imgSrc="haircut.jpg"
            title="Corte de pelo"
          />
          <BentoItem
            gridColumn="2"
            gridRow="2"
            title="Faciales"
            imgSrc="facials.jpg"
          />
          <BentoItem
            gridColumn="1"
            gridRow="span 2 / span 3"
            imgSrc="beardcut.jpg"
            title="Barba"
          />
          <BentoItem
            gridColumn="2"
            gridRow="3"
            imgSrc="tinte.jpg"
            title="Tinte"
          />
          <BentoItem
            gridColumn="span 2"
            gridRow="span 1"
            imgSrc="design.jpg"
            title="Diseño"
          />
        </Bento>
      </Row>
    </StyledSection>
  );
}

const StyledSection = styled(Section)`
  background-color: var(--secondary-color);
`;
export default ServicesSection;
