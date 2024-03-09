import { motion } from 'framer-motion';
import Wave from 'react-wavify';
import styled from 'styled-components';
import { device } from '../styles/devices';

function BackgroundWaved() {
  return (
    <StyledBackGroundWaved
        initial={{height: 0}}
    animate={{height:"70%"}} >
         <Wave
          fill="#1e293b"
          paused={false}
          style={{ display: 'block' }}
          options={{ height: 30, amplitude: 15, speed: 0.2, points: 3 }}
        />
        <Fill />
    </StyledBackGroundWaved>
  )
}

const Fill = styled.div`
  height: 100%;
  background-color: var(--secondary-color);
`;

const StyledBackGroundWaved = styled(motion.div)`
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 0;
  gap: 0;
  margin:0;
  padding:0;
  overflow: hidden;

  @media (min-width: ${device.desktop}) {
    display: none;
  }
`;

export default BackgroundWaved