import logo from "../../assets/images/GerardBarberShopLogo.png";
import { HiOutlineUserCircle } from "react-icons/hi";

export const Nav = () => {
  return (
    <nav className="h-28 fixed z-10 w-full ">
      <ul className="list-none flex  w-full  text-white text-3xl font-bebas ">
        <div className="flex-grow w-96">

        </div>
        <div className="flex items-center justify-evenly gap-x-10 w-[50%]">
          <li  className="w-32">
            <a className=" hover:border-b-4 border-transparent hover:border-y-yellow-300 cursor-pointer">INICIO</a>
          </li>
          <li  className="w-32">
            <a className=" hover:border-b-4 border-transparent hover:border-y-yellow-300 cursor-pointer">Sedes</a>
          </li>


          <li >
            <img src={logo}></img>
          </li>

          <li  className="w-32">
            <a className=" hover:border-b-4 border-transparent hover:border-y-yellow-300 cursor-pointer">Reservas</a>
          </li>
          <li  className="w-32">
            <a className=" hover:border-b-4 border-transparent hover:border-y-yellow-300 cursor-pointer">Barberos</a>
          </li>
    
        </div>

        <div className=" flex items-center justify-end w-96 flex-grow" >
          <HiOutlineUserCircle className="text-4xl mx-4" />
        </div>
      </ul>
    </nav>
  );
};
