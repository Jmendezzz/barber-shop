import { Location } from "../../interfaces/Location";
import { LocationItem } from "./LocationItem";
import whiteTie from "../../assets/images/white-tie.png";
import { LocationDescriptionItem } from "./LocationDescriptionItem";
import { Link } from "react-router-dom";
const locations: Array<Location> = [
  {
    id: 1,
    image:
      "https://mldvwwasb8tu.i.optimole.com/cb:esbD~6200b/w:1100/h:733/q:90/http://travelaway.me/wp-content/uploads/2018/06/brmc-waiting.jpg",
    country: "Estados Unidos",
    city: "Nueva York",
    direction: "123 Main Street, Manhattan",
    description:
      "Nuestra sede principal se encuentra en el corazón de la ciudad de Nueva York. Ofrecemos servicios de barbería clásicos y modernos en un ambiente acogedor, elegante y clasico.",
  },
  {
    id: 2,
    image:
      "https://www.menshairstylestoday.com/wp-content/uploads/2020/10/Paul-Mole-Barber-Shop.jpg",
    country: "Estados Unidos",
    city: "Los Ángeles",
    direction: "456 Ocean Avenue, Venice Beach",
    description:
      "Disfruta de una experiencia de barbería única junto a las hermosas playas de Los Ángeles. Nuestro equipo de expertos barberos se especializa en cortes de cabello modernos y a la moda.",
  },
  {
    id: 3,
    image:
      "https://retaildesignblog.net/wp-content/uploads/2017/07/Jack-the-Clipper-flagship-barbershop-by-FormRoom-London-UK.png",
    country: "Inglaterra",
    city: "Londres",
    direction: "789 Old Street, Mayfair",
    description:
      "Ubicada en el icónico vecindario de Mayfair en Londres, nuestra sede vintage ofrece un ambiente elegante y sofisticado. Aquí, los caballeros pueden disfrutar de cortes de cabello clásicos y servicios de afeitado tradicionales.",
  },
  {
    id: 4,
    image:
      "https://assets-global.website-files.com/644a9d9ce529ef8812f82a28/647fb85c69e95444243ef9bd_Henley%27s%20Gentlemen%27s%20Grooming%20-%20Barbershop%20and%20Mens%20Grooming.webp",
    country: "Estados Unidos",
    city: "San Francisco",
    direction: "101 Innovation Road, Silicon Valley",
    description:
      "Ubicada en el corazón del innovador Silicon Valley, nuestra sede moderna combina la estética de alta tecnología con servicios de barbería de vanguardia. Nuestro equipo de barberos expertos está al tanto de las últimas tendencias en cortes de cabello y estilos modernos.",
  },
];

const locationDescriptions = [
  {
    image: whiteTie,
    tittle: "Elegancia",
    description:
      "Nuestras sedes fusionan la elegancia clásica con un toque moderno.",
  },
  {
    image: whiteTie,
    tittle: "Ubicación",
    description:
      "Estamos ubicados estratégicamente en las principales ciudades del mundo.",
  },
  {
    image: whiteTie,
    tittle: "Tecnología",
    description:
      "En nuestras sedes, la tecnología se fusiona con la elegancia y el vanguardismo",
  },
];
export const Locations = () => {
  return (
    <section className="flex justify-center h-auto w-full bg-slate-900 ">
      <div className="flex flex-col items-center justify-center pt-40 w-[70%] gap-10">
        <header className="text-white flex flex-col items-center text-center gap-10">
          <h1 className="text-5xl font-bebas">Sedes</h1>
          <p className="w-[60%] text-center text-xl font-poppins">
            Embárcate en un viaje por el mundo de la elegancia masculina con
            Gerard's Barber Shop. Nuestras sedes, meticulosamente diseñadas,
            fusionan la esencia clásica de la barbería con toques vanguardistas.
          </p>
        </header>
        <section className="flex w-full flex-wrap justify-center gap-14">
          {locationDescriptions.map((locationDescription) => (
            <LocationDescriptionItem
            key={locationDescription.tittle}
              locationDescription={locationDescription}
            />
          ))}
        </section>
        <section className="h-[65%] w-[70%] flex flex-col items-center gap-10 ">
          <header>
            <h2 className="text-5xl font-bebas text-white">Ubicaciones</h2>
          </header>
          <div className="flex justify-center gap-10 flex-wrap">
            {locations.map((location) => (
              <Link to={"/barbers"} key={location.id}>
                <LocationItem key={location.id} location={location} />
              </Link>
            ))}
          </div>
        </section>
      </div>
    </section>
  );
};
