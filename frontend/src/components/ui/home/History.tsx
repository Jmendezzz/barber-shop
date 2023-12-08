export const History = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative select-none">
      <h1 className="text-5xl">Sobre nosotros</h1>
      <section className="w-[70%]">
        <section>
          <h2 className="text-3xl text-yellow-300">
            Bienvenido a Gerard's Barber Shop
          </h2>
          <p className="text-xl font-serif ">
            Descubre el arte del cuidado personal con nosotros. Fundada en 2021
            por Juan Gerardo, nuestra pasión por la barbería se ha convertido en
            un proyecto profesional que combina habilidad e innovación.
          </p>
        </section>
        <br/>
        <section>
          <h2 className="text-3xl text-yellow-300">
            La Trayectoria de Nuestro Fundador
          </h2>
          <p className="text-xl font-serif ">
            En 2021, Juan Gerardo comenzó a perfeccionar su arte con familiares
            y amigos. Para 2022, sus habilidades se refinaron, y vio el
            potencial de crear una experiencia única en la barbería.
          </p>
        </section>
        <br/>
        <section>
          <h2 className="text-3xl text-yellow-300">
            Fusión de Barbería y Tecnología
          </h2>

          <p className="text-xl font-serif ">
            Mientras cursaba Ingeniería de Software, Juan concibió la idea de
            fusionar la tecnología con el arte de la barbería. En 2023, hizo
            realidad esta visión, creando una experiencia fluida e innovadora
            para nuestros clientes.
          </p>
        </section>
      </section>
    </section>
  );
};
