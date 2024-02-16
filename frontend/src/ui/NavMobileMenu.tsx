import styled from "styled-components"
import NavMobile from "./NavMobile"
import MenuMobile from "./MenuMobile"

const StyledDiv = styled.div`
    display:flex;
    flex-direction:column;
`

function NavMobileMenu() {
  return (
    <StyledDiv>
        <NavMobile />
        <MenuMobile />
    </StyledDiv>
  )
}

export default NavMobileMenu