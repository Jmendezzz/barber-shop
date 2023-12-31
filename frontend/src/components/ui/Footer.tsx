import logo from "../../assets/images/GerardBarberShopLogo.png";
import { AiOutlineCopyrightCircle } from "react-icons/ai";
export const Footer = (): JSX.Element => {
  return (
    <footer className="w-full backdrop-blur-lg overflow-hidden z-10 flex flex-col justify-center items-center gap-4 ">
      <div className="flex justify-center w-full mt-3">
        <img src={logo} />
      </div>

      <div className="flex items-center mb-4">
        <p >Developed by Juan Gerardo</p>
        <AiOutlineCopyrightCircle className="relative bottom-[1.2px]" />
      </div>
    </footer>
  );
};
