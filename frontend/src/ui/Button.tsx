import styled, { css } from 'styled-components';

interface ButtonProps {
  size?: 'small' | 'medium' | 'large';
  type?: 'filled' | 'unfilled' | 'danger';
}

const sizes = {
  small: css`
    font-size: 1.2rem;
    padding: 0.4rem 0.8rem;
    text-transform: uppercase;
    font-weight: 600;
    text-align: center;
  `,
  medium: css`
    font-size: 1.8rem;
    padding: 0.5rem 1.3rem;
    font-weight: 500;
  `,
  large: css`
    font-size: 1.6rem;
    padding: 1.2rem 2.4rem;
    font-weight: 500;
  `,
};

const types = {
  filled: css`
    background-color: var(--contrast-color);
    border: none;
    color: var(--primary-color);
    border:2px solid var(--contrast-color);
    &:hover {
      background-color: transparent;
      color: var(--contrast-color);
    }

  `,
  unfilled: css`
    background-color:transparent;
    border:2px solid var(--contrast-color);
    &:hover{
        background-color: var(--contrast-color);
        color: var(--primary-color);

    }
    color: var(--color-grey-50);
  `
};

const Button = styled.button<ButtonProps>`
  ${(props) => sizes[props.size as keyof typeof sizes]}
  ${(props) => types[props.type as keyof typeof types]}

  border-radius: var(--border-radius-sm);
  box-shadow: var(--shadow-sm);
  letter-spacing:0.4px;
  transition: background-color 0.2s ease-in-out;
  display: block;

`;

Button.defaultProps={
    size:'medium',
    type:'filled'
}

export default Button;
