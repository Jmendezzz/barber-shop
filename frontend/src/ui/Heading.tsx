import styled, { css } from 'styled-components';

interface Props {
  type?: string;
  position?: 'right' | 'center' | 'left';
}


const Heading = styled.h1<Props>`
  ${(props) =>
    props.as === 'h1' &&
    css`
      font-size: 5rem;
    `}

  ${(props) =>
    props.as === 'h2' &&
    css`
      font-size: 3rem;
    `}

  ${(props) =>
    props.as === 'h3' &&
    css`
      font-size: 2rem;
    `}

    ${(props) =>
    props.as === 'h4' &&
    css`
      font-size: 1rem;
      text-align: center;
    `}
    z-index:1000;
    text-align:${(props) => props.position};
    font-family: "Bebas Neue", sans-serif;
    font-weight: 300;
    color: var(--color-grey-50);
    & span{
        color:var(--contrast-color);
        }  `;

Heading.defaultProps={
    as:"h1",
    position:'left'
}

export default Heading;