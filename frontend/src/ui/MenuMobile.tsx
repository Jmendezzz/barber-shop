import { AnimatePresence, motion } from 'framer-motion';
import styled from 'styled-components';
import { useNavBarContext } from '../context/NavBarContext';
import MenuMobileItem from './MenuMobileItem';
import { HiUserCircle } from 'react-icons/hi';

function MenuMobile() {
  const { isMenuOpened } = useNavBarContext();

  return (
    <AnimatePresence>
      {isMenuOpened && (
        <StyledMenu
          key="mobileMenu"
          initial={{ height: '0vh' }}
          animate={{ height: '100vh', y: 80 }}
          exit={{ height: '0vh', y: 0 }}
          transition={{ ease: 'easeOut', duration: 0.2 }}
        >
          <StyledList>
            <MenuHeader>
              <MenuMobileItem>
                <MenuMobileItem.Label>
                  <HiUserCircle fontSize={'40px'} />
                  <label>Inicia sesión/Registrate</label>
                </MenuMobileItem.Label>
                <MenuMobileItem.Icon />
              </MenuMobileItem>
            </MenuHeader>

            <MenuMobileItem key="loginItem">
              <MenuMobileItem.Label>
                <label>Sedes</label>
              </MenuMobileItem.Label>
              <MenuMobileItem.Icon />
            </MenuMobileItem>

            <MenuMobileItem key="barberItem">
              <MenuMobileItem.Label>
                <label>Barberos</label>
              </MenuMobileItem.Label>
              <MenuMobileItem.Icon />
            </MenuMobileItem>

            <MenuMobileItem key="servicesItem">
              <MenuMobileItem.Label>
                <label>Servicios</label>
              </MenuMobileItem.Label>
              <MenuMobileItem.Icon />
            </MenuMobileItem>
          </StyledList>
        </StyledMenu>
      )}
    </AnimatePresence>
  );
}
const StyledMenu = styled(motion.div)`
  width: 100%;
  background: rgb(15, 23, 42);
  background: linear-gradient(
    180deg,
    rgba(15, 23, 42, 1) 47%,
    rgba(30, 41, 59, 1) 100%
  );
  position: fixed;
  display: flex;
  padding: 30px 10px;
`;

const StyledList = styled.ul`
  color: white;
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

const MenuHeader = styled.header`
  font-size: 20px;
  padding-bottom: 40px;
`;

export default MenuMobile;
