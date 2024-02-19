import { createGlobalStyle } from 'styled-components';
import { device } from './devices';

export const GlobalStyles = createGlobalStyle`
    :root{
        --primary-color: #0f172a;
        --secondary-color: #1e293b;
        --contrast-color: #ffe815;
        //Box shadow
        --shadow-sm: 0 1px 2px rgba(0, 0, 0, 0.04); 
        --shadow-md: 0px 0.6rem 2.4rem rgba(0, 0, 0, 0.06);
        --shadow-lg: 0 2.4rem 3.2rem rgba(0, 0, 0, 0.12);

        //Border radius
        --border-radius-tiny: 3px;
        --border-radius-sm: 5px;
        --border-radius-md: 7px;
        --border-radius-lg: 9px;

        //Screen sizes
        --mobile: 480px;
        --tablet-size: 481px;
        --laptop: 769px;
        --desktop:1280px;
    }
        *,
        *::before,
        *::after {
        box-sizing: border-box;
        padding: 0;
        margin: 0;

        /* Creating animations for dark mode */
        transition: background-color 0.3s, border 0.3s;
        }

        button {
        cursor: pointer;
        font-family: "Bebas Neue", sans-serif;

        }

        *:disabled {
        cursor: not-allowed;
        }
        body {
        font-family: "Inter", sans-serif;
        transition: color 0.3s, background-color 0.3s;
        min-height: 100vh;
        font-size: 1.rem;
        overflow-x:hidden;
     
        }
        main{
            overflow-x:hidden;

        }
        
        @media (max-width: ${device.laptop}) {
            main{
                padding-top:85px;
                outline:0;
            }
            
        }

        p,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
        overflow-wrap: break-word;
        hyphens: auto;
        color:white
        }

        a {
        color: inherit;
        text-decoration: none;
        }

    ul {
        list-style: none;
        }
`;