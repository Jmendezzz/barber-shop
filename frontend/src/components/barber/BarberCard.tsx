import { Barber } from "../../interfaces/Barber";


export const BarberCard = ({barber} : {barber:Barber} ): JSX.Element=>{

    return(
        <h1>
            {barber.fullName}
        </h1>
    )

}