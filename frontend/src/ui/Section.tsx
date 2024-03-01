import styled from "styled-components";
import { device } from "../styles/devices";

const Section = styled.section`
    min-height:'768px';
    padding:50px 10px;
    @media (min-width: ${device.desktop}){
        padding:50px 15rem;
        }
`

export default Section;