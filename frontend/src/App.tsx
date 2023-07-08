import { Footer } from "./components/ui/Footer";
import { Home } from "./components/ui/home/Home";
import { Nav } from "./components/ui/Nav";
const App = () => {
  return (
    <div className="flex flex-col h-screen relative ">
      <Nav />
      <Home />
    </div>
  );
};

export default App;
