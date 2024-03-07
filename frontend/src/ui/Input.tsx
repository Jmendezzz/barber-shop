import styled from "styled-components";


const Input = styled.input`
  border: 1px solid var(--color-grey-300);
  background-color: transparent;
  display: block;
  width: 100%;
  border-radius: var(--border-radius-sm);
  padding: 0.4rem 1.2rem;
  box-shadow: var(--shadow-sm);
  color: var(--color-grey-300);
  outline: none;
  font-size: 1rem;
  &::placeholder {
    color: var(--color-grey-500);
    font-size: 1rem;
  }
`;

export default Input;