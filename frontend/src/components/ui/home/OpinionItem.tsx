import { Opinion } from "../../../interfaces/Opinion";
import { motion } from "framer-motion";

export const OpinionItem = (opinion:Opinion)=>{
    return(
        <>
        <img className="rounded-full w-[300px] h-[300px]" src={opinion.client.profileImage}/>
        <div className="flex justify-center flex-col">
          <h2 className="text-5xl py-10">{opinion.client.fullName}</h2>
          <p className="text-justify font-workSans">"{opinion.opinion}"</p>

        </div>
      </>

    )
}