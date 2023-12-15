import sideImage from '../../assets/images/login-side.png';
export const Login = () => {
    return (
        <section className="w-full h-screen flex justify-center items-center bg-black  ">
            <div className="w-[60%] h-[70%] flex border border-white rounded-lg">
                <div className='w-[50%] flex justify-center relative'>
                    <header className='p-10 text-center w-full'>
                        <h2 className="text-white font-bebas text-5xl">Haz tu reserva ahora</h2>
                    </header>
                    <img src={sideImage} className='absolute  bottom-0'>
                    </img>


                </div>
                <div className='w-[50%] flex flex-col items-center justify-center text-white gap-4'>
                    <header className='w-full'>
                        <h2 className='font-bebas text-5xl'>Inicia sesión</h2>
                    </header>
                    <form action="" className='w-full'>
                        <div className='w-full flex flex-col font-poppins gap-5'>
                            <input type="email" className='border-b bg-transparent p-2 w-[50%]' placeholder='Correo electrónico' />
                            <input type="password" className='border-b bg-transparent p-2 w-[50%]'  placeholder='Contraseña'/>
                            <button className=' bg-stone-700 rounded-lg p-2 w-[200px]'>Iniciar sesión</button>
                        </div>
                    </form>

                </div>

            </div>
        </section>
    );
}