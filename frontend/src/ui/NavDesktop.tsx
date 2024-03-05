import styled from 'styled-components';
import Logo from './Logo';
import { HiUser } from 'react-icons/hi';
import { device } from '../styles/devices';
import Hamburger from 'hamburger-react';
import { useNavBarContext } from '../context/NavBarContext';

function NavDesktop() {
  const { toggleMenu, isMenuOpened } = useNavBarContext();

  return (
    <StyledNav>
      <MobileLogo>
        <Logo size="sm" />
      </MobileLogo>
      <SideDiv content="flex-start">
        <Logo size="lg" />
      </SideDiv>

      <StyledUl>
        <li>Inicio</li>
        <li>Nosotros</li>
        <li>Reservas</li>
        <li>Contacto</li>
      </StyledUl>

      <SideDiv content="flex-end">
        <HiUser size="2rem" color="white" />
      </SideDiv>

      <StyledHamburger>
        <Hamburger
          toggled={isMenuOpened}
          onToggle={toggleMenu}
          color="white"
          hideOutline={false}
        />
      </StyledHamburger>
    </StyledNav>
  );
}

const StyledNav = styled.nav`
    display: flex;

  @media (min-width: ${device.desktop}) {
    padding: 0 20px;
    height: 20rem;
  }

  justify-content: space-between;
  align-items: center;
  width: 100%;
  padding: 15px 5px;
  z-index: 10000;

  & svg {
    width: 2.4rem;
    height: 2.4rem;
    color: var(--color-grey-50);
  }
  & svg:hover {
    cursor: pointer;
  }
  background-color: var(--primary-color);
`;

const StyledUl = styled.ul`
  @media (min-width: ${device.desktop}) {
    display: flex;
  }

  & li {
    cursor: pointer;
    transition: color 0.3s ease;

    &:hover {
      color: var(--contrast-color);
    }
  }

  display: none;
  justify-content: center;
  gap: 2rem;
  color: var(--color-grey-50);
  max-width: 700px;
  font-family: 'Bebas Neue', sans-serif;
  font-size: 2rem;
  letter-spacing: 1.4px;
`;
const SideDiv = styled.div<{ content: string }>`
  display: none;
  justify-content: ${(props) => props.content};

  @media (min-width: ${device.desktop}) {
    display: flex;
    flex: 1;
  }
`;

const StyledHamburger = styled.div`
  display: inline-block;
  @media (min-width: ${device.desktop}) {
    display: none;
    visibility: hidden;
  }
`;

const MobileLogo = styled.li`
  display: inline-block;
  @media (min-width: ${device.desktop}) {
    display: none;
  }
`;

export default NavDesktop;
