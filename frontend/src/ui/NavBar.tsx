import NavBarContextProvider from "../context/NavBarContext";
import NavMobileMenu from "./NavMobileMenu";



function NavBar() {
  return (
    <NavBarContextProvider>
        <NavMobileMenu/>
    </NavBarContextProvider>
  )
}

export default NavBar