import { useState, useEffect } from 'react';
import { AiOutlineLeft, AiOutlineRight } from 'react-icons/ai';
interface CarouselProps<T> {
    items: T[];
    renderItem: (item: T) => JSX.Element;
  }
  
 export const Carousel = <T,>({ items, renderItem }: CarouselProps<T>) => {
    const [currentIndex, setCurrentIndex] = useState<number>(0);
  
    const handleRightClick = () => {
      setCurrentIndex((prevIndex) => (prevIndex + 1) % items.length);
    };
  
    const handleLeftClick = () => {
      setCurrentIndex((prevIndex) => (prevIndex - 1 + items.length) % items.length);
    };
  
    useEffect(() => {
      const interval = setInterval(handleRightClick, 5000);
  
      return () => {
        clearInterval(interval);
      };
    }, []);
  
    return (
      <div className="relative h-3/5 w-3/5 z-10 flex justify-center">
        {renderItem(items[currentIndex])}
 
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
  