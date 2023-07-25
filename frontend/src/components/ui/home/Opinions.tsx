import background from "../../../assets/images/OpinionsBackground.jpg";
import { Opinion } from "../../../interfaces/Opinion";
import firstClient from "../../../assets/images/client-1-image.png"
import secondClient from "../../../assets/images/client-2-image.jpg"
import thirdClient from "../../../assets/images/client-3-image.jpg"

import { Carousel } from "./Carousel";
import { OpinionItem } from "./OpinionItem";
import { Footer } from "../Footer";

const opinions: Array<Opinion> = [
  {
    client: {
      profileImage: firstClient,
      fullName: "Juan Gerardo",
    },
    opinion:
      "¡La Barbería de Gerard es simplemente excepcional! Cada vez que entro, me siento transportado a la época dorada de la barbería. Los barberos son verdaderos artistas, dominan a la perfección los cortes clásicos y siempre logran que me vea elegante y sofisticado. ¡No puedo recomendarlos lo suficiente!",
  },
  {
    client: {
      profileImage: secondClient,
      fullName: "Lucas Lautaro",
    },
    opinion:
      "Si buscas una experiencia de barbería auténtica, no puedes dejar de visitar la Barbería de Gerard. Sus sedes son como oasis de tradición en medio de la modernidad. Cada detalle, desde la música hasta el aroma a cuero, te hace sentir como si estuvieras en otra época. Los barberos son verdaderos maestros y siempre me sorprenden con cortes de cabello impecables. ¡Sin duda, la mejor barbería en la ciudad!",
  },
  {
    client: {
      profileImage: thirdClient,
      fullName: "Jhon Alexander",
    },
    opinion:
      "La Barbería de Gerard es mi lugar favorito para obtener un corte de cabello clásico y elegante. La atención al detalle es incomparable, desde el trato amable hasta los productos de alta calidad que utilizan. Cada vez que salgo de allí, me siento rejuvenecido y con una confianza renovada. Definitivamente, recomiendo a todos aquellos que busquen un estilo tradicional y una experiencia única.",
  },
];
export const Opinions = () => {
  return (
    <section className="h-[120vh] w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative" >
      <div className="h-[90%] w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative" >
        <div className=" z-10">
          <h2 className="text-5xl">Opiniones de nuestros clientes</h2>
        </div>
        <Carousel items={opinions} renderItem={OpinionItem} />

        <div className=" absolute h-screen w-screen top-0 bottom-0 ">
          <img
            src={background}
            className="h-full w-full object-cover object-center opacity-50"
          />
        </div>

      </div>

      <Footer />
    </section>
  );
};
