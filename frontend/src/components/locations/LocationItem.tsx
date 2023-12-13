import { motion } from "framer-motion";
import { Location } from "../../interfaces/Location";

export const LocationItem = ({location}: {location:Location})=>{
    return(
      <div className="flex flex-col text-white font-poppins cursor-pointer transition-all hover:scale-110 select-none">
        <img className="w-[280px] h-[240px] object-cover object-center" src={location.image} alt={location.description} />
        <h2>{location.country}</h2>
      </div>

    )
}