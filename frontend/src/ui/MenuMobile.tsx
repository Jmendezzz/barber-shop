import { motion } from 'framer-motion';
import { createPortal } from 'react-dom';
import styled from 'styled-components';
import Logo from './Logo';
import { HiX } from 'react-icons/hi';
import { useNavBarContext } from '../context/NavBarContext';

const StyledMenu = styled(motion.div)`
  height: 100vh;
  width: 100%;
  background-color: var(--primary-color);
  position: fixed;
  z-index: 1000;
  top: 0;
`;

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding:4px;


  & svg {
    color: white;
    width: 2.4rem;
    height: 2.4rem;
  }
`;

function MenuMobile() {
  const { toggleMenu } = useNavBarContext();
  return createPortal(
    <StyledMenu
      initial={{ x: '100%' }}
      animate={{ x: 0 }}
      transition={{ ease: 'easeIn', duration: 0.2 }}
    >
      <StyledHeader>
        <Logo />
        <HiX onClick={toggleMenu} />
      </StyledHeader>
      <ul>
        <li>Nosotros</li>
      </ul>
    </StyledMenu>,
    document.body
  );
}

export default MenuMobile;
