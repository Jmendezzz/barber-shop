import GoogleSvg from "./GoogleSvg";
import Row from "./Row";

function LooginFooter() {
  return (
    <Row center={true}>
        <Row type="horizontal" center={true} gap={1}>
        <span className="text-white text-sm">¿No tienes cuenta?</span>
        <a href="#" className="underline text-sm text-white">
            Registrate
        </a>
        </Row>
        <p className="font-bebasNeue">ó continua con:</p>
        <div className="border rounded-full p-2 bg-gray-900 cursor-pointer">
        <GoogleSvg/>

        </div>
        
        
    </Row>
  );
}

export default LooginFooter;
