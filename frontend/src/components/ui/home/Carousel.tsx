import { useState } from 'react';
import { AiOutlineLeft, AiOutlineRight } from 'react-icons/ai';
import { CarouselItem } from './CarouselItem';
import { EntityWithId } from '../../../interfaces/EntityWithId';
interface CarouselProps<T extends EntityWithId> {
    items: T[];
    renderItem: (item: T) => JSX.Element;
  }
  
 export const Carousel = <T extends EntityWithId>({ items, renderItem }: CarouselProps<T>) => {
    const [currentIndex, setCurrentIndex] = useState<number>(0);
    const [isRight, setIsRight] = useState<boolean>();
  
    const handleRightClick = () => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % items.length);
      setIsRight(true);
    };
  
    const handleLeftClick = () => {
      setCurrentIndex((prevIndex) => (prevIndex - 1 + items.length) % items.length);
      setIsRight(false);
    };
  

  
    return (
      <div className="flex gap-2 h-3/5 w-[90%] z-10 justify-center items-center">
        <AiOutlineLeft
          onClick={handleLeftClick}
          className="z-10 block text-yellow-300 text-5xl cursor-pointer font-extrabold transition-transform hover:scale-125 hover:-translate-z-1"
        />
          <CarouselItem  renderItem={renderItem} isRight={isRight} item={items[currentIndex]} />

        <AiOutlineRight
          onClick={handleRightClick}
          className="<-10 block text-yellow-300  text-5xl cursor-pointer font-extrabold transition-transform hover:scale-125 hover:-translate-z-1 select-none"
        />
      </div>
    );
  };
  