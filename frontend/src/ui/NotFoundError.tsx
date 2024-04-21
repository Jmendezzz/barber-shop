import styled from 'styled-components';
import Section from './Section';
import { motion } from 'framer-motion';
import Button from './Button';
import { Link } from 'react-router-dom';
import { HOME_ROUTE } from '../constants/routes';

function NotFoundError() {
  return (
    <NotFoundErrorSection>
      <header className='w-full'>
        <motion.h1 className="text-9xl  font-bebasNeue text-contrast">
          Oops!
        </motion.h1>
        <motion.h2 className="text-3xl font-inter">
          No hemos encontrado lo que buscas
        </motion.h2>
      </header>
      <section className='w-full'>
        <Button>
            <Link to={HOME_ROUTE}>
                Volver al inicio
            </Link>
        </Button>
      </section>
    </NotFoundErrorSection>
  );
}

const NotFoundErrorSection = styled(Section)`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  gap: 4rem;
  background-color: var(--secondary-color);
  width: 100%;
  height: 100%;
  color: var(--color-grey-100);
`;

export default NotFoundError;
