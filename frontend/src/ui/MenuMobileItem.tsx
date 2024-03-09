import { motion } from 'framer-motion';
import { ReactElement } from 'react';
import { HiOutlineChevronRight } from 'react-icons/hi';
import styled from 'styled-components';

const MenuItemRow = styled(motion.li)`
  display: flex;
  justify-content: space-between;
  align-items: center;
  & label:hover {
    color: var(--contrast-color);
    cursor: pointer;
  }
  & label:hover + svg {
    transform: scale(1.2);
    transition: transform 0.3s ease-in-out; 
    color: var(--contrast-color);
  }
    `;
const StyledLabel = styled(motion.div)`
  display: flex;
  align-items: center;
  gap: 3px;

`;

function MenuMobileItem({
  children,
}: {
  children: ReactElement[] | ReactElement;
}) {
  return (
    <MenuItemRow
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      exit={{ opacity: 0 }}
      transition={{ duration: 0.1 }}
    >
      {children}
    </MenuItemRow>
  );
}
function Icon() {
  return <HiOutlineChevronRight />;
}
function Label({ children }: { children: ReactElement | ReactElement[] | string }) {
  return <StyledLabel as="label">{children}</StyledLabel>;
}

MenuMobileItem.Icon = Icon;
MenuMobileItem.Label = Label;

export default MenuMobileItem;
