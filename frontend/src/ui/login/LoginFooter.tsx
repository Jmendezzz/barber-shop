import { Link } from 'react-router-dom';
import GoogleSvg from '../GoogleSvg';
import Row from '../Row';

function LoginFooter() {
  return (
    <Row center={true}>
      <Row type="horizontal" center={true} gap={0.4}>
        <span className="text-white text-sm">¿No tienes cuenta?</span>
        <Link to="/register">
          <p className="underline text-sm text-white">Registrate</p>
        </Link>
      </Row>
      <div className="flex flex-col items-center gap-2">
        <p className="font-bebasNeue text-2xl">ó continua con:</p>
        <div className="border rounded-full p-2 bg-gray-900 cursor-pointer">
          <GoogleSvg />
        </div>
      </div>
    </Row>
  );
}

export default LoginFooter;
