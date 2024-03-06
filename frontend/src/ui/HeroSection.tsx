import styled from 'styled-components';
import Section from './Section';
import Heading from './Heading';
import Row from './Row';
import Button from './Button';
import Wave from 'react-wavify';
import { device } from '../styles/devices';
import { motion } from 'framer-motion';

function HeroSection() {
  return (
    <HeroSectionStyled>
      <Row gap={4}>
        <motion.div
          initial={{ x: -150, opacity: 0 }}
          animate={{ x: 0, opacity: 1 }}
          transition={{ ease: 'easeIn', duration: 0.2}}
        >
          <Row as={'header'}>
            <Heading>
              Expertos en <span>barbería</span>
            </Heading>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore
            </p>
          </Row>
        </motion.div>

        <Row center={true} gap={0}>
          <motion.div initial={{opacity:0}} animate={{opacity:1}} transition={{duration:1.4}}>
            <Button size="large" type="unfilled">
              AGENDA TU CITA
            </Button>
          </motion.div>
          <Footer>
            <StyledImg
              src="hero-image.png"
              initial={{ y: 130, opacity: 0 }}
              animate={{ y: 0, opacity: 1 }}
              transition={{ ease: 'easeOut', duration: 0.5 }}
            />
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
const StyledImg = styled(motion.img)`
  max-height: 300px;
  min-height: 190px;

  max-width: 320px;
  min-width: 150px;

  position: relative;
  top: 60px;

  @media (min-width: ${device.laptop}) {
    max-height: 800px;
    min-height: 450px;

    max-width: 600px;
    min-width: 300px;
  }
`;
const HeroSectionStyled = styled(Section)`
  background: rgb(10, 16, 29);
  padding-bottom: 0;
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
    width: 100vw;
    z-index: 1000;
    border: 0;
  }
`;

export default HeroSection;
