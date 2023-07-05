import { motion } from "framer-motion";
type Location = {
    image: string;
    country: string;
    city: string;
    direction: string;
    description: string;
  };
export const LocationItem = (location:Location)=>{
    return(
        <motion.div
        key={location.direction}
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.9 }}
        className="relative h-full w-full flex justify-center"
      >
        <img
          className="h-full w-[90%] object-cover object-center select-none"
          src={location.image}
          alt="Location"
        />
        <div className="absolute bottom-0 h-40 bg-black w-[90%] opacity-90 min-h-30">
          <div className="p-5 text-justify w-full">
            <motion.h2
              className="text-3xl text-white"
              initial={{ opacity: 0, x: 100 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.9 }}
            >
              {location.country},{" "}
              {location.city}
            </motion.h2>
            <motion.p
              className="font-mono text-xs"
              initial={{ opacity: 0, x: 100 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.9 }}
            >
            </motion.p>
            <motion.p
              className="font-mono overscroll-y-auto select-none overflow-y-auto max-h-20 my-2"
              initial={{ opacity: 0, x: 100 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.9 }}
            >
            </motion.p>
            <motion.p
              className="font-mono overscroll-y-auto select-none overflow-y-auto max-h-20 my-2"
              initial={{ opacity: 0, x: 100 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.5 }}
            >
              {location.description}
            </motion.p>
          </div>
        </div>
    
    
      </motion.div>

    )
}