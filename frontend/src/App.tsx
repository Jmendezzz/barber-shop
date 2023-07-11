import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "./components/ui/home/Home";
import { Nav } from "./components/ui/Nav";
import { Barbers } from "./components/barber/Barbers";
const App = () => {
  return (
    <BrowserRouter>
      <Nav />
      <Routes>

        <Route path="/" element={<Home/>}/>
        <Route path="/barbers" element={<Barbers/>}/>

      </Routes>
    </BrowserRouter>
  );
};

export default App;
