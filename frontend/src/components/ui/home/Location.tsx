import { AiFillRightCircle } from "react-icons/ai";
import { AiFillLeftCircle } from "react-icons/ai";
import backgroundImage from "../../../assets/images/LocationsBarberBackground.jpg";
import { useState } from "react";
import { motion, AnimatePresence } from "framer-motion";

type Location = {
  image: string;
  country: string;
  city: string;
  direction: string;
  description: string;
};
const locations: Array<Location> = [
  {
    image:
      "https://mldvwwasb8tu.i.optimole.com/cb:esbD~6200b/w:1100/h:733/q:90/http://travelaway.me/wp-content/uploads/2018/06/brmc-waiting.jpg",
    country: "Estados Unidos",
    city: "Nueva York",
    direction: "123 Main Street, Manhattan",
    description:
      "Nuestra sede principal se encuentra en el corazón de la ciudad de Nueva York. Ofrecemos servicios de barbería clásicos y modernos en un ambiente acogedor, elegante y clasico.",
  },
  {
    image:
      "https://www.menshairstylestoday.com/wp-content/uploads/2020/10/Paul-Mole-Barber-Shop.jpg",
    country: "Estados Unidos",
    city: "Los Ángeles",
    direction: "456 Ocean Avenue, Venice Beach",
    description:
      "Disfruta de una experiencia de barbería única junto a las hermosas playas de Los Ángeles. Nuestro equipo de expertos barberos se especializa en cortes de cabello modernos y a la moda.",
  },
  {
    image:
      "https://retaildesignblog.net/wp-content/uploads/2017/07/Jack-the-Clipper-flagship-barbershop-by-FormRoom-London-UK.png",
    country: "Inglaterra",
    city: "Londres",
    direction: "789 Old Street, Mayfair",
    description:
      "Ubicada en el icónico vecindario de Mayfair en Londres, nuestra sede vintage ofrece un ambiente elegante y sofisticado. Aquí, los caballeros pueden disfrutar de cortes de cabello clásicos y servicios de afeitado tradicionales.",
  },
  {
    image:
      "https://freshchalk-assets.imgix.net/categories/barber-4d98c304b78acce94cb12f8745a93ecdb9c421b151c6ef99b202643db7ee040d.jpg?auto=format&ar=1%3A1&fit=max",
    country: "Estados Unidos",
    city: "San Francisco",
    direction: "101 Innovation Road, Silicon Valley",
    description:
      "Ubicada en el corazón del innovador Silicon Valley, nuestra sede moderna combina la estética de alta tecnología con servicios de barbería de vanguardia. Nuestro equipo de barberos expertos está al tanto de las últimas tendencias en cortes de cabello y estilos modernos.",
  },
];

export const Location = () => {
  const [locationIndex, setLocationIndex] = useState<number>(0);

  const rightHandler = () => {
    if (locationIndex == locations.length - 1) {
      setLocationIndex(0);
      return;
    }

    setLocationIndex((currentLocation) => currentLocation + 1);
  };
  const leftHandler = () => {
    if (locationIndex == 0) {
      setLocationIndex(locations.length - 1);
      return;
    }
    setLocationIndex((currentLocation) => currentLocation - 1);
  };
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative">
      <div className="h-[200px] flex flex-col justify-end z-10">
        <h2 className="text-5xl">Nuestras sedes</h2>
      </div>

      <div className="relative h-3/5 w-3/5 z-10">
        <motion.img
          key={locationIndex}
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 0.5 }}
          className="h-full w-full object-cover object-center"
          src={locations[locationIndex].image}
          alt="Location"
        />

        <AiFillLeftCircle
          onClick={leftHandler}
          className="absolute top-2/4 left-0 text-black text-4xl"
        />
        <AiFillRightCircle
          onClick={rightHandler}
          className="absolute top-2/4 right-0 text-black text-4xl"
        />
      </div>

      <div className="absolute h-screen w-screen top-0 bottom-0">
        <img
          className="h-full w-full object-center object-cover opacity-50"
          src={backgroundImage}
          alt="Background"
        />
      </div>
    </section>
  );
};
