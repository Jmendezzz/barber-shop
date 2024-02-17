import styled,{css} from 'styled-components';

interface Props {
  type?: 'vertical' | 'horizontal';
  gap?: number
}
const Row = styled.div<Props>`
  display: flex;
  ${(props) => props.type === 'horizontal' && css`
    justify-content:space-around;
    align-items:center;
  `}
  ${(props) => props.type === 'vertical' && css`
    flex-direction:column;
    gap:${props.gap}rem;
  `}
`;


Row.defaultProps = {
    type:'vertical',
    gap:1.6
}
export default Row;