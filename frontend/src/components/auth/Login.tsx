import sideImage from "../../assets/images/login-side.png";
export const Login = () => {
  return (
    <section className="w-full h-screen flex justify-center items-center bg-black  ">
      <div className="w-[60%] h-[70%] flex border border-white rounded-lg">
        <div className="w-[50%] flex justify-center hidden laptop:relative laptop:block">
          <header className="p-10 text-center w-full">
            <h2 className="text-white font-bebas text-5xl">
              Haz tu reserva ahora
            </h2>
          </header>
          <div className="absolute bottom-0 flex justify-center w-full">
            <img src={sideImage} className="max-h-[550px]"/>
          </div>
        </div>
        <div className=" laptop:w-[50%] w-full flex flex-col items-center justify-center text-white gap-4">
          <header className="w-full laptop:text-left text-center">
            <h2 className="font-bebas text-5xl">Inicia sesión</h2>
          </header>
          <form action="" className="w-full">
            <div className="w-full flex flex-col items-center laptop:items-start font-poppins gap-5">
              <input
                type="email"
                className="border-b bg-transparent p-2 w-[60%] focus:outline-none focus:border-yellow-500"
                placeholder="Correo electrónico"
              />
              <input
                type="password"
                className="border-b bg-transparent p-2 w-[60%] focus:outline-none focus:border-yellow-500"
                placeholder="Contraseña"
              />
              <button className=" bg-stone-700 rounded-lg p-2 w-[200px] hover:bg-yellow-500 hover:text-white transition-all">
                Iniciar sesión
              </button>
            </div>
          </form>
          
        </div>
      </div>
    </section>
  );
};
