import styled, { css } from 'styled-components';

const StyledLogo = styled.div`
  text-align: center;
`;

const ImgStyled = styled.img<{ size: 'sm' | 'md' | 'lg' }>`
  ${({ size }) =>
    size === 'sm' &&
    css`
      width: 11.5rem;
      height: 3.6rem;
    `}
  ${({ size }) =>
    size === 'md' &&
    css`
      width: 13.5rem;
      height: 4.2rem;
    `}
${({ size }) =>
    size === 'lg' &&
    css`
      width: 15.5rem;
      height: 5.2rem;
    `}
`;

function Logo({size='md'}: { size: 'sm' | 'md' | 'lg'}) {
  return (
    <StyledLogo>
      <ImgStyled src={'logo.png'} size={size} />
    </StyledLogo>
  );
}

export default Logo;
