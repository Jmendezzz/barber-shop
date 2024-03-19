import { BrowserRouter, Route, Routes } from "react-router-dom"
import { GlobalStyles } from "./styles/GlobalStyles"
import AppLayout from "./ui/AppLayout"
import Home from "./pages/Home"
import Login from "./pages/Login"
import Register from "./pages/Register"
function App() {
 return(
  <>
    <GlobalStyles/>
    <BrowserRouter>
    <Routes>
      <Route element={<Login/>} path="/login"/>
      <Route element={<Register />} path="/register" />
      <Route element={<AppLayout/>}>
        <Route element={<Home/>} index path="/"/>
      </Route>
    </Routes>
  </BrowserRouter>
  </>

 )
}

export default App
