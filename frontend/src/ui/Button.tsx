import styled, { css } from 'styled-components';

interface ButtonProps {
  size?: 'small' | 'medium' | 'large';
  type?: 'filled' | 'unfilled' | 'danger';
}

const sizes = {
  small: css`
    font-size: 1rem;
    padding: 0.4rem 0.8rem;
    text-transform: uppercase;
    font-weight: 600;
    text-align: center;
  `,
  medium: css`
    font-size: 1.2rem;
    padding: 1rem 1.6rem;
    font-weight: 500;
  `,
  large: css`
    font-size: 1.4rem;
    padding: 1.2rem 2.4rem;
    font-weight: 500;
  `,
};

const types = {
  filled: css`
    background-color: var(--contrast-color);
    border: none;

  `,
  unfilled: css`
    background-color:transparent;
    border:2px solid var(--contrast-color);
    &:hover{
        background-color: var(--contrast-color);
    }
  `
};

const Button = styled.button<ButtonProps>`
  ${(props) => sizes[props.size as keyof typeof sizes]}
  ${(props) => types[props.type as keyof typeof types]}

  border-radius: var(--border-radius-sm);
  box-shadow: var(--shadow-sm);
  color:white;
`;

Button.defaultProps={
    size:'medium',
    type:'filled'
}

export default Button;
