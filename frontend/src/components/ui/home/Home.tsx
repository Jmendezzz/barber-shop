import video from "../../../assets/videos/main-video.mp4";
import { Locations } from "./Locations";
import { Opinions } from "./Opinions";
import { History } from "./History";
export const Home = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas bg-black overflow-x-hidden relative" id="home">
      <main className="snap-y snap-mandatory relative h-screen w-screen overflow-auto overflow-x-hidden">
        <div className="h-full flex flex-col justify-center items-center relative snap-center">
          <header className="z-20  text-5xl flex justify-center">
            <h2 className="w-3/5 text-center">
              Sumérgete en un viaje histórico de estilo y precisión en nuestra
              barbería exclusiva
            </h2>
          </header>

          <footer className="z-20 h-1/4 flex items-end text-2xl ">
            <a className="border-[3px] py-3 px-8 backdrop-blur-2xl cursor-pointer transition-all hover:bg-white hover:text-black">
              RESERVA AHORA
            </a>
          </footer>

          <div className="opacity-40 top-0 bottom-0 absolute">
            <video
              className="object-center object-cover h-full w-screen"
              autoPlay
              muted
              loop
              src={video}
            ></video>
          </div>
        </div>

        <div className="snap-center">
          <History/>
        </div>
        <div className="snap-start">
          <Opinions/>
        </div>

      </main>
    </section>
  );
};
