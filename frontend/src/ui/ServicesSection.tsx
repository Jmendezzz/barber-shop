import styled from 'styled-components';
import Section from './Section';
import Heading from './Heading';
import Bento from './Bento';
import BentoItem from './BentoItem';

function ServicesSection() {
  return (
    <StyledSection>
      <Heading position="right">
        Nuestros <span>Servicios</span>
      </Heading>

      <Bento>
        <BentoItem gridColumn='span 2'  title='Corte de pelo'/>
        <BentoItem gridColumn='span 1'  title='Barba'/>
        <BentoItem gridColumn='span 1'  title='Facial'/>
        <BentoItem gridColumn='span 1 / span 2'  title='Lmao'/>
        <BentoItem gridColumn='span 2'  title='Lmao 2'/>
      </Bento>

    </StyledSection>
  );
}

const StyledSection = styled(Section)`
  background-color: var(--secondary-color);
`;
export default ServicesSection;
