import styled from 'styled-components';
import Logo from './Logo';
import Heading from './Heading';

interface Props {
  direction: 'row' | 'column';
  span?: string;
  title: string;
  heading: "h1" | "h2" | "h3" | "h4" | "h5" | "h6";
}
function HeadingLogo({ direction, title, span, heading }: Props) {
  return (
    <StyledHeader direction={direction}>
      <Logo size="lg" />
      <Heading as={heading} style={{ textAlign: 'center' }}>
        <span>{span} </span>
        {title}
      </Heading>
    </StyledHeader>
  );
}

const StyledHeader = styled.header<{direction:'row' | 'column'}>`
  display: flex;
  flex-direction: ${(props) => props.direction};
  align-items: center;
  gap: 1rem;
  padding:0rem;
`;
export default HeadingLogo;
