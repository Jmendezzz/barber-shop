import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "./components/ui/home/Home";
import { Nav } from "./components/ui/nav/Nav";
import { Barbers } from "./components/barber/Barbers";
import { Locations } from "./components/locations/Locations";
import { Login } from "./components/auth/Login";
const App = () => {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/" element={<Home/>}/>
        <Route path="/barbers" element={<Barbers/>}/>
        <Route path="/locations" element={<Locations/>}/>

      </Routes>
    </BrowserRouter>
  );
};

export default App;
