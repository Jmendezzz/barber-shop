import { Opinion } from "../../../interfaces/Opinion";
import { motion } from "framer-motion";

export const OpinionItem = (opinion:Opinion)=>{
    return(
        <motion.div 
        className="relative h-full w-[90%] flex justify-center items-center  gap-10"
        key={opinion.client.fullName}
        initial={{x:200}}
        animate={{x:0}}
        exit={{x:-200}}
        transition={{duration:0.5}}
        >
        <img className="rounded-full w-[300px] h-[300px]" src={opinion.client.profileImage}/>
        <div className="">
          <h2 className="text-5xl py-10">{opinion.client.fullName}</h2>
          <p className="text-justify font-workSans w-[80%]">"{opinion.opinion}"</p>

        </div>
      </motion.div>

    )
}