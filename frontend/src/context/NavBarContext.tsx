import { ReactElement, createContext, useContext, useState } from 'react';

interface NavBarContextType {
  isMenuOpened: boolean;
  toggleMenu: () => void;
}

const NavBarContext = createContext<NavBarContextType | null>(null);

function NavBarContextProvider({children}: {children: ReactElement | ReactElement[]}) {
  const [isMenuOpened, setMenuOpened] = useState(false);

  function toggleMenu() {
    setMenuOpened((prev) => !prev);
  }

  return (
    <NavBarContext.Provider
      value={{
        isMenuOpened,
        toggleMenu,
      }}
    >
      {children}
    </NavBarContext.Provider>
  );
}

export function useNavBarContext(){
    const context = useContext(NavBarContext);
    if(!context){
        throw new Error("NavBarContext was used outside of the Provider");
    }
    return context;
}

export default NavBarContextProvider;
