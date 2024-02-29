import styled from 'styled-components';
import Heading from './Heading';

interface Props {
  title: string;
  gridColumn: string;
  gridRow: string;
  imgSrc: string;
}

function BentoItem({ title, gridColumn, gridRow, imgSrc }: Props) {
  return (
    <BentoItemStyled gridColumn={gridColumn} gridRow={gridRow}>
      <StyledBgGradient />
      <StyledImg   imgSrc={imgSrc}/>
      <Heading as={'h2'}>{title}</Heading>
    </BentoItemStyled>
  );
}
const StyledImg = styled.div<{ imgSrc: string }>`
  transition: all 0.5s;
  background-image: url(${(props) => props.imgSrc});
  position: absolute;
  top:0;
  bottom:0;
  width:100%;
  height:100%;
  background-size: cover;
    background-position: center;
  border:none;
  outline:none;
`;
const BentoItemStyled = styled.article<{
  gridColumn: string;
  gridRow: string;
}>`
  user-select: none;
  overflow:hidden;
  display: flex;
  flex-direction: column;
  height: 100%;
  justify-content: end;
  backdrop-filter: blur(12px);
  border-radius: var(--border-radius-lg);
 
  ${(props) => `grid-column:${props.gridColumn}`};
  ${(props) => `grid-row:${props.gridRow}`};
  
  & h2 {
    padding: 0 10px;
  }
  &:hover div {
    transform: scale(1.1);
  }
  outline:none;
`;

const StyledBgGradient = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  bottom: 0;
  z-index: 10;
  background: linear-gradient(transparent 60%, black 100%);
`;
export default BentoItem;
