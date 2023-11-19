import { motion } from "framer-motion";
import { EntityWithId } from "../../../interfaces/EntityWithId";

type CarouselItemProps<T extends EntityWithId> = {
    renderItem: (item: T) => JSX.Element,
    isRight: boolean | undefined,
    item: T,
};

export const CarouselItem = <T extends EntityWithId>({renderItem,isRight,item}:CarouselItemProps<T>) => {
    

    return(
        <motion.div
        className="relative h-full w-[90%] flex justify-center items-center gap-10"
        key={item.id}
        initial={{x: isRight ? 200 : -200}}
        animate={{x:0}}
        exit={{x:isRight?-200 : 200}}
        transition={{duration:0.5}}
        >
        {renderItem(item)}
        </motion.div>
    );

};
