import background from "../../assets/images/barbers-background.jpg"
import { Barber } from "../../interfaces/Barber";
import {BarberCard} from "./BarberCard";
import firstBarber from "../../assets/images/barber-1.jpg";

const barbers: Array<Barber> = [
  {
    fullName : 'Olmay Barber',
    image : firstBarber,
    stars : 5
  }
]

export const Barbers = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas overflow-hidden flex flex-col gap-9 justify-center items-center relative">
      <div className="z-10">
        <h2 className="text-5xl">Nuestros barberos</h2>
      </div>
      <section className="flex flex-wrap-gap-3 justify-around z-10" >
        {barbers.map((b)=>(
          <BarberCard barber={b}    />

        ))}

      </section>
      <div className="absolute h-screen w-screen top-0 bottom-0">
        <img className="w-full h-full object-cover object-center" src={background}/>
      </div>
    </section>
  );
};
