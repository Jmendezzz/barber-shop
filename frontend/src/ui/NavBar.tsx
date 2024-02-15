import NavBarContextProvider from "../context/NavBarContext";
import NavMobile from "./NavMobile";



function NavBar() {
  return (
    <NavBarContextProvider>
        <NavMobile/>
    </NavBarContextProvider>
  )
}

export default NavBar