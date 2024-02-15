import { AnimatePresence, motion } from 'framer-motion';
import styled from 'styled-components';
import { useNavBarContext } from '../context/NavBarContext';

function MenuMobile() {
  const { isMenuOpened } = useNavBarContext();

  return (
    <AnimatePresence>
      {isMenuOpened && (
        <StyledMenu
          key="mobileMenu"
          initial={{ height: '0vh', }}
          animate={{ height: '100vh'}}
          exit={{ height: '0vh'}} 
          transition={{ease:"easeOut", duration: 0.2 }}
        >
          <ul>
            <li>Nosotros</li>
          </ul>
        </StyledMenu>
      )}
    </AnimatePresence>
  );
}
const StyledMenu = styled(motion.div)`
  height: 100%;
  width: 100%;
  background-color: var(--primary-color);
  position:fixed;
`;
export default MenuMobile;
