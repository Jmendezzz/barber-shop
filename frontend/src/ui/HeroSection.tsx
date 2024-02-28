import styled from 'styled-components';
import Section from './Section';
import Heading from './Heading';
import Row from './Row';
import Button from './Button';
import Wave from 'react-wavify';
import { device } from '../styles/devices';

function HeroSection() {
  return (
    <HeroSectionStyled>
      <Row gap={4}>
        <Row as={'header'}>
          <Heading>
            Expertos en <span>barbería</span>
          </Heading>
          <ParagraphStyled>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore
          </ParagraphStyled>
        </Row>

        <Row center={true} gap={0}>
          <div>
            <Button size="large" type="unfilled">
              AGENDA TU CITA
            </Button>
          </div>
          <Footer>
            <StyledImg src="hero-image.png" />
            <Wave
              fill="#1e293b"
              paused={false}
              style={{ display: 'flex' }}
              options={{
                height: 30,
                amplitude: 30,
                speed: 0.12,
                points: 3,
              }}
              
            />
          </Footer>
        </Row>
      </Row>
    </HeroSectionStyled>
  );
}

const ParagraphStyled = styled.p`
  font-size: 20px;
`;
const StyledImg = styled.img`
  max-height: 300px;
  min-height: 190px;

  max-width: 320px;
  min-width: 150px;

  position:relative;
  top:60px;

  @media (min-width:${device.laptop}) {
    max-height: 500px;
    min-height: 350px;

    max-width: 400px;
    min-width: 200px;
  }
`;
const HeroSectionStyled = styled(Section)`
  background: rgb(10, 16, 29);
  padding-bottom:0px;
  background: linear-gradient(
    180deg,
    rgba(10, 16, 29, 1) 47%,
    rgba(14, 14, 14, 1) 100%
  );
`;

const Footer = styled.footer`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100vw;
  position: relative;
  margin-top: auto;

  & svg {
    bottom: 0;
    width:100vw;
    z-index:1000;
    border:0;
  
  }
  & div{
    
  }
`;

export default HeroSection;
