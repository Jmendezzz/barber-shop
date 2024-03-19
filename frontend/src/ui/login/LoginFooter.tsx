import { Link } from "react-router-dom";
import GoogleSvg from "../GoogleSvg";
import Row from "../Row";

function LoginFooter() {
  return (
    <Row center={true}>
        <Row type="horizontal" center={true} gap={1}>
        <span className="text-white text-sm">¿No tienes cuenta?</span>
        <Link to="/register">
            <p className="underline text-sm text-white">
                Registrate
            </p>
        </Link>
        </Row>
        <p className="font-bebasNeue text-3xl">ó continua con:</p>
        <div className="border rounded-full p-2 bg-gray-900 cursor-pointer">
        <GoogleSvg/>

        </div>
        
        
    </Row>
  );
}

export default LoginFooter;
