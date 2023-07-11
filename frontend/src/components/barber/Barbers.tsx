import background from "../../assets/images/barbers-background.jpg"

export const Barbers = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative">
      <div className="h-[300px] flex flex-col justify-end z-10">
        <h2 className="text-5xl">Nuestros barberos</h2>
      </div>
      <div className="absolute h-screen w-screen top-0 bottom-0">
        <img className="w-full h-full object-cover object-center" src={background}/>
      </div>
    </section>
  );
};
