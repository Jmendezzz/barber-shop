import Form from '../../ui/Form'
import Input from '../../ui/Input'
import Button from '../../ui/Button'
import styled from 'styled-components'
import { Link } from 'react-router-dom'

function LoginForm() {
  return (
    <Form>
          <Input type="email" placeholder="Correo electronico" />
          <Input type="password" placeholder="Contraseña" />
          <LoginOptions >
            <div className='flex items justify-center'>
              <input type="checkbox" />
              <span className='text-xs text-white'> Mantener sesión iniciada</span>
            </div>
            <Link to="#" className='underline text-white text-xs'>
              Recuperar contraseña
            </Link>
          </LoginOptions>
          <Button type="filled">Iniciar sesión</Button>
        </Form>
  )
}

const LoginOptions = styled.footer`
  display:flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 0.8rem;
`


export default LoginForm