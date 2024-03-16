import styled from 'styled-components';
import Logo from './Logo';
import Heading from './Heading';

interface Props {
  direction: 'row' | 'column';
  span?: string;
  title: string;
}
function HeadingLogo({ direction, title, span }: Props) {
  return (
    <StyledHeader direction={direction}>
      <Logo size="lg" />
      <Heading as="h1" style={{ textAlign: 'center' }}>
        <span>{span}</span>
        {title}
      </Heading>
    </StyledHeader>
  );
}

const StyledHeader = styled.header<{direction:'row' | 'column'}>`
  display: flex;
  flex-direction: ${(props) => props.direction};
  justify-content: center;
  align-items: center;
  gap: 2rem;
`;
export default HeadingLogo;
