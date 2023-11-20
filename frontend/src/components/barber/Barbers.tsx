import background from "../../assets/images/barbers-background.jpg";
import { Barber } from "../../interfaces/Barber";
import { BarberCard } from "./BarberCard";
import firstBarber from "../../assets/images/barber-1.jpg";
import { motion } from "framer-motion";
const barbers: Array<Barber> = [
  {
    id: 1,
    fullName: "Olmay Barber",
    image: firstBarber,
    stars: 5,
  },
  {
    id: 2,
    fullName: "Olmay Barber",
    image: firstBarber,
    stars: 5,
  },
  {
    id: 3,
    fullName: "Olmay Barber",
    image: firstBarber,
    stars: 5,
  },
  {
    id: 4,
    fullName: "Olmay Barber",
    image: firstBarber,
    stars: 5,
  },
];

export const Barbers = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative">
      <div className="z-10">
        <h2 className="text-5xl">Nuestros barberos</h2>
      </div>

      <motion.section
        className="flex flex-wrap gap-10 justify-around z-10"
        variants={{
          visible: {
            opacity: 1,
            scale: 1,
            transition: {
              delayChildren: 0.1,
              staggerChildren: 0.1,
            },
          },
        }}
        initial="hidden"
        animate="visible"
      >
        {barbers.map((b) => (
          <motion.div
            key={b.id}
            variants={{
              hidden: { x: -100, opacity: 0},
              visible: {
                x: 0,
                opacity: 1,
              }
            }}
          >
            <BarberCard barber={b} />
          </motion.div>
        ))}
      </motion.section>
      <div className="absolute h-screen w-screen top-0 bottom-0">
        <img
          className="w-full h-full object-cover object-center"
          src={background}
        />
      </div>
    </section>
  );
};
