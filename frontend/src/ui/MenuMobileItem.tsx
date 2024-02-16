import { ReactElement } from "react"
import {HiOutlineChevronRight } from "react-icons/hi";
import styled from "styled-components";

const MenuItemRow = styled.li`
    display:flex;
    justify-content:space-between;
    align-items:center;
    &:hover{
        color:yellow;
    }
`
const StyledLabel = styled.div`
    display:flex;
    align-items:center;
    gap:2px;
`

function MenuMobileItem({children}: {children:ReactElement[] | ReactElement}) {
  return (
    <MenuItemRow>{children}</MenuItemRow>
  )
}
function Icon(){
    return(
        <HiOutlineChevronRight />
    )
}
function Label({children}:{children:ReactElement | ReactElement[] }){
    return <StyledLabel as="label">{children}</StyledLabel>
}

MenuMobileItem.Icon = Icon;
MenuMobileItem.Label = Label;

export default MenuMobileItem