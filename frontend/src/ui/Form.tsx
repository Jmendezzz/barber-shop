import styled from 'styled-components';

const Form = styled.form`
  overflow: hidden;
  font-size: 1.4rem;
  padding: 1rem 0.2rem;
  display:flex;
  flex-direction: column;
  width: 100%;
  gap: 1.2rem;
  & button {
    margin-top: 1.2rem;
  }
`;

export default Form;