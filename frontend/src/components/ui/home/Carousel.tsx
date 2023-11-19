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
      <div className="relative h-3/5 w-3/5 z-10 flex justify-center">
        <CarouselItem  renderItem={renderItem} isRight={isRight} item={items[currentIndex]} />
        <AiOutlineLeft
          onClick={handleLeftClick}
          className="absolute top-2/4 left-0 text-yellow-300 text-5xl cursor-pointer font-extrabold transition-transform hover:scale-125 hover:-translate-z-1"
        />
        <AiOutlineRight
          onClick={handleRightClick}
          className="absolute top-2/4 right-0 text-yellow-300 text-5xl cursor-pointer font-extrabold transition-transform hover:scale-125 hover:-translate-z-1 select-none"
        />
      </div>
    );
  };
  