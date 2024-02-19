import styled from 'styled-components';
import Heading from './Heading';

interface Props {
  title: string;
  gridColumn: string;

}

function BentoItem({ title, gridColumn}: Props) {
  return (
    <BentoItemStyled gridColumn={gridColumn}>
      <Heading as={"h2"}>{title}</Heading>
    </BentoItemStyled>
  );
}
const BentoItemStyled = styled.article<{gridColumn:string}>`
    user-select:none;
    display:flex;
    flex-direction:column;
    height:100%;
    justify-content:end;
    position:relative;
    backdrop-filter: blur(12px);
    border-radius:var(--border-radius-sm);
    border:1px solid white;
    padding:1rem;
    ${props=> `grid-column:${props.gridColumn}`}
`;

export default BentoItem;
