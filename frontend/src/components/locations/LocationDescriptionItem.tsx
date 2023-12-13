type LocationDescriptionItemProps = {
    image: string;
    tittle: string;
    description: string;
}

export const LocationDescriptionItem = ({locationDescription}: {locationDescription:LocationDescriptionItemProps}) => {

    return(
        <div className="flex flex-col items-center justify-center gap-3 w-[250px] h-[300px] text-center text-white font-poppins bg-slate-700 p-5 rounded-lg">
            <div className="flex justify-center items-center rounded-full bg-slate-400 p-4">
                <img className="h-[70px]" src={locationDescription.image} alt={locationDescription.tittle} />
            </div>
            <h2 className="font-bold text-lg">{locationDescription.tittle}</h2>
            <p className="h-[100px]">{locationDescription.description}</p>
        </div>
    );

}