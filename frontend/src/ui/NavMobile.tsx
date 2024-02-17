import styled from 'styled-components';
import Logo from './Logo';
import { device } from '../styles/devices';
import { useNavBarContext } from '../context/NavBarContext';
import Hamburger from 'hamburger-react';

function NavMobile() {
  const { toggleMenu, isMenuOpened} = useNavBarContext();

  return (
    <>
      <StyledNav>
        <StyledList>
          <li>
            <Logo />
          </li>
          <li>
            <Hamburger toggled={isMenuOpened} onToggle={toggleMenu} color='white' hideOutline={false} />
          </li>
        </StyledList>
      </StyledNav>
    </>
  );
}

const StyledNav = styled.nav`
  position:sticky;
  width: 100%;
  padding:12px 5px;
  display: flex;
  align-items: center;
  background-color: var(--primary-color);
  z-index:10000;
  & svg {
    width: 2.4rem;
    height: 2.4rem;
    color: white;
  }
  & svg:hover {
    cursor: pointer;
  }

  @media (min-width: ${device.laptop}) {
    display: none;
  }
`;

const StyledList = styled.ul`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  padding: 0px 5px;
`;

export default NavMobile;
