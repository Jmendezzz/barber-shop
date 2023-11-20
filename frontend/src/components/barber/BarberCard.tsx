import { Barber } from "../../interfaces/Barber";

export const BarberCard = ({ barber }: { barber: Barber }): JSX.Element => {
  return (
    <div className="flex flex-col items-center hover:bg-black hover:bg-opacity-80 hover:cursor-pointer transition-all ">
        <img src={barber.image} alt={"Foto de " + barber.fullName} className="h-[400px] select-none" />
        <h1 className="text-3xl">{barber.fullName}</h1>
        <div className="flex gap-2 select-none">
          <span>⭐</span>
          <span>⭐</span>
          <span>⭐</span>
          <span>⭐</span>
          <span>⭐</span>
        </div>
    </div>
  );
};
