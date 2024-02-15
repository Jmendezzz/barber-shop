import styled from 'styled-components';
import Logo from './Logo';
import { HiMenu } from 'react-icons/hi';
import { device } from '../styles/devices';
import { useNavBarContext } from '../context/NavBarContext';
import MenuMobile from './MenuMobile';

function NavMobile() {
  const { toggleMenu} = useNavBarContext();

  return (
    <>
      <StyledNav>
        <StyledList>
          <li>
            <Logo />
          </li>
          <li>
            <HiMenu onClick={toggleMenu} />
          </li>
        </StyledList>
      </StyledNav>

   
      <MenuMobile /> 
    </>
  );
}

const StyledNav = styled.nav`
  position:fixed;
  width: 100%;
  height: 78px;
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
