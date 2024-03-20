import { HiArrowNarrowLeft } from 'react-icons/hi'
import styled from 'styled-components'
import { device } from '../styles/devices'
import { useNavigate } from 'react-router-dom'

function GoBackButton() {
    const navigate = useNavigate();

    function goBackHandler(){
        navigate(-1);
    }

  return (
    <GoBackButtonStyled onClick={goBackHandler} />
  )
}

export default GoBackButton

const GoBackButtonStyled = styled(HiArrowNarrowLeft)`
  color: var(--color-grey-200);
  @media (min-width: ${device.tablet}) {
    display: none;
  }
    font-size: 2rem;
    color:var(--contrast-color);
  position: absolute;
  top: 1rem;
  left: 1rem;
`