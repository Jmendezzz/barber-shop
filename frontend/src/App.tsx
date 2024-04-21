import { BrowserRouter, Route, Routes } from "react-router-dom"
import { GlobalStyles } from "./styles/GlobalStyles"
import AppLayout from "./ui/AppLayout"
import Home from "./pages/Home"
import Login from "./pages/Login"
import Register from "./pages/Register"
import NotFoundError from "./ui/NotFoundError"
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
        <Route element ={<NotFoundError/>} path="/*"/>
      </Route>
    </Routes>

  </BrowserRouter>
  </>

 )
}

export default App
