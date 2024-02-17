import styled from 'styled-components';
import Section from './Section';
import Heading from './Heading';
import Row from './Row';
import Button from './Button';

function HeroSection() {
  return (
    <HeroSectionStyled>
      <Row gap={5}>

        <Row as={"header"}>
          <Heading>Expertos en <span>barbería</span></Heading>
          <ParagraphStyled>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore
          </ParagraphStyled>
        </Row>

        <Row type='horizontal'>
            <div>
                <Button size='small' type="unfilled">AGENDA TU CITA</Button>
            </div>
            <StyledImg src='hero-image.png' />

        </Row>
      </Row>
    </HeroSectionStyled>
  );
}

const ParagraphStyled = styled.p`
  font-size: 16px;
`;
const StyledImg = styled.img`
    max-height:240px;
    min-height:190px;
    max-width:220px;
    min-width:150px
    
`
const HeroSectionStyled = styled(Section)`
  background: rgb(10, 16, 29);
  background: linear-gradient(
    180deg,
    rgba(10, 16, 29, 1) 47%,
    rgba(14, 14, 14, 1) 100%
  );
`;
export default HeroSection;
