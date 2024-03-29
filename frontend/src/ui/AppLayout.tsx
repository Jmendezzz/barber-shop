import styled from "styled-components";
import NavBar from "./NavBar";
import { Outlet } from "react-router-dom";

const StyledAppLayout = styled.div`
  display: flex;
  flex-direction:column;
  height: 100vh;
`;
const Main = styled.main`
    height:200vh;
`

function AppLayout() {
  return (
    <StyledAppLayout>
        <NavBar />
        <Main>
            <Outlet/>
        </Main>
    </StyledAppLayout>
  )
}

export default AppLayout