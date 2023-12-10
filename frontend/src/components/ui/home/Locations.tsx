import backgroundImage from "../../../assets/images/LocationsBarberBackground.jpg";


export const Locations = () => {
  return (
    <section className="h-screen w-screen bg-black text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative" id="locations">
      <div className="z-10">
        <h2 className="text-5xl">Nuestras sedes</h2>
      </div>
      

      <div className="absolute h-screen w-screen top-0 bottom-0">
        <img
          loading="lazy"
          className="h-full w-full object-center object-cover opacity-50"
          src={backgroundImage}
          alt="Background"
        />
      </div>
    </section>
  );
};
