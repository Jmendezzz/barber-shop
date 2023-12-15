import founder from "../../../assets/images/founder.png";
import team from "../../../assets/images/about-us.jpg";
export const History = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex justify-center">
      <div className="flex flex-col items-center justify-center pt-40 w-[50%] gap-5">
        <header>
          <h1 className="text-5xl text-yellow-300">Sobre nosotros</h1>
        </header>
        <p className="text-xl font-poppins text-center">
          Descubre el arte de la barbería clásica y elegante en Gerard's Barber
          Shop. Nuestros barberos expertos te brindarán una experiencia única y
          personalizada.
        </p>
        <img
          className="h-[350px] w-[50%] object-cover object-center  "
          src={team}
          alt=""
        />
        <section className="w-full text-xl font-poppins">
          <p>
            Fundada en 2021 por Juan Gerardo, nuestra pasión por la barbería se
            ha convertido en un proyecto profesional que combina habilidad e
            innovación.
          </p>
          <p>
            Mientras cursaba Ingeniería de Software, Juan concibió la idea de
            fusionar la tecnología con el arte de la barbería. En 2023, hizo
            realidad esta visión, creando una experiencia fluida e innovadora
            para nuestros clientes.
          </p>
        </section>
        <section className="flex w-full items-center justify-center h-[400px] gap-10 ">
          <div className="flex flex-col items-center font-poppins">
            <p>Presencia en</p>
            <h2 className="text-3xl text-yellow-300">+3 paises</h2>
            <p>y 5 ciudades</p>
          </div>
          <div className="flex flex-col items-center font-poppins">
            <p>Presencia en</p>
            <h2 className="text-3xl text-yellow-300">+3 paises</h2>
            <p>y 5 ciudades</p>
          </div>

        </section>
      </div>
    </section>
  );
};
