import styled from "styled-components"
import Logo from "./Logo"
import { HiUser } from "react-icons/hi"
import { device } from "../styles/devices"



function NavDesktop() {
  return (
    <StyledNav>
        <SideDiv content="flex-start">
        <Logo size="lg"/>
        </SideDiv>
        <StyledUl>
            <li>Inicio</li>
            <li>Nosotros</li>
            <li>Reservas</li>
            <li>Contacto</li>
        </StyledUl>
        <SideDiv content="flex-end">
            <HiUser size="2rem" color="white"/>
        </SideDiv>
    </StyledNav>
  )
}

const StyledNav = styled.nav`
    display:none;

    @media(min-width: ${device.desktop}){
        display:flex;
    }
    justify-content:space-between;
    align-items:center;
    padding:0 20px;
    height:20rem;
    background-color:var(--primary-color);
`

const StyledUl = styled.ul`
    display:flex;
    justify-content:center;
    gap:2rem;
    color:var(--color-grey-50);
    max-width:700px;
    font-family: 'Bebas Neue', sans-serif;
    font-size:2rem;
    letter-spacing:1.4px;
     & li{
        cursor:pointer;
        transition:color 0.3s ease;

        &:hover{
            color:var(--contrast-color);
        }
     }
    `
const SideDiv = styled.div<{content:string}>`
    display:flex;
    justify-content:${props=>props.content};

    @media(min-width:${device.desktop} ){
        flex:1;
    }
    `

export default NavDesktop