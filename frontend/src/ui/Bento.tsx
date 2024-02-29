import { ReactElement } from "react"
import styled from "styled-components"
import { device } from "../styles/devices"

function Bento({children}:{children:ReactElement | ReactElement[]}) {
  return (
    <BentoStyled>{children}</BentoStyled>
  )
}

const BentoStyled = styled.section`
    width:100%;
    display:grid;
    grid-template-columns: repeat(2, 1fr); //minmax
    grid-template-rows:repeat(4, 500px);
    
    @media (max-width:${device.laptop}){
      grid-template-rows:repeat(4, 160px);
    }
    gap:10px;

    `

export default Bento