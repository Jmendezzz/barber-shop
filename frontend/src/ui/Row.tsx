import styled,{css} from 'styled-components';

interface Props {
  type?: 'vertical' | 'horizontal';
  gap?: number,
  center?:boolean
}
const Row = styled.div<Props>`
  display: flex;
  ${(props) => props.type === 'horizontal' && css`
    justify-content:space-around;
    align-items:center;
    gap:${props.gap}rem;
    ${props.center && css`justify-content:center;` }
  `}
  ${(props) => props.type === 'vertical' && css`
    flex-direction:column;
    gap:${props.gap}rem;
    ${props.center && css`align-items:center;` }
  `}
`;


Row.defaultProps = {
    type:'vertical',
    gap:1.6
}
export default Row;