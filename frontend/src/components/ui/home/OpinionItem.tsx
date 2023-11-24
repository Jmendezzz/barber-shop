import { Opinion } from "../../../interfaces/Opinion";

export const OpinionItem = (opinion:Opinion)=>{
    return(
        <div className="flex flex-col justify-center w-[300px] laptop:w-auto items-center laptop:flex-row laptop:gap-9 max-w-[1200px]">
        <img className="rounded-full w-[300px] h-[300px]" src={opinion.client.profileImage}/>
        <div className="flex justify-center flex-col laptop:items-center">
          <h2 className="text-5xl py-5 w-full text-center laptop:text-left">{opinion.client.fullName}</h2>
          <p className="text-justify font-workSans overflow-y-auto  overscroll-y-auto max-h-48 pr-4">"{opinion.opinion}"</p>
        </div>
      </div>

    )
}