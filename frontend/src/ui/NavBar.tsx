import NavBarContextProvider from "../context/NavBarContext";
import NavDesktop from "./NavDesktop";
import NavMobileMenu from "./NavMobileMenu";



function NavBar() {
  return (
    <NavBarContextProvider>
        <NavMobileMenu/>
        <NavDesktop/>
    </NavBarContextProvider>
  )
}

export default NavBar