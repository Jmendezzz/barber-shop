import { Location } from "../../interfaces/Location";
import { LocationItem } from "./LocationItem";
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
      "https://freshchalk-assets.imgix.net/categories/barber-4d98c304b78acce94cb12f8745a93ecdb9c421b151c6ef99b202643db7ee040d.jpg?auto=format&ar=1%3A1&fit=max",
    country: "Estados Unidos",
    city: "San Francisco",
    direction: "101 Innovation Road, Silicon Valley",
    description:
      "Ubicada en el corazón del innovador Silicon Valley, nuestra sede moderna combina la estética de alta tecnología con servicios de barbería de vanguardia. Nuestro equipo de barberos expertos está al tanto de las últimas tendencias en cortes de cabello y estilos modernos.",
  },
];
export const Locations = () => {
  return (
    <section className="flex flex-col items-center justify-center h-auto w-screen bg-black">
      <div className="p-40">
      <header className="text-white flex flex-col items-center ">
        <h1 className="text-5xl font-bebas">Nuestras Sedes</h1>
        <p>
          Embárcate en un viaje por el mundo de la elegancia masculina con
          Gerard's Barber Shop. Nuestras sedes, meticulosamente diseñadas,
          fusionan la esencia clásica de la barbería con toques vanguardistas.
          Desde la vibrante energía de nuestras ubicaciones hasta la atención
          personalizada que ofrecemos, cada visita es una experiencia que va más
          allá de un simple corte de pelo. ¡Descubre la sofisticación en cada
          detalle con nosotros!
        </p>
      </header>
      <section className="h-[65%] w-full flex flex-col items-center">
        {locations.map((location) => (
          <LocationItem key={location.id} location={location} />
        ))}
      </section>
      </div>
      
    </section>
  );
};
