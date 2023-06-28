import {AiFillRightCircle} from 'react-icons/ai'
import {AiFillLeftCircle} from 'react-icons/ai'

export const Location = () => {
  return (
    <section className="h-screen w-screen text-white font-bebas bg-black overflow-hidden relative flex justify-center items-center">
      
      <div className='relative h-3/5 w-3/5 bg-white '>

        <AiFillLeftCircle  className='absolute top-2/4 left-0 text-black text-4xl'/>

        <AiFillRightCircle className='absolute top-2/4 right-0 text-black text-4xl'/>

      

      </div>
    </section>
  )
}
