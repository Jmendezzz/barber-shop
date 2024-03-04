import NavBarContextProvider from "../context/NavBarContext";
import MenuMobile from "./MenuMobile";
import NavDesktop from "./NavDesktop";



function NavBar() {
  return (
    <NavBarContextProvider>
        <NavDesktop/>
        <MenuMobile/>
    </NavBarContextProvider>
  )
}

export default NavBar