import styled from "styled-components"

const StyledLogo = styled.div`
    text-align: center;
`;

const ImgStyled = styled.img`
    width:11.5rem;
    height:3.6rem;
        
`

function Logo() {
    return (
        <StyledLogo>
                <ImgStyled src={"logo.png"}/>
        </StyledLogo>
    )
}

export default Logo